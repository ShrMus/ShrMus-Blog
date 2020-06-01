package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogAlbum;
import cn.shrmus.blog.pojo.BlogPicture;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.AlbumService;
import cn.shrmus.blog.service.UserService;
import cn.shrmus.blog.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 相册控制器
 * <p>Title:AlbumController</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年4月1日上午1:22:56
 * @version
 */
@Controller
@Scope("prototype")
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	@Autowired
	private UserService userService;
	
	
	/**
	 * 修改相册
	 * @param blogAlbum
	 * @return
	 */
	@RequestMapping("/album/update")
	public String updateAlbum(BlogAlbum blogAlbum) {
		albumService.updateAlbum(blogAlbum);
		return "redirect:/album/user"+blogAlbum.getUserId();
	}
	
	/**
	 * 跳转到修改相册
	 * @param albumId
	 * @param model
	 * @return
	 */
	@RequestMapping("/album/updateui/{albumId}")
	public String toUpdateUI(@PathVariable("albumId") Integer albumId,Model model) {
		BlogAlbum blogAlbum = albumService.getAlbumById(albumId);
		model.addAttribute("album", blogAlbum);
		return "album/updateui";
	}
	
	/**
	 * 删除相册
	 * @param blogAlbum
	 * @return
	 */
	@RequestMapping("/album/delete")
	public String deleteAlbum(BlogAlbum blogAlbum,HttpSession session) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		if(null == blogAlbum.getAlbumId()) {
			return "redirect:/album/user"+blogUser.getId();
		}
		albumService.deleteAlbum(blogAlbum);
		return "redirect:/album/user"+blogUser.getId();
	}
	
	/**
	 * 跳转到删除相册的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/album/deleteui")
	public String deleteAlbumUI(HttpSession session,Model model) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		List<BlogAlbum> blogAlbumList = albumService.getAlbumListByUserId(blogUser.getId());
		model.addAttribute("albumList", blogAlbumList);
		return "album/delete";
	}
	
	/**
	 * 设置相册封面
	 * @param albumId
	 * @param model
	 * @return
	 */
	@RequestMapping("/album/coverimg")
	public String setCoverImg(BlogAlbum blogAlbum,HttpSession session,Model model) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		BlogAlbum album = albumService.getAlbumById(blogAlbum.getAlbumId());
		if(blogUser.getId() == album.getUserId()) {
			String albumCoverImg = blogAlbum.getAlbumCoverImg();
			int index = albumCoverImg.indexOf("/", 10);
			String substring = albumCoverImg.substring(index + 1);
			blogAlbum.setAlbumCoverImg(substring);
			albumService.updateAlbum(blogAlbum);
		}
		return "redirect:/album/user"+blogUser.getId();
	}
	
	/**
	 * 跳转到设置封面
	 * @param albumId
	 * @param model
	 * @return
	 */
	@RequestMapping("/album/coverimgui/{albumId}")
	public String setCoverImgUI(@PathVariable("albumId") Integer albumId,Model model) {
		List<BlogPicture> blogPictureList = albumService.getPicturesByAlbumId(albumId);
		BlogAlbum blogAlbum = albumService.getAlbumById(albumId);
		model.addAttribute("pictureList", blogPictureList);
		model.addAttribute("album", blogAlbum);
		return "album/coverimg";
	}
	
	/**
	 * 删除图片
	 * @param albumId
	 * @param pictureUrlArray
	 * @return
	 */
	@RequestMapping("/picture/delete")
	public String deletePicture(@RequestParam("dataJsonStr")String str,HttpSession session) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		List<BlogPicture> blogPictureList = JsonUtils.jsonToList(str, BlogPicture.class);
		albumService.deletePicture(blogPictureList);
		return "redirect:/album/"+blogUser.getId();
	}
	
	/**
	 * 跳转到批量删除图片的页面
	 * @param albumId
	 * @param model
	 * @return
	 */
	@RequestMapping("/picture/deleteui/{albumId}")
	public String deletePicture(@PathVariable("albumId") Integer albumId,Model model) {
		List<BlogPicture> blogPictureList = albumService.getPicturesByAlbumId(albumId);
		BlogAlbum blogAlbum = albumService.getAlbumById(albumId);
		model.addAttribute("pictureList", blogPictureList);
		model.addAttribute("album", blogAlbum);
		return "album/deletepicture";
	}
	
	/**
	 * 上传图片
	 * @param uploadFile
	 * @param albumId
	 * @return
	 */
	@RequestMapping(value = "/album/upload", produces = "text/html;charset=UTF-8")
	public String uploadPicture(@RequestParam("file") MultipartFile[] uploadFile, //
							@RequestParam("albumId") Integer albumId) {
		albumService.uploadPicture(uploadFile,albumId);
		return "redirect:/album/"+albumId;
	}
	
	/**
	 * 跳转到上传照片的页面
	 * @return
	 */
	@RequestMapping("/album/uploadui")
	public String uploadImgUI(HttpSession session,Model model) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		List<BlogAlbum> blogAlbumList = albumService.getAlbumListByUserId(blogUser.getId());
		model.addAttribute("albumList", blogAlbumList);
		return "album/upload";
	}
	
	/**
	 * 查看某一个相册中的照片
	 * @param albumId
	 * @return
	 */
	@RequestMapping("/album/{albumId}")
	public String getPicturesByAlbumId(@PathVariable("albumId") Integer albumId,Model model) {
		List<BlogPicture> blogPictureList = albumService.getPicturesByAlbumId(albumId);
		BlogAlbum blogAlbum = albumService.getAlbumById(albumId);
		model.addAttribute("pictureList", blogPictureList);
		model.addAttribute("album", blogAlbum);
		return "album/info";
	}
	
	/**
	 * 添加相册
	 * @param 
	 */
	@RequestMapping("/album/add")
	public String addAlbum(BlogAlbum blogAlbum,HttpSession session,Model model) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		blogAlbum.setUserId(blogUser.getId());
		blogAlbum.setBlogUser(blogUser);
		albumService.addAlbum(blogAlbum);
		return "redirect:/album/user"+blogUser.getId();
	}
	
	/**
	 * 跳转到创建相册的页面
	 * @return
	 */
	@RequestMapping("/album/addui")
	public String addAlbumUI() {
		return "album/addui";
	}
	
	/**
	 * 获取当前登录用户的相册列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/album/user{userId}")
	public String getListByUserId(@PathVariable("userId")Integer userId,HttpServletRequest request,Model model) {
		if(null == userId) {
			return "redirect:/login.jsp";
		} else {
			List<BlogAlbum> blogAlbumList = albumService.getListByUserId(userId);
			BlogUser blogUser = userService.getUserByUserId(userId);
			model.addAttribute("user", blogUser);
			String defaultImgUrl = request.getContextPath()+ "/src/main/static/img/default.png";
			model.addAttribute("albumList", blogAlbumList);
			model.addAttribute("defaultImgUrl", defaultImgUrl);
			return "album/list";
		}
	}
	
	@RequestMapping("/album/userinfo{userId}")
	public String getListByUserInfoId(@PathVariable("userId")Integer userId,HttpServletRequest request,Model model) {
		if(null == userId) {
			return "redirect:/login.jsp";
		} else {
			List<BlogAlbum> blogAlbumList = albumService.getListByUserId(userId);
			BlogUser blogUser = userService.getUserByUserId(userId);
			model.addAttribute("user", blogUser);
			String defaultImgUrl = request.getContextPath()+ "/src/main/static/img/default.png";
			model.addAttribute("albumList", blogAlbumList);
			model.addAttribute("defaultImgUrl", defaultImgUrl);
			return "album/userinfo-list";
		}
	}
	
	@RequestMapping(value= {"/album","/album/userinfo","/album/user","/picture/deleteui","/album/coverimgui"})
	public String toMain() {
		return "redirect:/main";
	}
}
