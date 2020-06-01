package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogQuestion;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.QuestionService;
import cn.shrmus.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private UserService userService;
	@Value("${SENSITIVEWORDS_PATH}")
	private String SENSITIVEWORDS_PATH;
	
	/**
	 * 导入索引
	 * @return
	 */
	@RequestMapping("/question/index/import")
	public String importIndex() {
		questionService.indexImport();
		return "redirect:/question/list";
	}
	
	/**
	 * 关键字查询
	 * @param queryString
	 * @param model
	 * @return
	 */
	@RequestMapping("/question/index/search")
	public String search(HttpServletRequest request,Model model) {
		List<BlogQuestion> questionList = new ArrayList<BlogQuestion>();
		String keywords = request.getParameter("keywords");
		if(null != keywords && !"".equals(keywords)) {
			try {
				questionList = questionService.indexSearch(keywords);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("keywords", keywords);
			model.addAttribute("questionList", questionList);
		}
		return "question/list";
	}
	
	/**
	 * 采纳
	 * @param blogQuestion
	 * @param model
	 * @return
	 */
	@RequestMapping("/question/accpet")
	public String accpetQuestion(@RequestParam("questionId") Integer questionId, //
								@RequestParam("answerId") Integer answerId, //
								@RequestParam("userIdReply") Integer userIdReply, //
								HttpSession session,Model model) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		if(null == blogUser) {
			return "redirect:/login.jsp";
		}else {
			questionService.accpetQuestion(questionId,answerId,userIdReply);
		}
		return "redirect:/question/"+questionId;
	}
	
	/**
	 * 根据id查看提问的信息
	 * @return
	 */
	@RequestMapping("/question/{questionId}")
	public String getQuestionById(@PathVariable("questionId") Integer questionId,Model model) {
		if(null == questionId) {
			return "redirect:/main";
		}
		else {
			BlogQuestion blogQuestion = questionService.getQuestionById(questionId);
			boolean tag = false;
			List<BlogQuestion> answerList = blogQuestion.getQuestionList();
			for(BlogQuestion answer : answerList) {
				if(1 == answer.getQuestionAccpeted()) {
					tag = true;
					break;
				}
			}
			model.addAttribute("tag", tag);
			model.addAttribute("question", blogQuestion);
			return "question/info";
		}
	}
	
	/**
	 * 添加提问
	 * @param 
	 */
	@RequestMapping("/question/add")
	public String addQuestion(BlogQuestion blogQuestion,HttpSession session,Model model) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		// 标志，0表示没有敏感词，1表示有敏感词
		int tag = 0;
		// 查看用户的积分是否够悬赏
		// 加载敏感词文件
		String path = this.getClass().getClassLoader().getResource(SENSITIVEWORDS_PATH).getPath();
		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			if(null != file) {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				List<String> wordList = new ArrayList<>();
				String string = bufferedReader.readLine();
				while(null != string) {
					wordList.add(string);
					string = bufferedReader.readLine();
				}
				for(String str : wordList) {
					if(blogQuestion.getQuestionContent().contains(str)) {
						tag = 1;
						break;
					}
				}
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
		if(0 == tag) {
			// 判断是提问
			if(0 == blogQuestion.getQuestionPid()) {
				// 如果当前提问的用户积分不足
				if(blogUser.getIntegral() < blogQuestion.getQuestionIntegral()) {
					model.addAttribute("message", "您当前的积分不足！");
					model.addAttribute("question", blogQuestion);
					return "question/addui";
				}
				// 扣掉用户的积分
				blogUser.setIntegral(blogUser.getIntegral() - blogQuestion.getQuestionIntegral());
				userService.updateUser(null, blogUser);
			}
			blogQuestion.setBlogUserAuthor(blogUser);
			questionService.addQuestion(blogQuestion);
			return "redirect:/question/list";
		}else {
			model.addAttribute("message", "提问内容包含敏感词！");
			model.addAttribute("question", blogQuestion);
			return "question/addui";
		}
	}
	
	/**
	 * 跳转到发表问题的页面
	 * @return
	 */
	@RequestMapping("/question/addui")
	public String addQuestionUI() {
		return "question/addui";
	}
	
	/**
	 * 查找所有问答信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/question/list")
	public String getQuestionList(Model model) {
		List<BlogQuestion> questionList = questionService.getQuestionList();
		model.addAttribute("questionList", questionList);
		return "question/list";
	}
	
	@RequestMapping("/question")
	public String toMain() {
		return "redirect:/main";
	}
}
