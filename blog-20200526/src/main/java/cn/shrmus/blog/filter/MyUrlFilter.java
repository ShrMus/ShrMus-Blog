package cn.shrmus.blog.filter;

import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.utils.ServletContextUtil;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 过滤器，判断用户在地址栏输入的url是否有权限访问
 * 过滤器处理的方式还可以再优化，下次用拦截器再做
 * <p>Title:MyUrlFilter</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月6日下午12:21:52
 * @version
 */
@Configuration
@WebFilter(urlPatterns = "/*")
public class MyUrlFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 获得地址栏全路径  http://localhost:8080/blog-20171206/user/login
		// System.out.println("request.getRequestURL()： " + request.getRequestURL());
		// 获得工程名和访问路径 /blog-20171206/user/login
		// System.out.println("request.getRequestURI()： " + request.getRequestURI());
		// 获得工程名 /blog-20171206
		// System.out.println("request.getContextPath()： " + request.getContextPath());
		// 获得工程下的访问路径 /user/login
		// System.out.println("request.getServletPath()： " + request.getServletPath());

		String servletPath = request.getServletPath();
		// 取出用户的权限
		BlogUser user = (BlogUser) request.getSession().getAttribute("user");
		// 要是访问这个页面需要登录
		@SuppressWarnings("unchecked")
		List<String> loginBeforePathList = (List<String>) request.getSession().getServletContext().getAttribute("applicationLoginBeforePrivilegeList");
		// 用户没有登录
		if(null == user) {
			// 标志，如果为true，表示当前url是需要登录的，如果为false，表示当前url不需要登录
			boolean loginTag = false;
			if(null != loginBeforePathList) {
				for(String path : loginBeforePathList) {
					// 如果当前访问的页面是需要登录的
					if(servletPath.contains(path)) {
						loginTag = true;
						break;
					}
				}
			}
			// 如果当前访问的页面是需要登录的
			if(true == loginTag) {
				// 如果是跳转到去登录的页面或者正在执行登录就放行
				if(servletPath.contains("/login.jsp") || servletPath.contains("/user/login")) {
					filterChain.doFilter(request, response);
				} else{
					// 否则不是去登录的页面，就重定向到登录的页面，并且登录后跳转到这个页面
					String preurl = request.getRequestURL().toString();
					response.sendRedirect(request.getContextPath()+ "/login.jsp?preurl=" + preurl);
				}
			}else {
				// 如果当前访问的页面是不需要登录的
				filterChain.doFilter(request, response);
			}
			return;  // 返回之后后面的代码不再执行，后面的代码是登录之后
		}
		
		// 取出系统所有的需要控制的访问权限
		@SuppressWarnings("unchecked")
		List<BlogPrivilege> applicationPrivilegeList = (List<BlogPrivilege>) ServletContextUtil.getServletContext().getAttribute("applicationPrivilegeList");
		
		// 标志，如果为true，表示当前url在需要控制的访问权限中，如果为false，表示当前url不需要控制
		boolean tag = false;
		for(BlogPrivilege applicationPrivilege:applicationPrivilegeList) {
			// ArrayList可能会有元素为null的情况
			if(null != applicationPrivilege) {
				List<BlogPrivilege> childPrivilegeList = applicationPrivilege.getChildPrivilegeList();
				// 如果没有子权限
				if(0 == childPrivilegeList.size()) {
					// 如果当前访问的路径在需要控制的权限中就看用户是否拥有这个权限
					if(servletPath.contains(applicationPrivilege.getUrl())) {
						tag = true;
						// 如果为true，表示当前url在用户的访问权限中，如果为false表示当前的url不在用户访问权限中
						boolean userTag = false;
						for(BlogPrivilege userPrivilege : user.getPrivilegeList()) {
							// 如果用户的权限包含这个url就放行
							if(servletPath.contains(userPrivilege.getUrl())) {
								filterChain.doFilter(request, response);
								userTag = true;
								break;
							}
						}
						// 如果用户的权限不包含这个url就跳转到没有权限访问的页面
						if(false == userTag) {
							response.sendRedirect(request.getContextPath()+ "/error.jsp");
							return;
						}
					}
				} else {
					// 如果为true，表示当前url在用户的访问权限中，如果为false表示当前的url不在用户访问权限中
					boolean userTag = false;
					for(BlogPrivilege applicationChildPrivilege : childPrivilegeList) {
						// 如果当前访问的路径在需要控制的权限中就看用户是否拥有这个权限
						if(servletPath.contains(applicationChildPrivilege.getUrl())) {
							tag = true;
							for(BlogPrivilege userPrivilege : user.getPrivilegeList()) {
								// 如果用户的权限包含这个url就放行
								if(servletPath.contains(userPrivilege.getUrl())) {
									filterChain.doFilter(request, response);
									userTag = true;
									break;
								}
							}
							// 如果用户的权限不包含这个url就跳转到没有权限访问的页面
							if(false == userTag) {
								response.sendRedirect(request.getContextPath()+ "/error.jsp");
								return;
							}
							break;
						}
					}
					if(true == userTag) {
						break;
					}
				}
			}
		}
		// 当前url不需要控制
		if(false == tag) {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
