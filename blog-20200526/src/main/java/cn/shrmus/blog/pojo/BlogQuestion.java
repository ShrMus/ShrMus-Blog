package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogQuestion implements Serializable{
    private Integer questionId;

    private Integer questionPid;

    private Integer userIdAuthor;

    private Integer userIdReply;

    private String questionTitle;

    private Date questionPublishTime;

    private Integer questionIntegral;

    private Integer questionAccpeted;

    private String questionContent;
    
    /**
     * 提问者
     */
    private BlogUser blogUserAuthor;
    
    /**
     * 回答者
     */
    private BlogUser blogUserReply;

    /**
     * 提问底下回答
     */
    private List<BlogQuestion> questionList;
    
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionPid() {
        return questionPid;
    }

    public void setQuestionPid(Integer questionPid) {
        this.questionPid = questionPid;
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

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public Date getQuestionPublishTime() {
        return questionPublishTime;
    }

    public void setQuestionPublishTime(Date questionPublishTime) {
        this.questionPublishTime = questionPublishTime;
    }

    public Integer getQuestionIntegral() {
        return questionIntegral;
    }

    public void setQuestionIntegral(Integer questionIntegral) {
        this.questionIntegral = questionIntegral;
    }

    public Integer getQuestionAccpeted() {
        return questionAccpeted;
    }

    public void setQuestionAccpeted(Integer questionAccpeted) {
        this.questionAccpeted = questionAccpeted;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

	public BlogUser getBlogUserAuthor() {
		return blogUserAuthor;
	}

	public void setBlogUserAuthor(BlogUser blogUserAuthor) {
		this.blogUserAuthor = blogUserAuthor;
	}

	public BlogUser getBlogUserReply() {
		return blogUserReply;
	}

	public void setBlogUserReply(BlogUser blogUserReply) {
		this.blogUserReply = blogUserReply;
	}

	public List<BlogQuestion> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<BlogQuestion> questionList) {
		this.questionList = questionList;
	}
}