package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogResource;
import cn.shrmus.blog.pojo.BlogUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResourceService {

	List<BlogResource> getResourceList();

	BlogResource getResourceById(Integer resourceId);

	void uploadResource(MultipartFile uploadFile, BlogResource blogResource);

	void downloadResource(BlogUser blogUser, BlogResource blogResource);

	List<BlogResource> getResourceListByUserId(Integer userId);

	List<BlogResource> getResourcePassing();

	void updateResource(BlogResource blogResource);

	void indexImport();

	List<BlogResource> indexSearch(String keywords);

}
