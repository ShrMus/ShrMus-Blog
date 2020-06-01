package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogPrivilege;

import java.util.List;

public interface BlogPrivilegeMapper {
	/**
	 * 查找所有权限
	 * @return
	 */
	public List<BlogPrivilege> getPrivilegeList();

	public BlogPrivilege getPrivilegeById(Integer id);

	public void addPrivilege(BlogPrivilege blogPrivilege);

	public void updatePrivilege(BlogPrivilege blogPrivilege);

	public void deletePrivilege(Integer privilegeId);

	public BlogPrivilege getPrivilegeByName(String name);

}