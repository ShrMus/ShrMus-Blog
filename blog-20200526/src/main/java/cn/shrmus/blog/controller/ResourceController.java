package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogResource;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	
	
	/**
	 * 导入索引
	 * @return
	 */
	@RequestMapping("/resource/index/import")
	public String importIndex() {
		resourceService.indexImport();
		return "redirect:/resource/list";
	}
	
	/**
	 * 关键字查询
	 * @param queryString
	 * @param model
	 * @return
	 */
	@RequestMapping("/resource/index/search")
	public String search(HttpServletRequest request,Model model) {
		List<BlogResource> resourceList = new ArrayList<BlogResource>();
		String keywords = request.getParameter("keywords");
		if(null != keywords && !"".equals(keywords)) {
			try {
				resourceList = resourceService.indexSearch(keywords);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("keywords", keywords);
			model.addAttribute("resourceList", resourceList);
		}
		return "resource/list";
	}
	
	/**
	 * 审核结果
	 */
	@RequestMapping("/resource/verify")
	@ResponseBody
	public void verifyResource(BlogResource blogResource) {
		resourceService.updateResource(blogResource);
	}
	
	/**
	 * 查找审核中的资源
	 * @param model
	 * @return
	 */
	@RequestMapping("/resource/verifyui")
	public String verifyResourceUI(Model model) {
		List<BlogResource> blogResourceList = resourceService.getResourcePassing();
		model.addAttribute("resourceList", blogResourceList);
		return "resource/verify";
	}
	
	/**
	 * 查找某个用户上传的资源
	 * @param userId
	 * @return
	 */
	@RequestMapping("/resource/user{userId}")
	public String getResourceListByUserId(@PathVariable("userId")Integer userId,Model model) {
		if(userId == null) {
			return "redirect:/main";
		}else {
			List<BlogResource> blogResourceList = resourceService.getResourceListByUserId(userId);
			model.addAttribute("resourceList", blogResourceList);
			return "resource/userlist";
		}
	}
	
	/**
	 * 下载文件
	 * @param path
	 * @param fileName
	 * @param fileSize
	 * @param response
	 */
	@RequestMapping("/resource/downloadfile")
	@ResponseBody
	public void downloadFile(@ModelAttribute("url") String path, //
							@ModelAttribute("fileName") String fileName, //
							@ModelAttribute("fileSize") Integer fileSize, //
							HttpServletResponse response) {
		try {
			URL url = new URL(path);
			// 以流的形式下载文件。
			InputStream fis = url.openStream();
			byte[] buffer = new byte[fileSize];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(),"ISO-8859-1"));
			response.addHeader("Content-Length", "" + fileSize);
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载资源
	 * @param resourceId
	 * @param session
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping("/resource/download/{resourceId}")
	public String downloadResource(@PathVariable("resourceId")Integer resourceId, //
								HttpSession session,Model model, // 
								HttpServletResponse response, // 
								RedirectAttributes redirectAttributes) {
		if(null == resourceId) {
			return "redirect:/main";
		}
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		BlogResource blogResource = resourceService.getResourceById(resourceId);
		// 判断当前登录用户的积分是否够用
		if(blogUser.getIntegral() < blogResource.getResourceIntegral()) {
			model.addAttribute("resource", blogResource);
			model.addAttribute("message", "您当前的积分不足！");
			return "resource/info";
		}else {
			resourceService.downloadResource(blogUser,blogResource);
			redirectAttributes.addFlashAttribute("url", blogResource.getResourceUrl());
			redirectAttributes.addFlashAttribute("fileName", blogResource.getResourceFilename());
			redirectAttributes.addFlashAttribute("fileSize", blogResource.getResourceSize());
			return "redirect:/resource/downloadfile";
		}
	}
	
	/**
	 * 上传资源
	 * @param blogResource
	 * @return
	 */
	@RequestMapping("/resource/upload")
	public String uploadResource(@RequestParam("file") MultipartFile uploadFile, // 
								BlogResource blogResource,HttpSession session) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		blogResource.setUserId(blogUser.getId());
		blogResource.setBlogUser(blogUser);
		resourceService.uploadResource(uploadFile,blogResource);
		return "redirect:/resource/list";
	}
	
	/**
	 * 跳转到上传资源的页面
	 * @return
	 */
	@RequestMapping("/resource/uploadui")
	public String uploadResourceUI() {
		return "resource/upload";
	}
	
	/**
	 * 根据id查找资源信息
	 * @param resourceId
	 * @return
	 */
	@RequestMapping("/resource/{resourceId}")
	public String getResourceById(@PathVariable("resourceId")Integer resourceId,Model model) {
		if(null == resourceId) {
			return "redirect:/main";
		}else {
			BlogResource blogResource = resourceService.getResourceById(resourceId);
			model.addAttribute("resource", blogResource);
			return "resource/info";
		}
	}
	
	/**
	 * 查找所有上传的资源列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/resource/list")
	public String getResourceList(Model model) {
		List<BlogResource> blogResourceList = resourceService.getResourceList();
		model.addAttribute("resourceList", blogResourceList);
		return "resource/list";
	}
	
	@RequestMapping(value= {"/resource","/resource/user","/resource/download","/resource/index"})
	public String toMain() {
		return "redirect:/main";
	}
}
