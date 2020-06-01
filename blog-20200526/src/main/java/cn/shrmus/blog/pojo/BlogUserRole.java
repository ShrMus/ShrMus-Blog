package cn.shrmus.blog.pojo;

public class BlogUserRole {
	private Integer id;

	private BlogUser user;

	private BlogRole role;

	public BlogUserRole() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BlogUser getUser() {
		return user;
	}

	public void setUser(BlogUser user) {
		this.user = user;
	}

	public BlogRole getRole() {
		return role;
	}

	public void setRole(BlogRole role) {
		this.role = role;
	}

}