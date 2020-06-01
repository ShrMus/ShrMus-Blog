package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogAlbum;
import cn.shrmus.blog.pojo.BlogPicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AlbumService {
	public List<BlogAlbum> getListByUserId(Integer userId);

	public void addAlbum(BlogAlbum blogAlbum);

	public List<BlogPicture> getPicturesByAlbumId(Integer albumId);

	public BlogAlbum getAlbumById(Integer albumId);

	public List<BlogAlbum> getAlbumListByUserId(Integer userId);

	public void uploadPicture(MultipartFile[] uploadFile, Integer albumId);

	public void deletePicture(List<BlogPicture> blogPictureList);

	public void updateAlbum(BlogAlbum blogAlbum);

	public void deleteAlbum(BlogAlbum blogAlbum);
}
