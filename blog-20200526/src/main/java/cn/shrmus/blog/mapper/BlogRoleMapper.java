package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.pojo.BlogRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogRoleMapper {
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(BlogRole role);

	public List<BlogRole> getRoleList();

	public void updateRole(BlogRole role);

	public void deleleRoleByRoleId(Integer roleId);

	public BlogRole getRoleByRoleId(Integer roleId);

	public List<BlogPrivilege> getPrivilegeListByRoleId(Integer roleId);

	public void addPrivilegeByRoleId(@Param("roleId") Integer roleId, @Param("privilegeId") Integer privilegeId);

	public void deletePrivilegeByRoleId(@Param("roleId") Integer roleId, @Param("privilegeId") Integer privilegeId);

	public BlogRole getRoleByName(String name);
}