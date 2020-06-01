package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogRole;

import java.util.List;

public interface RoleService {

	public void addRole(BlogRole role);
	
	public List<BlogRole> getRoleList();

	public void updateRole(BlogRole role);

	public void deleleRoleByRoleId(Integer roleId);

	public BlogRole getRoleByRoleId(Integer roleId);

	public BlogRole getRoleByName(String name);
}
