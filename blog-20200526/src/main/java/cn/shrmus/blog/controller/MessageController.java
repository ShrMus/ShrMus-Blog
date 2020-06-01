package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogLeaveMessage;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.MessageService;
import cn.shrmus.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("prototype")
public class MessageController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	/**
	 * 删除留言
	 * @param messageId
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/message/delete")
	@ResponseBody
	public String deleteMessageById(@RequestParam("messageId") Integer messageId, // 
									@RequestParam("userId") Integer userId,Model model) {
		if(null == messageId) {
			return "/main";
		}
		if(null == userId) {
			return "/main";
		}
		else {
			messageService.deleteMessageById(messageId);
			return "/message/"+userId;
		}
	}
	
	/**
	 * 发表留言
	 * @param 
	 */
	@RequestMapping("/message/add")
	public String addMessage(BlogLeaveMessage blogLeaveMessage, HttpSession session) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		blogLeaveMessage.setUserIdAuthor(blogUser.getId());
		messageService.addMessage(blogLeaveMessage);
		return "redirect:/message/user"+blogLeaveMessage.getUserId();
	}
	
	/**
	 * 查询某个用户的留言板
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/message/user{userId}")
	public String getMessageListByUserId(@PathVariable("userId") Integer userId,Model model, //
									HttpServletRequest request) {
		if(null == userId) {
			return "redirect:/main";
		}else {
			List<BlogLeaveMessage> messageList = messageService.getMessageListByUserId(userId);
			model.addAttribute("messageList", messageList);
			model.addAttribute("userId", userId);
			BlogUser user = userService.getUserByUserId(userId);
			request.setAttribute("user", user);
			return "message/list";
		}
	}
	
	@RequestMapping(value= {"/message"})
	public String toMain() {
		return "redirect:/main";
	}
}
