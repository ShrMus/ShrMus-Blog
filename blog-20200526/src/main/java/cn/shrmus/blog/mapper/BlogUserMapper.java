package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.pojo.BlogRole;
import cn.shrmus.blog.pojo.BlogUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogUserMapper {
	public void addUser(BlogUser user);

	public BlogUser getUserByUserId(Integer id);

	public List<BlogPrivilege> getPrivilegeListByUserId(Integer userId);

	public void addPrivilegeByUserId(@Param("userId") Integer userId, @Param("privilegeId") Integer privilegeId);

	public void deletePrivilegeByUserId(@Param("userId") Integer userId, @Param("privilegeId") Integer privilegeId);

	public List<BlogUser> getUserList();

	public void addRoleForUser(@Param("userId") int userId, @Param("roleId") int roleId);

	public void deleleUserByUserId(Integer userId);

	public void updateUser(BlogUser user);

	public List<BlogRole> getRoleByUserId(Integer id);

	public void updateRoleByUserId(@Param("userId") int userId, @Param("roleId") int roleId);

	public void deleteAllPrivilege(Integer id);

	public BlogUser login(BlogUser user);

	public BlogUser loginByQQ(BlogUser user);

	public int getMaxPrimaryKey();

	public void countIntegral(@Param("userId") Integer userId, @Param("integral") float integral);

	public void clearMonthIntegral();

	public void regUser(BlogUser user);

	public void binding(BlogUser user);

	public BlogUser getUserByUsername(String username);


}