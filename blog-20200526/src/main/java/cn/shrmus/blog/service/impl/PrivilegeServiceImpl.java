package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogPrivilegeMapper;
import cn.shrmus.blog.mapper.BlogRoleMapper;
import cn.shrmus.blog.mapper.BlogUserMapper;
import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.service.PrivilegeService;
import cn.shrmus.blog.utils.ServletContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private BlogPrivilegeMapper blogPrivilegeMapper;
	@Autowired
	private BlogRoleMapper blogRoleMapper;
	@Autowired
	private BlogUserMapper blogUserMapper;
//	@Autowired
//	private BlogUserOperationMapper blogUserOperationMapper;
	
	/**
	 * 删除权限
	 */
	@Transactional
	public void deletePrivilege(Integer privilegeId) {
		blogPrivilegeMapper.deletePrivilege(privilegeId);
		// 重新设置application作用域
		List<BlogPrivilege> privilegeList = blogPrivilegeMapper.getPrivilegeList();
		ServletContextUtil.getServletContext().setAttribute("applicationPrivilegeList", privilegeList);
	}
	
	/**
	 * 修改权限信息
	 */
	@Transactional
	public void updatePrivilege(BlogPrivilege blogPrivilege) {
		blogPrivilegeMapper.updatePrivilege(blogPrivilege);
		// 重新设置application作用域
		List<BlogPrivilege> privilegeList = blogPrivilegeMapper.getPrivilegeList();
		ServletContextUtil.getServletContext().setAttribute("applicationPrivilegeList", privilegeList);
	}
	
	/**
	 * 添加权限
	 */
	@Transactional
	public void addPrivilege(BlogPrivilege blogPrivilege) {
		if(blogPrivilege.getPid() == null) {
			blogPrivilege.setPid(0);
		}
		blogPrivilegeMapper.addPrivilege(blogPrivilege);
		// 重新设置application作用域
		List<BlogPrivilege> privilegeList = blogPrivilegeMapper.getPrivilegeList();
		ServletContextUtil.getServletContext().setAttribute("applicationPrivilegeList", privilegeList);
	}
	
	/**
	 * 根据权限id查找权限信息
	 * @param id
	 * @return
	 */
	public BlogPrivilege getPrivilegeById(Integer id) {
		BlogPrivilege blogPrivilege = blogPrivilegeMapper.getPrivilegeById(id);
		return blogPrivilege;
	}
	
	/**
	 * 根据权限名称查找权限信息
	 */
	public BlogPrivilege getPrivilegeByName(String name) {
		BlogPrivilege blogPrivilege = blogPrivilegeMapper.getPrivilegeByName(name);
		return blogPrivilege;
	}
	
	/**
	 * 查找所有权限列表
	 */
	public List<BlogPrivilege> getPrivilegeList() {
		List<BlogPrivilege> privilegeList = blogPrivilegeMapper.getPrivilegeList();
		return privilegeList;
	}

	/**
	 * 所有权限分配
	 */
	public void allocation(String type, Integer typeId, List<Integer> privilegeArray) {
		// 接收类型
		// 接收类型id
		// 接收被分配的权限id
		// 从数据库中查找已有的权限
		List<BlogPrivilege> privilegeList = null;
		if("role".equals(type)) {
			// TODO 角色添加或删除权限后，对应角色的用户的权限也要添加和删除
			// 根据id获得所有的权限
			privilegeList = blogRoleMapper.getPrivilegeListByRoleId(typeId);
			// 如果已有权限为空就全添加到数据库
			if(0 == privilegeList.size()) {
				for(Integer i:privilegeArray) {
					blogRoleMapper.addPrivilegeByRoleId(typeId,i);
				}
			}else {
				// 如果不为空
				List<Integer> tempList = new ArrayList<Integer>();
				for(BlogPrivilege p:privilegeList) {
					tempList.add(p.getId());
				}
				// 已有权限是否包含privilegeArray
				for(Integer i:privilegeArray) {
					// 如果包含什么都不做，如果不包含，说明添加了权限
					if(false == tempList.contains(i)) {
						blogRoleMapper.addPrivilegeByRoleId(typeId,i);
					}
				}
				// privilegeArray是否包含已有的权限
//				List<Integer> tempList2 = Arrays.asList(privilegeArray);
				List<Integer> tempList2 = privilegeArray;
				for(Integer i:tempList) {
					// 如果包含什么都不做，如果不包含，说明权限被取消了,删除这个权限
					if(false == tempList2.contains(i)) {
						blogRoleMapper.deletePrivilegeByRoleId(typeId,i);
					}
				}
			}
			// 添加日志
			/*BlogRole role = blogRoleMapper.getRoleByRoleId(typeId);
			BlogUserOperation userOperation = new BlogUserOperation();
			userOperation.setUser(currUser);
			userOperation.setTime(new Date());
			userOperation.setLog(currUser.getRealname()+"给角色\""+role.getName()+"\"分配了权限");
			blogUserOperationMapper.addUserOperationLog(userOperation);*/
		} else if("user".equals(type)) {
			privilegeList = blogUserMapper.getPrivilegeListByUserId(typeId);
			// 如果已有权限为空就全添加到数据库
			if(0 == privilegeList.size()) {
				for(Integer i:privilegeArray) {
					blogUserMapper.addPrivilegeByUserId(typeId,i);
				}
			}else {
				// 如果不为空
				List<Integer> tempList = new ArrayList<Integer>();
				for(BlogPrivilege p:privilegeList) {
					tempList.add(p.getId());
				}
				for(Integer i:privilegeArray) {
					// 如果包含什么都不做，如果不包含，说明添加了权限
					if(false == tempList.contains(i)) {
						blogUserMapper.addPrivilegeByUserId(typeId,i);
					}
				}
				// privilegeArray是否包含已有的权限
				List<Integer> tempList2 = privilegeArray;
				for(Integer i:tempList) {
					// 如果包含什么都不做，如果不包含，说明权限被取消了,删除这个权限
					if(false == tempList2.contains(i)) {
						blogUserMapper.deletePrivilegeByUserId(typeId,i);
					}
				}
			}
			// 添加日志
			/*BlogUser user = blogUserMapper.getUserByUserId(typeId);
			BlogUserOperation userOperation = new BlogUserOperation();
			userOperation.setUser(currUser);
			userOperation.setTime(new Date());
			userOperation.setLog(currUser.getRealname()+"给用户\""+user.getRealname()+"\"分配了权限");
			blogUserOperationMapper.addUserOperationLog(userOperation);*/
		}
	}
	
	public Object getObjectById(String type, Integer typeId) {
		Object object = null;
		if("role".equals(type)) {
			object = blogRoleMapper.getRoleByRoleId(typeId);
		}
		else if("user".equals(type)) {
			// 查找这个角色的信息
			object = blogUserMapper.getUserByUserId(typeId);
		}
		return object;
	}

}
