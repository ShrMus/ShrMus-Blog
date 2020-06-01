package cn.shrmus.blog.controller;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import cn.shrmus.blog.pojo.BlogArticle;
import cn.shrmus.blog.pojo.BlogRole;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.ArticleService;
import cn.shrmus.blog.service.RoleService;
import cn.shrmus.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 用户控制器
 * <p>Title:UserController</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月6日上午2:07:12
 * @version
 */
@Controller
@Scope("prototype")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ArticleService articleService;

//	@RequestMapping("/")
//	public String view() {
//		return "forward:/index.jsp";
//	}

	// TODO 手机验证码修改密码
	/**
	 * 路径 ${pageContext.request.contextPath}/main
	 * 跳转到主页面
	 * @return
	 */
	@RequestMapping("/main")
	public String toMain(Model model) {
		Integer top = null;     // 0（默认）表示不推荐，1表示推荐
		Integer ispass = 1;  // 审核，0未通过，1通过，2（默认）审核中
		List<BlogArticle> articleList = articleService.getArticleList(top, ispass);
		model.addAttribute("articleList", articleList);
		List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
		model.addAttribute("articleListByTop", articleListByTop);
		List<BlogArticle> articleListByHot = articleService.getArticleListByHot();
		model.addAttribute("articleListByHot", articleListByHot);
		return "forward:/home.jsp";
	}

	/**
	 * 查找用户的信息
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/userinfo/{userId}")
	public String toUserInfoUI(@PathVariable("userId") Integer userId,Model model) {
		if(null == userId) {
			return "redirect:/main";
		}
		BlogUser user = userService.getUserByUserId(userId);
		model.addAttribute("user", user);
		return "user/userinfo";
	}
	
	@RequestMapping("/user/info/{userId}")
	public String getUserByUserId(@PathVariable("userId") Integer userId,Model model) {
		if(null == userId) {
			return "redirect:/main";
		}
		BlogUser user = userService.getUserByUserId(userId);
		model.addAttribute("user", user);
		return "user/info";
	}
	
	/**
	 * 退出系统
	 * @param session
	 * @return
	 */
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/main";
	}
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/user/login")
	public String login(BlogUser user,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
		user = userService.login(user);
		if(null == user) {
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
			return "redirect:/login.jsp";
		}
		session.setAttribute("user", user);
		String preurl = request.getParameter("preurl");
		if(null == preurl || "".equals(preurl)) {
			return "redirect:/main";
		}else {
			return "redirect:"+preurl;
		}
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/user/update")
	public String updateUser(@RequestParam(value = "roleId",required=false)Integer roleId, // 
			BlogUser user) {
		if(null == user) {
			return "redirect:/main";
		}
		userService.updateUser(roleId,user);
		return "redirect:/user/userinfo/"+user.getId();
	}
	
	/**
	 * 跳转到修改用户信息的页面
	 * @return
	 */
	@RequestMapping("/user/updateui/{userId}")
	public String updateRoleUI(@PathVariable("userId") Integer userId,Model model) {
		if(null == userId) {
			return "redirect:/main";
		}
		// 查询这个id的角色
		BlogUser user = userService.getUserByUserId(userId);
		model.addAttribute("user", user);
		List<BlogRole> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return "/user/updateui";
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/user/reg")
	public String regUser(BlogUser user,Model model,RedirectAttributes redirectAttributes) {
		int result = userService.regUser(user);
		if(1 == result) {
			// 用户名已存在
//			redirectAttributes.addFlashAttribute("message1", "123");
//			redirectAttributes.addAttribute("message2", "abc");
			model.addAttribute("message", "用户名已存在");
			model.addAttribute("regUser", user);
			return "forward:/register.jsp";
		}else {
			return "redirect:/main";
		}
	}
	
	/**
	 * QQ登录前
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/user/loginbyqqbefore")
	public void loginBeforeGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (QQConnectException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * QQ登录后
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/user/loginbyqq")
	public String loginAfterPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		String preurl = request.getParameter("preurl");
		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;
			if (accessTokenObj.getAccessToken().equals("")) {
				// 我们的网站被CSRF攻击了或者用户取消了授权
				// 做一些数据统计工作
				System.out.print("没有获取到响应参数");
			} else {
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();
				request.getSession().setAttribute("demo_access_token", accessToken);
				request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));
				// 利用获取到的accessToken 去获取当前用的openid
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				if (userInfoBean.getRet() == 0) {
					BlogUser user = new BlogUser();
					// 获取openid
					user.setOpenid(openID);
					// 获取昵称
					user.setNickname(userInfoBean.getNickname());
					// 获取性别
					user.setGender("男".equals(userInfoBean.getGender())?1:0);
					// 获取QQ空间头像
					String qzoneURL = userInfoBean.getAvatar().getAvatarURL100();
					// 修改为QQ头像
					String replaceString = qzoneURL.replace("qzapp.qlogo.cn/qzapp", "thirdqq.qlogo.cn/qqapp");
					user.setIcon(replaceString);
					BlogUser blogUser = userService.loginByQQ(user);
					if(null == blogUser) {
						request.setAttribute("openid", openID);
						request.setAttribute("nickname", userInfoBean.getNickname());
						request.setAttribute("icon", replaceString);
						return "user/binding";
					}
					else {
						request.getSession().setAttribute("user", blogUser);
						if(null == preurl || "".equals(preurl)) {
							preurl = "redirect:/main";
						}else {
							preurl = "redirect:"+preurl;
						}
					}
				} else {
					System.out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
				}
			}
		} catch (QQConnectException e) {
		}
		return preurl;
	}
	
	/**
	 * 绑定已有账号
	 * @param user
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/user/binding")
	public String binding(BlogUser user,HttpServletRequest request) {
		BlogUser temp = userService.binding(user);
		if(null == temp) {
			// 绑定失败，用户名或密码错误
			request.setAttribute("openid", user.getOpenid());
			request.setAttribute("nickname", user.getNickname());
			request.setAttribute("icon", user.getIcon());
			request.setAttribute("message", "绑定失败，用户名或密码错误！");
			return "user/binding";
		}
		else {
			// 绑定成功
			userService.updateUser(null, temp);
			request.getSession().setAttribute("user", temp);
			return "redirect:/main";
		}
	}
	
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping("/user/delete/{userId}")
	public String deleleRoleByRoleId(@PathVariable("userId") Integer userId) {
		if(null == userId) {
			return "redirect:/main";
		}
// 		userService.deleleUserByUserId(userId);
		return "redirect:/user/list";
	}
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	/**
	 * 添加用户
	 * @param user 从界面传过来的用户参数
	 * @return
	 */
	@RequestMapping("/user/add")
	public String addUser(@RequestParam(value = "roleId",required=false)Integer roleId, // 
			BlogUser user,HttpSession session,Model model) {
		if(null == roleId) {
			return "redirect:/main";
		}
		if(null == user) {
			return "redirect:/main";
		}
		if(null == user.getUsername() || "".equals(user.getUsername())) {
			return "redirect:/main";
		}
		int result = userService.addUser(roleId,user);
		if(1 == result) {
			// 用户名已存在
			// 查询所有角色信息
			List<BlogRole> roleList = roleService.getRoleList();
			model.addAttribute("roleList", roleList);
			model.addAttribute("roleId", roleId);
			model.addAttribute("addUser", user);
			model.addAttribute("message", "用户名已存在！");
			return "user/addui";
		}
		return "redirect:/user/list";
	}
	
	/**
	 * 查找所有用户信息，包括用户的角色信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/list")
	public String getUserList(Model model) {
		List<BlogUser> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "user/list";
	}
	
	/**
	 * 跳转到添加用户的界面
	 * @return
	 */
	@RequestMapping("/user/addui")
	public String addUserUI(Model model) {
		// 查询所有角色信息
		List<BlogRole> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return "user/addui";
	}
	
	/**
	 * 查看我的操作记录
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/log/my")
	public String myOperation(HttpSession session,Model model) {
		BlogUser user = (BlogUser) session.getAttribute("user");
		return "forward:/user/log/"+user.getId();
	}
	
	/**
	 * 初始化用户密码
	 * @param userId
	 * @return
	 */
	@RequestMapping("/user/initPassword/{userId}")
	public String initPassword(@PathVariable("userId")Integer userId) {
		if(null == userId) {
			return "redirect:/main";
		}
		// TODO 初始化密码，还未实现
		return "redirect:/main";
	}
	
	@RequestMapping(value= {"/user/initPassword","/user/log/"})
	public String initPassword() {
		return "redirect:/main";
	}
	
	@RequestMapping(value= {"/user","/user/userinfo","/user/initPassword","/user/log","/user/delete","/user/updateui","/user/info","/user/userinfo"})
	public String toMain() {
		return "redirect:/main";
	}
	
}
