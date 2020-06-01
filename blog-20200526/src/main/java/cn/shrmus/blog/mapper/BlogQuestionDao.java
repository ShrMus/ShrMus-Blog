package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogQuestion;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BlogQuestionDao {

	@Resource(name = "httpSolrClientQuestion")
	private SolrClient solrClient;
	
	public List<BlogQuestion> search(SolrQuery solrQuery) throws SolrServerException, IOException {
		List<BlogQuestion> questionList = new ArrayList<BlogQuestion>();
		// 执行查询，得到一个Response对象
		QueryResponse queryResponse = solrClient.query(solrQuery);
		// 取查询结果总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		for(SolrDocument solrDocument:solrDocumentList) {
			BlogQuestion blogQuestion = new BlogQuestion();
			String tempId = (String) solrDocument.getFieldValue("id");
			
			blogQuestion.setQuestionId(Integer.valueOf(tempId));
			// 取高亮显示
			Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
			List<String> titleList = highlighting.get(solrDocument.getFieldValue("id")).get("questionTitle");
			String tempTitle = "";
			if(null != titleList && titleList.size()>0 ) {
				tempTitle = titleList.get(0);
			}else {
				tempTitle = (String) solrDocument.getFieldValue("questionTitle");
			}
			blogQuestion.setQuestionTitle(tempTitle);
			
			Map<String, List<String>> map = highlighting.get(solrDocument.getFieldValue("id"));
					
			List<String> contentList = 	map.get("questionContent");
			
			String tempContent = "";
			if(null != contentList && contentList.size()>0 ) {
				tempContent = contentList.get(0);
			}else {
				tempContent = (String) solrDocument.getFieldValue("questionContent");
			}
			blogQuestion.setQuestionContent(tempContent);
			questionList.add(blogQuestion);
		}
		return questionList;
	}
	
}
