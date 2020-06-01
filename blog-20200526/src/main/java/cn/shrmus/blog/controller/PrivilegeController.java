package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogPrivilege;
import cn.shrmus.blog.service.PrivilegeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 权限控制器
 * <p>Title:PrivilegeController</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月6日上午2:06:53
 * @version
 */
@Controller
@Scope("prototype")
public class PrivilegeController {
	@Resource
	private PrivilegeService privilegeService;
	
	/**
	 * 删除权限
	 * @param privilegeId
	 * @return
	 */
	@RequestMapping("/privilege/delete/{privilegeId}")
	public String deletePrivilege(@PathVariable("privilegeId")Integer privilegeId) {
		if(null == privilegeId) {
			return "redirect:/main";
		}else {
//				privilegeService.deletePrivilege(privilegeId);
			return "redirect:/privilege/list";
		}
	}
	
	/**
	 * 修改权限信息
	 * @param blogPrivilege
	 * @param session
	 * @return
	 */
	@RequestMapping("/privilege/update")
	public String updatePrivilege(BlogPrivilege blogPrivilege) {
		if(null == blogPrivilege) {
			return "redirect:/main";
		}
		privilegeService.updatePrivilege(blogPrivilege);
		return "redirect:/privilege/list";
	}
	
	/**
	 * 跳转到修改权限信息的页面
	 * @return
	 */
	@RequestMapping("/privilege/updateui/{privilegeId}")
	public String updatePrivilegeUI(@PathVariable("privilegeId") Integer privilegeId,Model model) {
		if(null == privilegeId) {
			return "redirect:/main";
		}
		BlogPrivilege blogPrivilege = privilegeService.getPrivilegeById(privilegeId);
		model.addAttribute("privilege", blogPrivilege);
		List<BlogPrivilege> privilegeList = privilegeService.getPrivilegeList();
		model.addAttribute("privilegeList", privilegeList);
		return "privilege/updateui";
	}
	
	/**
	 * 添加权限
	 * @param pid
	 * @param blogPrivilege
	 * @return
	 */
	@RequestMapping("/privilege/add")
	public String addPrivilege(BlogPrivilege blogPrivilege) {
		privilegeService.addPrivilege(blogPrivilege);
		return "redirect:/privilege/list";
	}
	
	/**
	 * 跳转到添加权限的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/privilege/addui")
	public String addPrivilegeUI(Model model) {
		List<BlogPrivilege> privilegeList = privilegeService.getPrivilegeList();
		model.addAttribute("privilegeList", privilegeList);
		return "privilege/addui";
	}
	
	/**
	 * 分配权限
	 * @param type 角色或者用户
	 * @param typeId 用户id或用户id
	 * @param privilegeArray 所选择的权限id
	 * @return
	 */
	@RequestMapping("/privilege/{type}/{typeId}")
	public String allocation(@PathVariable("type") String type,@PathVariable("typeId") Integer typeId, //
							@RequestParam(value="privilegeIds",required=false) Integer[] privilegeArray) {
		if(null == type || "".equals(type)) {
			return "redirect:/main";
		}
		if(null == typeId) {
			return "redirect:/main";
		}
		List<Integer> privilegeList = new ArrayList<>();
		if(null != privilegeArray) {
			privilegeList = Arrays.asList(privilegeArray);
		}
		privilegeService.allocation(type,typeId,privilegeList);
		return "redirect:/"+type + "/list";
	}
	
	/**
	 * 跳转到分配权限的页面
	 * @return
	 */
	@RequestMapping("/privilege/{type}ui/{typeId}")
	public String allocationUI(	@PathVariable("type") String type, //
								@PathVariable("typeId") Integer typeId, //
								Model model) {
		if(null == type || "".equals(type)) {
			return "redirect:/main";
		}
		if(null == typeId) {
			return "redirect:/main";
		}
		// 查找所有权限
		List<BlogPrivilege> privilegeList = privilegeService.getPrivilegeList();
		model.addAttribute("privilegeList", privilegeList);
		// 查找用户或角色的信息
		Object object = privilegeService.getObjectById(type,typeId);
		model.addAttribute("object", object);
		// 给角色授权还是给用户授权
		model.addAttribute("type", type);
		// 保留id
		model.addAttribute("typeId", typeId);
		// 跳转到授权的页面，列出树型权限供选择
		return "privilege/allocation";
	}
	
	
	/**
	 * 查找所有权限
	 * @param model
	 * @return
	 */
	@RequestMapping("/privilege/list")
	public String getUserList(Model model) {
		List<BlogPrivilege> privilegeList = privilegeService.getPrivilegeList();
		model.addAttribute("privilegeList", privilegeList);
		return "privilege/list";
	}
	
	/**
	 * 首页没有这个跳转到主页
	 * @return
	 */
	@RequestMapping(value= {"/privilege/delete","/privilege/roleui","/privilege/role","/privilege/userui","/privilege/user","/privilege/updateui","/privilege"})
	public String toMain() {
		return "redirect:/main";
	}
}
