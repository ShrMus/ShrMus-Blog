package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogUser;

import java.util.List;

public interface UserService {

	public int addUser(Integer roleId, BlogUser user);

	public BlogUser getUserByUserId(Integer typeId);

	public List<BlogUser> getUserList();

	public void updateUser(Integer roleId, BlogUser user);

	public void deleleUserByUserId(Integer userId);

	public BlogUser login(BlogUser user);
	
	public BlogUser loginByQQ(BlogUser user);

	public int regUser(BlogUser user);

	public BlogUser binding(BlogUser blogUser);

	public BlogUser getUserByUsername(String username);

}
