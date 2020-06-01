package cn.shrmus.blog.listener;

import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 监听器不在容器中，不能用注入的方式获取PrivilegeService 
 * 程序一启动就查询系统中所有需要控制的权限，放到application作用域中
 * @author Shr
 *
 */
@Configuration
@WebListener
public class InitPrivilegeListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 这里为什么不能用这种方式获取容器，在spring启动的时候已经创建了一个容器，这里又new了一个容器，两个不同的容器
		//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

		// 容器启动失败，NullPointException
		ServletContext application = event.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		
		PrivilegeService privilegeService = ac.getBean(PrivilegeService.class);
		
		// 查找所有权限，放在最大的作用域中，用来显示能够访问的权限
		List<BlogPrivilege> privilegeList = privilegeService.getPrivilegeList();
		application.setAttribute("applicationPrivilegeList", privilegeList);
		
		// 访问前需要登录的路径，文件地址
		String path = this.getClass().getClassLoader().getResource("loginbeforeurl.txt").getPath();
		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			if(null != file) {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				List<String> loginBeforePathList = new ArrayList<>();
				String string = bufferedReader.readLine();
				while(null != string) {
					loginBeforePathList.add(string);
					string = bufferedReader.readLine();
				}
				application.setAttribute("applicationLoginBeforePrivilegeList", loginBeforePathList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
