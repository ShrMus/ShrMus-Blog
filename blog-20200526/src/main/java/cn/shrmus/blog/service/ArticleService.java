package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogArticle;
import cn.shrmus.blog.pojo.BlogArticleComment;
import cn.shrmus.blog.pojo.BlogArticleType;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArticleService {
	public List<BlogArticle> getArticleListByHot();
	
	public List<BlogArticle> getArticleList(Integer top, Integer ispass);

	public void addArticleType(BlogArticleType blogArticleType);

	public List<BlogArticleType> getArticleTypeList();

	public BlogArticleType getArticleTypeById(Integer articleTypeId);

	public void updateArticleType(BlogArticleType blogArticleType);

	public List<BlogArticle> getArticleListByUserId(Integer userId, Integer top, Integer ispass);

	public void addArticle(BlogArticle blogArticle);

	public BlogArticle getArticleById(Integer articleId);

	public void updateArticle(BlogArticle blogArticle);

	public void deleteArticleById(Integer articleId);

	public void indexImport();

	public List<BlogArticle> indexSearch(String queryString) throws SolrServerException, IOException;

	public void addArticleComment(BlogArticleComment blogArticleComment);

	public void deleteArticleCommentByArticleCommentId(Integer articleCommentId);

	public List<BlogArticle> getArticleListByUserId(Integer userId);

	public List<BlogArticle> getArticlePassing();

	public void updatePassArticle(BlogArticle blogArticle);

	public List<BlogArticle> getArticleListByArticleTypeId(Integer articleTypeId);

	public List<BlogArticle> getArticleListByTop();

	public void setTopArticleList(List<BlogArticle> blogArticleList);

	public List<BlogArticle> getArticleListByTopUI();

	public List<BlogArticle> getArticleListNew();

	public String uploadPicture(MultipartFile uploadFile);

}
