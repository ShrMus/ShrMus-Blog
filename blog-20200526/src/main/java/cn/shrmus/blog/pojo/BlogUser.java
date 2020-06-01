package cn.shrmus.blog.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 用户
 * <p>Title:BlogUser</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月5日下午8:36:06
 * @version
 */
public class BlogUser implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String openid;

    private String nickname;

    private String realname;

    private String phone;

    private String email;

    private Integer gender;

    private String icon;
    
    private Integer integral;
    
    /**
	 * 用户所有角色
	 */
	private List<BlogRole> userRoleList;

	/**
	 * 用户拥有的权限列表
	 */
	private List<BlogPrivilege> privilegeList;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<BlogRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<BlogRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public List<BlogPrivilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<BlogPrivilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
}