package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class BlogPicture implements Serializable{
    private Integer pictureId;

    private Integer albumId;

    private String pictureName;

    private String pictureUrl;

    private Date pictureUploadTime;
    
    /**
     * 所属相册
     */
    private BlogAlbum blogAlbum;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Date getPictureUploadTime() {
        return pictureUploadTime;
    }

    public void setPictureUploadTime(Date pictureUploadTime) {
        this.pictureUploadTime = pictureUploadTime;
    }

	public BlogAlbum getBlogAlbum() {
		return blogAlbum;
	}

	public void setBlogAlbum(BlogAlbum blogAlbum) {
		this.blogAlbum = blogAlbum;
	}
}