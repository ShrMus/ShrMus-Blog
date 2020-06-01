package cn.shrmus.blog.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogArticle implements Serializable{
	
	private Integer articleId;

    private Integer userId;

    private Integer articleTypeId;

    private Integer articleTop;

    private Integer articleIspass;

    private String articleTitle;

    private Integer articleCountClick;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date articleUpdateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date articlePublishTime;

    private String articleContent;
    
    /**
     * 文章底下评论
     */
    private List<BlogArticleComment> blogArticleCommentList;
    
    /**
     * 文章发表者
     */
    private BlogUser blogUser;
    
    /**
     * 文章类型
     */
    private BlogArticleType blogArticleType;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public Integer getArticleTop() {
        return articleTop;
    }

    public void setArticleTop(Integer articleTop) {
        this.articleTop = articleTop;
    }

    public Integer getArticleIspass() {
        return articleIspass;
    }

    public void setArticleIspass(Integer articleIspass) {
        this.articleIspass = articleIspass;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getArticleCountClick() {
        return articleCountClick;
    }

    public void setArticleCountClick(Integer articleCountClick) {
        this.articleCountClick = articleCountClick;
    }

    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    public Date getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(Date articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

	public List<BlogArticleComment> getBlogArticleCommentList() {
		return blogArticleCommentList;
	}

	public void setBlogArticleCommentList(List<BlogArticleComment> blogArticleCommentList) {
		this.blogArticleCommentList = blogArticleCommentList;
	}

	public BlogUser getBlogUser() {
		return blogUser;
	}

	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
	}

	public BlogArticleType getBlogArticleType() {
		return blogArticleType;
	}

	public void setBlogArticleType(BlogArticleType blogArticleType) {
		this.blogArticleType = blogArticleType;
	}
}