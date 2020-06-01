package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogRole;
import cn.shrmus.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 角色控制器
 * <p>Title:RoleController</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月6日上午2:07:03
 * @version
 */
@Controller
@Scope("prototype")
public class RoleController {
	@Autowired
	private RoleService roleService;

	/**
	 * 根据角色id删除角色
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/role/delete/{roleId}")
	public String deleleRoleByRoleId(@PathVariable("roleId") Integer roleId) {
		if(null == roleId) {
			return "redirect:/main";
		}
//			roleService.deleleRoleByRoleId(roleId);
		return "redirect:/role/list";
	}
	
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	@RequestMapping("/role/update")
	public String updateRole(BlogRole role) {
		if(null == role) {
			return "redirect:/main";
		}
		if(null == role.getId()) {
			return "redirect:/main";
		}
		roleService.updateRole(role);
		return "redirect:/role/list";
	}
	
	/**
	 * 跳转到修改角色信息的页面
	 * @return
	 */
	@RequestMapping("/role/updateui/{roleId}")
	public String updateRoleUI(@PathVariable("roleId") Integer roleId,Model model) {
		if(null == roleId) {
			return "redirect:/main";
		}
		// 查询这个id的角色
		BlogRole role = roleService.getRoleByRoleId(roleId);
		model.addAttribute("role", role);
		return "role/updateui";
	}
	
	/**
	 * 查询所有角色列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/role/list")
	public String getRoleList(Model model) {
		List<BlogRole> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return "role/list";
	}
	
	/**
	 * 添加角色
	 * @param role
	 */
	@RequestMapping("/role/add")
	public String addRole(BlogRole role) {
		if(null == role) {
			return "redirect:/main";
		}
		if(null == role.getName() || "".equals(role.getName())) {
			return "redirect:/main";
		}
		roleService.addRole(role);
		return "redirect:/role/list";
	}
	
	/**
	 * 跳转到添加角色的页面
	 * @return
	 */
	@RequestMapping("/role/addui")
	public String addRoleUI() {
		return "role/addui";
	}
	
	@RequestMapping(value= {"/role/delete","/role/updateui","/role"})
	public String toMain() {
		return "redirect:/main";
	}
}
