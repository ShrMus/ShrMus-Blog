package cn.shrmus.blog.pojo;

import java.io.Serializable;

public class BlogArticleType implements Serializable{
    private Integer articleTypeId;

    private String articleTypeName;

    private String articleTypeDescription;

    @Override
	public String toString() {
		return "BlogArticleType [articleTypeId=" + articleTypeId + ", articleTypeName=" + articleTypeName
				+ ", articleTypeDescription=" + articleTypeDescription + "]";
	}

	public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName == null ? null : articleTypeName.trim();
    }

    public String getArticleTypeDescription() {
        return articleTypeDescription;
    }

    public void setArticleTypeDescription(String articleTypeDescription) {
        this.articleTypeDescription = articleTypeDescription == null ? null : articleTypeDescription.trim();
    }
}