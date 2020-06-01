package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogLeaveMessage implements Serializable{
    private Integer messageId;

    private Integer userId;

    private Integer messagePid;

    private Integer messageIsreply;

    private Integer userIdAuthor;

    private Integer userIdReply;

    private Date messagePublishTime;

    private String messageContent;
    
    /**
     * 留言所属用户
     */
    private BlogUser blogUser;
    
    /**
     * 留言发表者
     */
    private BlogUser blogUserAuthor;
    
    /**
     * 向哪位回复留言
     */
    private BlogUser blogUserReply;
    
    /**
     * 留言底下回复
     */
    private List<BlogLeaveMessage> messagesList;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMessagePid() {
        return messagePid;
    }

    public void setMessagePid(Integer messagePid) {
        this.messagePid = messagePid;
    }

    public Integer getMessageIsreply() {
        return messageIsreply;
    }

    public void setMessageIsreply(Integer messageIsreply) {
        this.messageIsreply = messageIsreply;
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

    public Date getMessagePublishTime() {
        return messagePublishTime;
    }

    public void setMessagePublishTime(Date messagePublishTime) {
        this.messagePublishTime = messagePublishTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
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

	public BlogUser getBlogUser() {
		return blogUser;
	}

	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
	}

	public List<BlogLeaveMessage> getMessagesList() {
		return messagesList;
	}

	public void setMessagesList(List<BlogLeaveMessage> messagesList) {
		this.messagesList = messagesList;
	}
}