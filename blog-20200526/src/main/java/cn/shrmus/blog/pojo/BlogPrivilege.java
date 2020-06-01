package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.List;

public class BlogPrivilege implements Serializable {
	private Integer id;

	private String name;

	private String url;
	
	private Integer pid;

	private String icon;

	private BlogPrivilege parentPrivilege;

	private List<BlogPrivilege> childPrivilegeList;

	public BlogPrivilege() {

	}
	
	public BlogPrivilege(String name, String url) {
		super();
		this.name = name;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public BlogPrivilege getParentPrivilege() {
		return parentPrivilege;
	}

	public void setParentPrivilege(BlogPrivilege parentPrivilege) {
		this.parentPrivilege = parentPrivilege;
	}

	public List<BlogPrivilege> getChildPrivilegeList() {
		return childPrivilegeList;
	}

	public void setChildPrivilegeList(List<BlogPrivilege> childPrivilegeList) {
		this.childPrivilegeList = childPrivilegeList;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
}