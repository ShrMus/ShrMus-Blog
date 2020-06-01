package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogPrivilege;

import java.util.List;

public interface PrivilegeService {
	public List<BlogPrivilege> getPrivilegeList();

	public void allocation(String type, Integer typeId, List<Integer> privilegeArray);

	public Object getObjectById(String type, Integer typeId);

	public void addPrivilege(BlogPrivilege blogPrivilege);
	
	public BlogPrivilege getPrivilegeById(Integer id);

	public void updatePrivilege(BlogPrivilege blogPrivilege);

	public void deletePrivilege(Integer privilegeId);

	public BlogPrivilege getPrivilegeByName(String name);
}
