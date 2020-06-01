package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogRoleMapper;
import cn.shrmus.blog.pojo.BlogRole;
import cn.shrmus.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private BlogRoleMapper blogRoleMapper;
//	@Autowired
//	private BlogUserOperationMapper blogUserOperationMapper;
	
	@Transactional
	public void addRole(BlogRole role) {
		blogRoleMapper.addRole(role);
		// 添加日志
		/*BlogUserOperation userOperation = new BlogUserOperation();
		userOperation.setUser(user);
		userOperation.setTime(new Date());
		userOperation.setLog(user.getRealname()+"添加了角色\""+role.getName()+"\"");
		blogUserOperationMapper.addUserOperationLog(userOperation);*/
	}

	@Override
	public List<BlogRole> getRoleList() {
		List<BlogRole> roleList = blogRoleMapper.getRoleList();
		return roleList;
	}

	@Transactional
	public void updateRole(BlogRole role) {
		blogRoleMapper.updateRole(role);
		// 添加日志
		/*BlogUserOperation userOperation = new BlogUserOperation();
		userOperation.setUser(user);
		userOperation.setTime(new Date());
		userOperation.setLog(user.getRealname()+"修改了角色\""+role.getName()+"\"的信息");
		blogUserOperationMapper.addUserOperationLog(userOperation);*/
	}

	@Override
	public void deleleRoleByRoleId(Integer roleId) {
		blogRoleMapper.deleleRoleByRoleId(roleId);
	}

	@Override
	public BlogRole getRoleByRoleId(Integer roleId) {
		BlogRole role = blogRoleMapper.getRoleByRoleId(roleId);
		return role;
	}
	
	public BlogRole getRoleByName(String name) {
		BlogRole role = blogRoleMapper.getRoleByName(name);
		return role;
	}

}
