package cn.shrmus.blog.pojo;

public class BlogUserPrivilege {
	private Integer id;
	private BlogUser user;
	private BlogPrivilege privilege;

	public BlogUserPrivilege() {

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

	public BlogPrivilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(BlogPrivilege privilege) {
		this.privilege = privilege;
	}

}