package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogRoleMapper;
import cn.shrmus.blog.mapper.BlogUserMapper;
import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.pojo.BlogRole;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.UserService;
import cn.shrmus.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BlogUserMapper blogUserMapper;
	@Autowired
	private BlogRoleMapper blogRoleMapper;
	
	/**
	 * 用户注册
	 */
	@Transactional
	public int regUser(BlogUser user) {
		BlogUser userByUsername = blogUserMapper.getUserByUsername(user.getUsername());
		// 用户名已存在
		if(null != userByUsername) {
			return 1;
		}else {
			// 密码用md5摘要加密
			String temp = MD5Util.EncoderByMd5(user.getPassword());
			user.setPassword(temp);
			// 初始化积分
			user.setIntegral(100);
			// 添加用户
			blogUserMapper.regUser(user);
			
			int userId = blogUserMapper.getMaxPrimaryKey();
			int roleId = 2;
			// 添加用户的角色
			blogUserMapper.addRoleForUser(userId,roleId);
			// 查找角色拥有的权限
			List<BlogPrivilege> privilegeList = blogRoleMapper.getPrivilegeListByRoleId(roleId);
			if(null != privilegeList) {
				// 添加用户的权限
				for(BlogPrivilege p:privilegeList) {
					blogUserMapper.addPrivilegeByUserId(userId, p.getId());
				}
			}
			return 0;
		}
	}

	@Override
	public BlogUser getUserByUserId(Integer id) {
		BlogUser user = blogUserMapper.getUserByUserId(id);
		return user;
	}
	
	public BlogUser getUserByUsername(String username) {
		BlogUser user = blogUserMapper.getUserByUsername(username);
		return user;
	}

	@Override
	public List<BlogUser> getUserList() {
		List<BlogUser> userList = blogUserMapper.getUserList();
		return userList;
	}

	@Transactional
	public void updateUser(Integer roleId, BlogUser user) {
		// 先修改用户的基本信息
		BlogUser temp = blogUserMapper.getUserByUserId(user.getId());
		// 如果密码和原来的不一样
		if(!user.getPassword().equals(temp.getPassword())) {
			user.setPassword(MD5Util.EncoderByMd5(user.getPassword()));
		}
		blogUserMapper.updateUser(user);
		// 查询用户原来的角色，如果还是原来的角色就不用改权限
		List<BlogRole> userRoleList = blogUserMapper.getRoleByUserId(user.getId());
		// TODO 没有考虑用户多个角色所拥有的不同的权限，只取了用户分配的第一个角色的权限
		int userRoleId = userRoleList.get(0).getId();
		// 如果不是原来的角色，则修改用户的角色，再修改用户的权限
		if(null != roleId && roleId != userRoleId) {
			// 修改用户的角色
			blogUserMapper.updateRoleByUserId(user.getId(),roleId);
			// 修改用户的权限,将原来的权限删除，再添加新的权限
			// 其实可以用分配权限时的那种方法，两种角色的权限可能有相同的权限，这里为了节省时间，直接删除再添加了
			blogUserMapper.deleteAllPrivilege(user.getId());
			// 查询新角色的所有权限
			List<BlogPrivilege> rolePrivilegeList = blogRoleMapper.getPrivilegeListByRoleId(roleId);
			// 添加
			for(BlogPrivilege p: rolePrivilegeList) {
				blogUserMapper.addPrivilegeByUserId(user.getId(), p.getId());
			}
		}
		// 添加日志
		/*BlogUserOperation userOperation = new BlogUserOperation();
		userOperation.setUser(currUser);
		userOperation.setTime(new Date());
		userOperation.setLog(currUser.getRealname()+"修改了用户\""+user.getRealname()+"\"的角色信息");
		blogUserOperationMapper.addUserOperationLog(userOperation);*/
	}

	@Override
	public void deleleUserByUserId(Integer userId) {
		// 从用户表删除
		blogUserMapper.deleleUserByUserId(userId);
		// 从用户角色表删除
		// 删除用户的权限  这一步在删除角色的时候没有写
	}

	@Override
	public BlogUser login(BlogUser user) {
		String tempString = MD5Util.EncoderByMd5(user.getPassword());
		user.setPassword(tempString);
		user = blogUserMapper.login(user);
		return user;
	}
	
	@Override
	public BlogUser loginByQQ(BlogUser user) {
		BlogUser blogUser = blogUserMapper.loginByQQ(user);
		return blogUser;
	}
	
	@Override
	public BlogUser binding(BlogUser user) {
		BlogUser temp = login(user);
		if(null != temp) {
			temp.setOpenid(user.getOpenid());
			temp.setNickname(user.getNickname());
			temp.setIcon(user.getIcon());
			blogUserMapper.binding(user);
		}
		return temp;
	}

	/**
	 * 管理员添加用户
	 */
	@Transactional
	public int addUser(Integer roleId, BlogUser user) {
		BlogUser userByUsername = blogUserMapper.getUserByUsername(user.getUsername());
		if(null != userByUsername) {
			return 1;
		}else {
			String password = user.getPassword();
			// 取出密码进行md5加密
			String tempString = MD5Util.EncoderByMd5(password);
			user.setPassword(tempString);
			// 初始化积分
			user.setIntegral(100);
			
			blogUserMapper.addUser(user);
			int userId = blogUserMapper.getMaxPrimaryKey();
			// 添加用户的角色
			blogUserMapper.addRoleForUser(userId,roleId);
			
			// 查找角色拥有的权限
			List<BlogPrivilege> privilegeList = blogRoleMapper.getPrivilegeListByRoleId(roleId);
			// 添加用户的权限
			for(BlogPrivilege p:privilegeList) {
				blogUserMapper.addPrivilegeByUserId(userId, p.getId());
			}
			return 0;
		}
		// 添加日志
		/*BlogUserOperation userOperation = new BlogUserOperation();
		userOperation.setUser(currUser);
		userOperation.setTime(new Date());
		userOperation.setLog(currUser.getRealname()+"添加了用户\""+user.getRealname()+"\"");
		blogUserOperationMapper.addUserOperationLog(userOperation);*/
	}
	
}
