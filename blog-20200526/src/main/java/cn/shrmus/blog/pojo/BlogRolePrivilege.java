package cn.shrmus.blog.pojo;

import java.io.Serializable;

public class BlogRolePrivilege implements Serializable{
	private Integer id;

	private BlogRole role;

	private BlogPrivilege privilege;

	public BlogRolePrivilege() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BlogRole getRole() {
		return role;
	}

	public void setRole(BlogRole role) {
		this.role = role;
	}

	public BlogPrivilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(BlogPrivilege privilege) {
		this.privilege = privilege;
	}
}