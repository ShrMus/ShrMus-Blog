package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogResourceDao;
import cn.shrmus.blog.mapper.BlogResourceMapper;
import cn.shrmus.blog.mapper.BlogUserMapper;
import cn.shrmus.blog.pojo.BlogResource;
import cn.shrmus.blog.pojo.BlogResourceExample;
import cn.shrmus.blog.pojo.BlogResourceExample.Criteria;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private BlogResourceMapper blogResourceMapper;
	@Autowired
	private BlogUserMapper blogUserMapper;
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Value("${TRACKER_SERVER_CONFIG_PATH}")
	private String TRACKER_SERVER_CONFIG_PATH;
	@Resource(name = "httpSolrClientResource")
	private SolrClient solrClient;
	@Autowired
	private BlogResourceDao blogResourceDao;
	
	
	private List<BlogResource> getShortArticleContentList(List<BlogResource> blogArticleList){
		for(BlogResource blogArticle : blogArticleList) {
			String articleContent = blogArticle.getResourceDescription();
			articleContent = articleContent.replaceFirst("<p>", "");
			int length = articleContent.length();
			if(length > 100) {
				articleContent = articleContent.substring(0,100);
			}
			blogArticle.setResourceDescription(articleContent);
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
			BlogResourceExample blogResourceExample = new BlogResourceExample();
			List<BlogResource> resourceList = blogResourceMapper.selectByExample(blogResourceExample);
			// 遍历数据添加到索引库
			for(BlogResource resource:resourceList) {
				// 创建文档对象
				SolrInputDocument solrInputDocument = new SolrInputDocument();
				solrInputDocument.addField("id", resource.getResourceId());
				solrInputDocument.addField("resourceName", resource.getResourceName());
				solrInputDocument.addField("resourceDescription", resource.getResourceDescription());
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
	public List<BlogResource> indexSearch(String queryString) {
		// 创建一个SolrQuery对象
		SolrQuery solrQuery = new SolrQuery();
		// 设置查询条件、过滤条件、分页条件、排序条件、高亮
//				solrQuery.setQuery("article_title:"+queryString+" or article_content:"+queryString);
		solrQuery.set("q", "resourceName:"+queryString+" or resourceDescription:"+queryString);
		// 分页条件
		solrQuery.setStart(0);
		solrQuery.setRows(20);
		// 设置默认搜索域
		solrQuery.set("df", "resource_keywords");
		// 设置高亮
		solrQuery.setHighlight(true);
		// 高亮显示的域
		solrQuery.addHighlightField("resourceName");
		solrQuery.addHighlightField("resourceDescription");
		solrQuery.setHighlightSimplePre("<span style='color:red;'>");
		solrQuery.setHighlightSimplePost("</span>");
		List<BlogResource> resourceList = new ArrayList<BlogResource>();
		try {
			resourceList = blogResourceDao.search(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 封装其他属性
		int length = resourceList.size();
		for(int i = 0; i < length; i++) {
			BlogResource blogResource = resourceList.get(0);
			BlogResource temp = blogResourceMapper.selectByPrimaryKey(blogResource.getResourceId());
			temp.setResourceName(blogResource.getResourceName());
			temp.setResourceDescription(blogResource.getResourceDescription());
			resourceList.add(temp);
			resourceList.remove(blogResource);
		}
		return resourceList;
	}
	
	/**
	 * 修改资源审核的信息
	 */
	@Transactional
	public void updateResource(BlogResource blogResource) {
		blogResourceMapper.updateByPrimaryKeySelective(blogResource);
		indexImport();
	}
	
	/**
	 * 查找审核中的资源，上传之后没有审核过的
	 */
	public List<BlogResource> getResourcePassing(){
		BlogResourceExample blogResourceExample = new BlogResourceExample();
		blogResourceExample.setOrderByClause("resource_id desc");
		Criteria criteria = blogResourceExample.createCriteria();
		criteria.andResourceIspassEqualTo(2); 
		List<BlogResource> blogResourceList = blogResourceMapper.selectByExample(blogResourceExample);
		List<BlogResource> shortArticleContentList = getShortArticleContentList(blogResourceList);
		return shortArticleContentList;
	}
	
	/**
	 * 查找某个用户上传的资源
	 */
	public List<BlogResource> getResourceListByUserId(Integer userId){
		BlogResourceExample blogResourceExample = new BlogResourceExample();
		blogResourceExample.setOrderByClause("resource_id desc");
		Criteria criteria = blogResourceExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<BlogResource> blogResourceList = blogResourceMapper.selectByExample(blogResourceExample);
		List<BlogResource> shortArticleContentList = getShortArticleContentList(blogResourceList);
		return shortArticleContentList;
	}
	
	/**
	 * 下载资源修改积分和下载次数
	 */
	@Transactional
	public void downloadResource(BlogUser blogUser, BlogResource blogResource) {
		// 下载积分
		BlogUser uploadUser = blogResource.getBlogUser();
		if(uploadUser.getId() != blogUser.getId()) {
			blogUser.setIntegral(blogUser.getIntegral() - blogResource.getResourceIntegral());
			uploadUser.setIntegral(uploadUser.getIntegral() + blogResource.getResourceIntegral());
		}
		// 下载次数
		blogResource.setResourceDownloadCount(blogResource.getResourceDownloadCount() + 1);
		blogUserMapper.updateUser(blogUser);
		blogUserMapper.updateUser(uploadUser);
		blogResourceMapper.updateByPrimaryKey(blogResource);
	}
	
	/**
	 * 上传资源
	 */
	@Transactional
	public void uploadResource(MultipartFile uploadFile, BlogResource blogResource) {
		try {
			// 获取文件大小
			int size = (int) uploadFile.getSize();
			// 取文件名
			String originalFilename = uploadFile.getOriginalFilename();
			// 取扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			// 上传到图片服务器
			FastDFSClient fastDFSClient = new FastDFSClient(TRACKER_SERVER_CONFIG_PATH);
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			String serverurl = IMAGE_SERVER_URL + url;
			// 封装图片的属性
			blogResource.setResourceFilename(originalFilename);
			blogResource.setResourceSize(size);
			blogResource.setResourceUrl(serverurl);
			blogResource.setResourceDownloadCount(0);
			blogResource.setResourceShow(1);  // 1（默认）显示，0表示不给其他人看
			blogResource.setResourceIspass(2);  // 审核，0未通过，1通过，2（默认）审核中
			blogResource.setResourceUploadTime(new Date());
			blogResourceMapper.insert(blogResource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据Id查找资源信息
	 */
	public BlogResource getResourceById(Integer resourceId) {
		BlogResource blogResource = blogResourceMapper.selectByPrimaryKey(resourceId);
		return blogResource;
	}
	
	/**
	 * 查找所有已上传的资源
	 */
	@Override
	public List<BlogResource> getResourceList() {
		BlogResourceExample blogResourceExample = new BlogResourceExample();
		blogResourceExample.setOrderByClause("resource_id desc");
		Criteria criteria = blogResourceExample.createCriteria();
		criteria.andResourceIspassEqualTo(1);  // 审核通过
		List<BlogResource> blogResourceList = blogResourceMapper.selectByExample(blogResourceExample);
		List<BlogResource> shortArticleContentList = getShortArticleContentList(blogResourceList);
		return shortArticleContentList;
	}
	
}
