package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogAlbumMapper;
import cn.shrmus.blog.mapper.BlogPictureMapper;
import cn.shrmus.blog.pojo.BlogAlbum;
import cn.shrmus.blog.pojo.BlogAlbumExample;
import cn.shrmus.blog.pojo.BlogAlbumExample.Criteria;
import cn.shrmus.blog.pojo.BlogPicture;
import cn.shrmus.blog.pojo.BlogPictureExample;
import cn.shrmus.blog.service.AlbumService;
import cn.shrmus.blog.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{
	@Autowired
	private BlogAlbumMapper blogAlbumMapper;
	@Autowired
	private BlogPictureMapper blogPictureMapper;
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Value("${TRACKER_SERVER_CONFIG_PATH}")
	private String TRACKER_SERVER_CONFIG_PATH;
	
	/**
	 * 删除相册
	 */
	@Transactional
	public void deleteAlbum(BlogAlbum blogAlbum) {
		// 查出相册里的照片
		List<BlogPicture> blogPictureList = getPicturesByAlbumId(blogAlbum.getAlbumId());
		// 删除相册里的照片
		deletePicture(blogPictureList);
		blogAlbumMapper.deleteByPrimaryKey(blogAlbum.getAlbumId());
	}
	
	/**
	 * 修改相册信息
	 */
	@Transactional
	public void updateAlbum(BlogAlbum blogAlbum) {
		// blogAlbumMapper.updateByPrimaryKey(blogAlbum);
		blogAlbumMapper.updateByPrimaryKeySelective(blogAlbum);
	}
	
	/**
	 * 删除图片
	 */
	@Transactional
	public void deletePicture(List<BlogPicture> blogPictureList) {
		try {
			for(BlogPicture blogPicture:blogPictureList) {
				// 从数据库删除
				blogPictureMapper.deleteByPrimaryKey(blogPicture.getPictureId());
				// 从文件服务器删除
				String pictureUrl = blogPicture.getPictureUrl();
				// 图片在文件服务器上的路径
				String picturePath = pictureUrl.replace(IMAGE_SERVER_URL, "");
				FastDFSClient fastDFSClient = new FastDFSClient(TRACKER_SERVER_CONFIG_PATH);
				fastDFSClient.delete_file(picturePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传图片
	 */
	@Transactional
	public void uploadPicture(MultipartFile[] uploadFile, Integer albumId){
		// 用来存放上传到FastDFS的图片路径，如果发生异常回滚，数据库不会添加数据，而图片都已经上传了
		List<String> fastdfsUrl = new ArrayList<String>();
		int length = uploadFile.length;
		try {
			for(int i = 0; i < length; i++) {
				BlogPicture blogPicture = new BlogPicture();
				// 取文件名
				String originalFilename = uploadFile[i].getOriginalFilename();
				// 取扩展名
				String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				// 上传到图片服务器
				FastDFSClient fastDFSClient = new FastDFSClient(TRACKER_SERVER_CONFIG_PATH);
				String url = fastDFSClient.uploadFile(uploadFile[i].getBytes(), extName);
				fastdfsUrl.add(url);
//				String serverurl = IMAGE_SERVER_URL + url;
				// 封装图片的属性
				blogPicture.setAlbumId(albumId);
				blogPicture.setPictureName(originalFilename);
				blogPicture.setPictureUrl(url);
				blogPicture.setPictureUploadTime(new Date());
				blogPictureMapper.insert(blogPicture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得某个用户创建的所有相册信息
	 */
	public List<BlogAlbum> getAlbumListByUserId(Integer userId){
		BlogAlbumExample blogAlbumExample = new BlogAlbumExample();
		Criteria criteria = blogAlbumExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<BlogAlbum> blogAlbumList = blogAlbumMapper.selectByExample(blogAlbumExample);
		for (BlogAlbum blogAlbum : blogAlbumList) {
			setImageServerUrl(blogAlbum);
		}
		return blogAlbumList;
	}
	
	/**
	 * 根据相册id查询相册信息
	 */
	@Override
	public BlogAlbum getAlbumById(Integer albumId) {
		BlogAlbum blogAlbum = blogAlbumMapper.selectByPrimaryKey(albumId);
		setImageServerUrl(blogAlbum);
		return blogAlbum;
	}
	
	/**
	 * 查看某一个相册中的照片
	 */
	@Override
	public List<BlogPicture> getPicturesByAlbumId(Integer albumId) {
		BlogPictureExample blogPictureExample = new BlogPictureExample();
		blogPictureExample.setOrderByClause("picture_id desc");
		BlogPictureExample.Criteria criteria = blogPictureExample.createCriteria();
		criteria.andAlbumIdEqualTo(albumId);
		List<BlogPicture> blogPictureList = blogPictureMapper.selectByExample(blogPictureExample);
		for (BlogPicture blogPicture : blogPictureList) {
			setImageServerUrl(blogPicture);
		}
		return blogPictureList;
	}
	
	/**
	 * 创建相册
	 */
	@Transactional
	public void addAlbum(BlogAlbum blogAlbum) {
		blogAlbum.setAlbumCreateTime(new Date());
		blogAlbumMapper.insert(blogAlbum);
	}
	
	/**
	 * 获取某个用户的相册列表
	 * @param userId
	 * @return
	 */
	public List<BlogAlbum> getListByUserId(Integer userId){
		BlogAlbumExample blogAlbumExample = new BlogAlbumExample();
		Criteria criteria = blogAlbumExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<BlogAlbum> blogAlbumList = blogAlbumMapper.selectByExample(blogAlbumExample);
		for (BlogAlbum blogAlbum : blogAlbumList) {
			setImageServerUrl(blogAlbum);
		}
		return blogAlbumList;
	}

	private void setImageServerUrl(BlogAlbum blogAlbum) {
		if (null != blogAlbum) {
			String albumCoverImg = blogAlbum.getAlbumCoverImg();
			String imgUrl = this.IMAGE_SERVER_URL + albumCoverImg;
			blogAlbum.setAlbumCoverImg(imgUrl);
		}
	}

	private void setImageServerUrl(BlogPicture blogPicture) {
		if (null != blogPicture) {
			String pictureUrl = blogPicture.getPictureUrl();
			String imgUrl = this.IMAGE_SERVER_URL + pictureUrl;
			blogPicture.setPictureUrl(imgUrl);
		}
	}
}
