package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogResource;
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
public class BlogResourceDao {
	@Resource(name = "httpSolrClientResource")
	private SolrClient solrClient;

	public List<BlogResource> search(SolrQuery solrQuery) throws SolrServerException, IOException {
		List<BlogResource> resourceList = new ArrayList<BlogResource>();
		// 执行查询，得到一个Response对象
		QueryResponse queryResponse = solrClient.query(solrQuery);
		// 取查询结果总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		for(SolrDocument solrDocument:solrDocumentList) {
			BlogResource blogResource = new BlogResource();
			String tempId = (String) solrDocument.getFieldValue("id");
			
			blogResource.setResourceId(Integer.valueOf(tempId));
			// 取高亮显示
			Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
			List<String> nameList = highlighting.get(solrDocument.getFieldValue("id")).get("resourceName");
			String tempName = "";
			if(null != nameList && nameList.size()>0 ) {
				tempName = nameList.get(0);
			}else {
				tempName = (String) solrDocument.getFieldValue("resourceName");
			}
			blogResource.setResourceName(tempName);
			
			Map<String, List<String>> map = highlighting.get(solrDocument.getFieldValue("id"));
					
			List<String> descriptionList = 	map.get("resourceDescription");
			
			String tempDescription = "";
			if(null != descriptionList && descriptionList.size()>0 ) {
				tempDescription = descriptionList.get(0);
			}else {
				tempDescription = (String) solrDocument.getFieldValue("resourceDescription");
			}
			blogResource.setResourceDescription(tempDescription);
			resourceList.add(blogResource);
		}
		return resourceList;
	}
}
