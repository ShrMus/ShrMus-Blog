package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.List;

public class BlogRole implements Serializable{
	private Integer id;

	private String name;

	private String description;

	/**
	 * 角色拥有的权限列表
	 */
	private List<Integer> privilegeList;

	public BlogRole() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<Integer> privilegeList) {
		this.privilegeList = privilegeList;
	}
}