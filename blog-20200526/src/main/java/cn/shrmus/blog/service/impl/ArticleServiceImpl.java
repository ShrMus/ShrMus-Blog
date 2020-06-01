package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.*;
import cn.shrmus.blog.pojo.*;
import cn.shrmus.blog.pojo.BlogArticleExample.Criteria;
import cn.shrmus.blog.service.ArticleService;
import cn.shrmus.blog.utils.FastDFSClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private BlogArticleTypeMapper blogArticleTypeMapper;
	@Autowired
	private BlogArticleMapper blogArticleMapper;
	@Autowired
	private BlogUserMapper blogUserMapper;
	@Resource(name = "httpSolrClientArticle")
	private SolrClient solrClient;
	@Autowired
	private BlogArticleDao blogArticleDao;
	@Autowired
	private BlogArticleCommentMapper blogArticleCommentMapper;
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Value("${TRACKER_SERVER_CONFIG_PATH}")
	private String TRACKER_SERVER_CONFIG_PATH;
	
	/**
	 * 上传图片
	 */
	public String uploadPicture(MultipartFile uploadFile) {
		String serverurl = "";
		FastDFSClient fastDFSClient = null;
		try {
			// 取文件名
			String originalFilename = uploadFile.getOriginalFilename();
			// 取扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			// 上传到图片服务器
			fastDFSClient = new FastDFSClient(TRACKER_SERVER_CONFIG_PATH);
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			serverurl = IMAGE_SERVER_URL + url;
		} catch (Exception e) {
			if(!"".equals(serverurl)) {
				String picturePath = serverurl.replace(IMAGE_SERVER_URL, "");
				fastDFSClient.delete_file(picturePath);
			}
			e.printStackTrace();
		}
		return serverurl;
	}
	
	/**
	 * 查找最新发表的文章
	 */
	public List<BlogArticle> getArticleListNew(){
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_id desc");
		blogArticleExample.setOffset(0);
		blogArticleExample.setLimit(5);
		Criteria criteria = blogArticleExample.createCriteria();
		criteria.andArticleIspassEqualTo(1);
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
//	private List<BlogArticle> getShortArticleContentList(List<BlogArticle> blogArticleList){
//		for(BlogArticle blogArticle : blogArticleList) {
//			String articleContent = blogArticle.getArticleContent();
//			articleContent = articleContent.replaceFirst("<p>", "");
//			int length = articleContent.length();
//			if(length > 100) {
//				articleContent = articleContent.substring(0,100);
//			}
//			blogArticle.setArticleContent(articleContent);
//		}
//		return blogArticleList;
//	}
	
	/**
	 * 查找被推荐的文章
	 */
	public List<BlogArticle> getArticleListByTop(){
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_count_click desc");
		Criteria criteria = blogArticleExample.createCriteria();
		criteria.andArticleTopEqualTo(1);
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 设置推荐文章
	 */
	@Transactional
	public void setTopArticleList(List<BlogArticle> blogArticleList) {
		for(BlogArticle blogArticle : blogArticleList) {
			blogArticleMapper.updateByPrimaryKeySelective(blogArticle);
		}
	}
	
	/**
	 * 浏览量从高到低查找
	 */
	public List<BlogArticle> getArticleListByTopUI() {
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_count_click desc");
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 查找最火的5篇文章
	 */
	public List<BlogArticle> getArticleListByHot() {
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_count_click desc");
		blogArticleExample.setOffset(0);
		blogArticleExample.setLimit(5);
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 根据文章类型查找文章
	 */
	public List<BlogArticle> getArticleListByArticleTypeId(Integer articleTypeId){
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_id desc");
		Criteria criteria = blogArticleExample.createCriteria();
		criteria.andArticleTypeIdEqualTo(articleTypeId);
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 修改审核的信息
	 */
	@Transactional
	public void updatePassArticle(BlogArticle blogArticle) {
		// 发表文章审核通过加2积分
		BlogUser blogUser = blogUserMapper.getUserByUserId(blogArticle.getUserId());
		//blogUser.setIntegral(blogUser.getIntegral() + 2);
		blogArticleMapper.updateByPrimaryKeySelective(blogArticle);
		//blogUserMapper.updateUser(blogUser);
		indexImport();
	}
	
	/**
	 * 查找发表之后没有审核的文章
	 */
	public List<BlogArticle> getArticlePassing(){
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_id desc");
		Criteria criteria = blogArticleExample.createCriteria();
		criteria.andArticleIspassEqualTo(2);
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 查找某个用户发表的博客
	 */
	public List<BlogArticle> getArticleListByUserId(Integer userId){
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_id desc");
		Criteria criteria = blogArticleExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
		//blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 查找所有发表的文章
	 * @param top
	 * @param ispass
	 * @return
	 */
	public List<BlogArticle> getArticleList(Integer top, Integer ispass){
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		blogArticleExample.setOrderByClause("article_id desc");
		Criteria criteria = blogArticleExample.createCriteria();
		if(null != top) {
			criteria.andArticleTopEqualTo(top);  // 0（默认）表示不推荐，1表示推荐
		}
		if(null != ispass) {
			criteria.andArticleIspassEqualTo(ispass);  // 审核，0未通过，1通过，2（默认）审核中
		}
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExample(blogArticleExample);
		blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		return blogArticleList;
	}
	
	/**
	 * 添加文章评论
	 */
	@Transactional
	public void addArticleComment(BlogArticleComment blogArticleComment) {
		blogArticleComment.setArticleCommentPublishTime(new Date());
		blogArticleCommentMapper.insert(blogArticleComment);
	}

	/**
	 * 删除文章评论
	 */
	@Transactional
	public void deleteArticleCommentByArticleCommentId(Integer articleCommentId) {
		BlogArticleComment blogArticleComment = blogArticleCommentMapper.selectByPrimaryKey(articleCommentId);
		List<BlogArticleComment> blogArticleCommentList = blogArticleComment.getBlogArticleCommentList();
		for(BlogArticleComment articleComment : blogArticleCommentList) {
			blogArticleCommentMapper.deleteByPrimaryKey(articleComment.getArticleCommentId());
		}
		blogArticleCommentMapper.deleteByPrimaryKey(articleCommentId);
		indexImport();
	}
	
	/**
	 * 全站搜索，创建索引
	 */
	@Override
	public void indexImport() {
		try {
			// 先查询所有数据
			BlogArticleExample blogArticleExample = new BlogArticleExample();
			Criteria criteria = blogArticleExample.createCriteria();
			criteria.andArticleIspassEqualTo(1);
			List<BlogArticle> articleList = blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
			// 遍历数据添加到索引库
			for(BlogArticle article:articleList) {
				// 创建文档对象
				SolrInputDocument solrInputDocument = new SolrInputDocument();
				solrInputDocument.addField("id", article.getArticleId());
				solrInputDocument.addField("articleTitle", article.getArticleTitle());
				solrInputDocument.addField("articleContent", article.getArticleContent());
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
	 * 全站搜索，查询
	 */
	@Override
	public List<BlogArticle> indexSearch(String queryString){
		// 创建一个SolrQuery对象
		SolrQuery solrQuery = new SolrQuery();
		// 设置查询条件、过滤条件、分页条件、排序条件、高亮
//		solrQuery.setQuery("article_title:"+queryString+" or article_content:"+queryString);
		solrQuery.set("q", "articleTitle:"+queryString+" or articleContent:"+queryString);
		// 分页条件
		solrQuery.setStart(0);
		solrQuery.setRows(20);
		// 设置默认搜索域
		solrQuery.set("df", "article_keywords");
		// 设置高亮
		solrQuery.setHighlight(true);
		// 高亮显示的域
		solrQuery.addHighlightField("articleTitle");
		solrQuery.addHighlightField("articleContent");
		solrQuery.setHighlightSimplePre("<span style='color:red;'>");
		solrQuery.setHighlightSimplePost("</span>");
		List<BlogArticle> articleList = new ArrayList<BlogArticle>();
		try {
			articleList = blogArticleDao.search(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 封装其他属性
		int length = articleList.size();
		for(int i = 0; i < length; i++) {
			BlogArticle blogArticle = articleList.get(0);
			BlogArticle temp = blogArticleMapper.selectByPrimaryKey(blogArticle.getArticleId());
			temp.setArticleTitle(blogArticle.getArticleTitle());
			temp.setArticleContent(blogArticle.getArticleContent());
			articleList.add(temp);
			articleList.remove(blogArticle);
		}
		return articleList;
	}
	
	/**
	 * 根据id删除文章
	 */
	@Transactional
	public void deleteArticleById(Integer articleId) {
		// 删除文章减2积分
		BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(articleId);
		BlogUser blogUser = blogUserMapper.getUserByUserId(blogArticle.getUserId());
		blogUser.setIntegral(blogUser.getIntegral() - 2);
		blogArticleMapper.deleteByPrimaryKey(articleId);
		blogUserMapper.updateUser(blogUser);
		indexImport();
	}
	
	/**
	 * 发表文章
	 */
	@Transactional
	public void addArticle(BlogArticle blogArticle) {
		blogArticle.setArticleTop(0);     // 0（默认）表示不推荐，1表示推荐
		blogArticle.setArticleIspass(2);  // 审核，0未通过，1通过，2（默认）审核中
		blogArticle.setArticleCountClick(0);// 阅读量，第一次发表为0
		Date time = new Date();
		blogArticle.setArticlePublishTime(time);// 发表时间
		blogArticle.setArticleUpdateTime(time); // 修改时间
		blogArticleMapper.insert(blogArticle);
	}

	/**
	 * 根据id查询文章的信息
	 */
	@Transactional
	public BlogArticle getArticleById(Integer articleId) {
		BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(articleId);
		// 浏览数加1
		blogArticle.setArticleCountClick(blogArticle.getArticleCountClick() + 1);
		blogArticleMapper.updateByPrimaryKeyWithBLOBs(blogArticle);
		return blogArticle;
	}

	/**
	 * 编辑文章
	 */
	@Transactional
	public void updateArticle(BlogArticle blogArticle) {
		blogArticle.setArticleIspass(2);
		blogArticle.setArticleUpdateTime(new Date());
		blogArticleMapper.updateByPrimaryKeyWithBLOBs(blogArticle);
		indexImport();
	}
	
	/**
	 * 查询当前登录用户所有文章
	 */
	@Override
	public List<BlogArticle> getArticleListByUserId(Integer userId,Integer top, Integer ispass) {
		BlogArticleExample blogArticleExample = new BlogArticleExample();
		Criteria criteria = blogArticleExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		if(null != top) {
			criteria.andArticleTopEqualTo(top);  // 0（默认）表示不推荐，1表示推荐
		}
		if(null != ispass) {
			criteria.andArticleIspassEqualTo(ispass);  // 审核，0未通过，1通过，2（默认）审核中
		}
		List<BlogArticle> blogArticleList = blogArticleMapper.selectByExample(blogArticleExample);
//		blogArticleList = getShortArticleContentList(blogArticleList);
		blogArticleMapper.selectByExampleWithBLOBs(blogArticleExample);
		return blogArticleList;
	}
	
	/**
	 * 查找文章分类列表
	 */
	@Override
	public List<BlogArticleType> getArticleTypeList() {
		BlogArticleTypeExample blogArticleTypeExample = new BlogArticleTypeExample();
		List<BlogArticleType> articleTypeList = blogArticleTypeMapper.selectByExample(blogArticleTypeExample);
		return articleTypeList;
	}
	
	/**
	 * 添加文章分类
	 */
	@Transactional
	public void addArticleType(BlogArticleType blogArticleType) {
		blogArticleTypeMapper.insert(blogArticleType);
	}

	/**
	 * 根据id查找文章分类的信息
	 */
	@Override
	public BlogArticleType getArticleTypeById(Integer articleTypeId) {
		BlogArticleType blogArticleType = blogArticleTypeMapper.selectByPrimaryKey(articleTypeId);
		return blogArticleType;
	}

	/**
	 * 修改文章分类的信息
	 */
	@Transactional
	public void updateArticleType(BlogArticleType blogArticleType) {
		blogArticleTypeMapper.updateByPrimaryKey(blogArticleType);
	}

}
