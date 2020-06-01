package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogArticleComment implements Serializable{
    private Integer articleCommentId;

    private Integer articleId;

    private Integer articleCommmentIsreply;

    private Integer userIdAuthor;

    private Integer userIdReply;

    private Date articleCommentPublishTime;

    private Integer articleCommentPid;

    private String articleCommentContent;
    
    /**
     * 评论发表者
     */
    private BlogUser blogUserAuthor;
    
    /**
     * 向哪位回复评论
     */
    private BlogUser blogUserReply;
    
    /**
     * 评论底下回复
     */
    private List<BlogArticleComment> blogArticleCommentList;

    public Integer getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Integer articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleCommmentIsreply() {
        return articleCommmentIsreply;
    }

    public void setArticleCommmentIsreply(Integer articleCommmentIsreply) {
        this.articleCommmentIsreply = articleCommmentIsreply;
    }

    public Integer getUserIdAuthor() {
        return userIdAuthor;
    }

    public void setUserIdAuthor(Integer userIdAuthor) {
        this.userIdAuthor = userIdAuthor;
    }

    public Integer getUserIdReply() {
        return userIdReply;
    }

    public void setUserIdReply(Integer userIdReply) {
        this.userIdReply = userIdReply;
    }

    public Date getArticleCommentPublishTime() {
        return articleCommentPublishTime;
    }

    public void setArticleCommentPublishTime(Date articleCommentPublishTime) {
        this.articleCommentPublishTime = articleCommentPublishTime;
    }

    public Integer getArticleCommentPid() {
        return articleCommentPid;
    }

    public void setArticleCommentPid(Integer articleCommentPid) {
        this.articleCommentPid = articleCommentPid;
    }

    public String getArticleCommentContent() {
        return articleCommentContent;
    }

    public void setArticleCommentContent(String articleCommentContent) {
        this.articleCommentContent = articleCommentContent == null ? null : articleCommentContent.trim();
    }

	public BlogUser getBlogUserReply() {
		return blogUserReply;
	}

	public void setBlogUserReply(BlogUser blogUserReply) {
		this.blogUserReply = blogUserReply;
	}

	public BlogUser getBlogUserAuthor() {
		return blogUserAuthor;
	}

	public void setBlogUserAuthor(BlogUser blogUserAuthor) {
		this.blogUserAuthor = blogUserAuthor;
	}

	public List<BlogArticleComment> getBlogArticleCommentList() {
		return blogArticleCommentList;
	}

	public void setBlogArticleCommentList(List<BlogArticleComment> blogArticleCommentList) {
		this.blogArticleCommentList = blogArticleCommentList;
	}
}