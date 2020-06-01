package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogQuestionDao;
import cn.shrmus.blog.mapper.BlogQuestionMapper;
import cn.shrmus.blog.mapper.BlogUserMapper;
import cn.shrmus.blog.pojo.BlogQuestion;
import cn.shrmus.blog.pojo.BlogQuestionExample;
import cn.shrmus.blog.pojo.BlogQuestionExample.Criteria;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.QuestionService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private BlogQuestionMapper blogQuestionMapper;
	@Autowired
	private BlogUserMapper blogUserMapper;
	@Resource(name = "httpSolrClientQuestion")
	private SolrClient solrClient;
	@Autowired
	private BlogQuestionDao blogQuestionDao;

	
	
	private List<BlogQuestion> getShortArticleContentList(List<BlogQuestion> blogArticleList){
		for(BlogQuestion blogArticle : blogArticleList) {
			String articleContent = blogArticle.getQuestionContent();
			articleContent = articleContent.replaceFirst("<p>", "");
			int length = articleContent.length();
			if(length > 100) {
				articleContent = articleContent.substring(0,100);
			}
			blogArticle.setQuestionContent(articleContent);
		}
		return blogArticleList;
	}
	
	
	/**
	 * 添加索引
	 */
	@Override
	public void indexImport() {
		try {
			// 先查询所有数据
			BlogQuestionExample blogQuestionExample = new BlogQuestionExample();
			List<BlogQuestion> questionList = blogQuestionMapper.selectByExampleWithBLOBs(blogQuestionExample);
			// 遍历数据添加到索引库
			for(BlogQuestion question:questionList) {
				// 创建文档对象
				SolrInputDocument solrInputDocument = new SolrInputDocument();
				solrInputDocument.addField("id", question.getQuestionId());
				solrInputDocument.addField("questionTitle", question.getQuestionTitle());
				solrInputDocument.addField("questionContent", question.getQuestionContent());
				// 向文档中添加域
				solrClient.add(solrInputDocument);
			}
			// 提交
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关键字查询
	 */
	@Override
	public List<BlogQuestion> indexSearch(String queryString) {
		// 创建一个SolrQuery对象
		SolrQuery solrQuery = new SolrQuery();
		// 设置查询条件、过滤条件、分页条件、排序条件、高亮
//				solrQuery.setQuery("article_title:"+queryString+" or article_content:"+queryString);
		solrQuery.set("q", "questionTitle:"+queryString+" or questionContent:"+queryString);
		// 分页条件
		solrQuery.setStart(0);
		solrQuery.setRows(20);
		// 设置默认搜索域
		solrQuery.set("df", "question_keywords");
		// 设置高亮
		solrQuery.setHighlight(true);
		// 高亮显示的域
		solrQuery.addHighlightField("questionTitle");
		solrQuery.addHighlightField("questionContent");
		solrQuery.setHighlightSimplePre("<span style='color:red;'>");
		solrQuery.setHighlightSimplePost("</span>");
		List<BlogQuestion> questionList = new ArrayList<BlogQuestion>();
		try {
			questionList = blogQuestionDao.search(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 封装其他属性
		int length = questionList.size();
		for(int i = 0; i < length; i++) {
			BlogQuestion blogQuestion = questionList.get(0);
			BlogQuestion temp = blogQuestionMapper.selectByPrimaryKey(blogQuestion.getQuestionId());
			temp.setQuestionTitle(blogQuestion.getQuestionTitle());
			temp.setQuestionContent(blogQuestion.getQuestionContent());
			questionList.add(temp);
			questionList.remove(blogQuestion);
		}
		return questionList;
	}
	
	/**
	 * 采纳
	 */
	@Transactional
	public void accpetQuestion(Integer questionId, Integer answerId, Integer userIdReply) {
		// 查出提问的悬赏积分
		BlogQuestion blogQuestion = blogQuestionMapper.selectByPrimaryKey(questionId);
		// 修改回答已采纳
		BlogQuestion answer = blogQuestionMapper.selectByPrimaryKey(answerId);
		answer.setQuestionAccpeted(1);
		// 修改受采纳的用户积分
		BlogUser blogUser = blogUserMapper.getUserByUserId(userIdReply);
		blogUser.setIntegral(blogUser.getIntegral() + blogQuestion.getQuestionIntegral());
		blogQuestionMapper.updateByPrimaryKeyWithBLOBs(answer);
		blogUserMapper.updateUser(blogUser);
	}
	
	/**
	 * 根据id查看提问的信息
	 */
	@Override
	public BlogQuestion getQuestionById(Integer questionId) {
		BlogQuestion blogQuestion = blogQuestionMapper.selectByPrimaryKey(questionId);
		return blogQuestion;
	}
	
	/**
	 * 添加提问
	 */
	@Transactional
	public void addQuestion(BlogQuestion blogQuestion) {
		// 初始化其他属性
		blogQuestion.setUserIdAuthor(blogQuestion.getBlogUserAuthor().getId());
		blogQuestion.setQuestionPublishTime(new Date());
		blogQuestionMapper.insert(blogQuestion);
		indexImport();
	}
	
	/**
	 * 查询所有问答信息
	 */
	@Override
	public List<BlogQuestion> getQuestionList(){
		BlogQuestionExample blogQuestionExample = new BlogQuestionExample();
		blogQuestionExample.setOrderByClause("question_id desc");
		Criteria criteria = blogQuestionExample.createCriteria();
		criteria.andQuestionPidEqualTo(0);
		List<BlogQuestion> blogQuestionList = blogQuestionMapper.selectByExampleWithBLOBs(blogQuestionExample);
		List<BlogQuestion> shortArticleContentList = getShortArticleContentList(blogQuestionList);
		return shortArticleContentList;
	}

}
