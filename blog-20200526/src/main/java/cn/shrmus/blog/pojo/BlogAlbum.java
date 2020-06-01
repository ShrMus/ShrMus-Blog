package cn.shrmus.blog.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogAlbum implements Serializable{
    private Integer albumId;

    private Integer userId;

    private String albumName;

    private String albumDescription;

    private String albumCoverImg;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date albumCreateTime;
    
    /**
     * 相册拥有者
     */
    private BlogUser blogUser;
    
    /**
     * 相册中的照片
     */
    private List<BlogPicture> blogPictureList;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription == null ? null : albumDescription.trim();
    }

    public String getAlbumCoverImg() {
        return albumCoverImg;
    }

    public void setAlbumCoverImg(String albumCoverImg) {
        this.albumCoverImg = albumCoverImg == null ? null : albumCoverImg.trim();
    }

    public Date getAlbumCreateTime() {
        return albumCreateTime;
    }

    public void setAlbumCreateTime(Date albumCreateTime) {
        this.albumCreateTime = albumCreateTime;
    }

	public BlogUser getBlogUser() {
		return blogUser;
	}

	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
	}

	public List<BlogPicture> getBlogPictureList() {
		return blogPictureList;
	}

	public void setBlogPictureList(List<BlogPicture> blogPictureList) {
		this.blogPictureList = blogPictureList;
	}
}