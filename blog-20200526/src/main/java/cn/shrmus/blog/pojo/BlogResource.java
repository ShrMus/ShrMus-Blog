package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class BlogResource implements Serializable{
    private Integer resourceId;

    private Integer userId;

    private Integer resourceIspass;

    private Integer resourceIntegral;

    private String resourceUrl;

    private Integer resourceSize;

    private Integer resourceDownloadCount;

    private String resourceName;
    
    private String resourceFilename;

    private String resourceDescription;

    private Integer resourceShow;

    private Date resourceUploadTime;
    
    /**
     * 所属用户
     */
    private BlogUser blogUser;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResourceIspass() {
        return resourceIspass;
    }

    public void setResourceIspass(Integer resourceIspass) {
        this.resourceIspass = resourceIspass;
    }

    public Integer getResourceIntegral() {
        return resourceIntegral;
    }

    public void setResourceIntegral(Integer resourceIntegral) {
        this.resourceIntegral = resourceIntegral;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public Integer getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }

    public Integer getResourceDownloadCount() {
        return resourceDownloadCount;
    }

    public void setResourceDownloadCount(Integer resourceDownloadCount) {
        this.resourceDownloadCount = resourceDownloadCount;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription == null ? null : resourceDescription.trim();
    }

    public Integer getResourceShow() {
        return resourceShow;
    }

    public void setResourceShow(Integer resourceShow) {
        this.resourceShow = resourceShow;
    }

    public Date getResourceUploadTime() {
        return resourceUploadTime;
    }

    public void setResourceUploadTime(Date resourceUploadTime) {
        this.resourceUploadTime = resourceUploadTime;
    }

	public BlogUser getBlogUser() {
		return blogUser;
	}

	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
	}

	public String getResourceFilename() {
		return resourceFilename;
	}

	public void setResourceFilename(String resourceFilename) {
		this.resourceFilename = resourceFilename;
	}
}