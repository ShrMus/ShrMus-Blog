package cn.shrmus.blog.controller;

import cn.shrmus.blog.pojo.BlogArticle;
import cn.shrmus.blog.pojo.BlogArticleComment;
import cn.shrmus.blog.pojo.BlogArticleType;
import cn.shrmus.blog.pojo.BlogUser;
import cn.shrmus.blog.service.ArticleService;
import cn.shrmus.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章控制器
 * <p>Title:ArticleController</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月11日上午4:04:41
 * @version
 */
@Controller
@Scope("prototype")
public class ArticleController {
	// TODO 修改文章删除图片未删除文件服务器上的图片
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Value("${SENSITIVEWORDS_PATH}")
	private String SENSITIVEWORDS_PATH;
	
	/**
	 * 上传图片
	 * @param uploadFile
	 * @param albumId
	 * @return
	 */
	@RequestMapping(value="/article/uploadpicture", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String uploadPicture(@RequestParam("pictureName") MultipartFile uploadFile) {
		String pictureUrl = articleService.uploadPicture(uploadFile);
		return pictureUrl;
	}
	
	/**
	 * 查找最新发表的文章
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/new")
	public String getArticleListNew(Model model) {
		List<BlogArticle> blogArticleList = articleService.getArticleListNew();
		model.addAttribute("articleList", blogArticleList);
		List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleTypeList", articleTypeList);
		return "article/list";
	}
	
	/**
	 * 查找推荐文章
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/toparticle")
	public String getArticleListByTop(Model model) {
		List<BlogArticle> blogArticleList = articleService.getArticleListByTop();
		List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleList", blogArticleList);
		model.addAttribute("articleTypeList", articleTypeList);
		return "article/list";
	}
	
	/**
	 * 设置推荐文章
	 * @param str
	 * @param session
	 * @return
	 */
	@RequestMapping("/article/top")
	public String setTopArticleList(BlogArticle blogArticle) {
		List<BlogArticle> blogArticleList = new ArrayList<>();
		blogArticleList.add(blogArticle);
		articleService.setTopArticleList(blogArticleList);
		return "redirect:/article/list";
	}
//	@RequestMapping("/article/top")
//	public String setTopArticleList(@RequestParam("dataJsonStr")String str) {
//		List<BlogArticle> blogArticleList = JsonUtils.jsonToList(str, BlogArticle.class);
//		articleService.setTopArticleList(blogArticleList);
//		return "redirect:/article/list";
//	}
	
	/**
	 * 浏览量从高到低查找，跳转到设置推荐文章的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/topui")
	public String getArticleListByTopUI(Model model) {
		List<BlogArticle> blogArticleList = articleService.getArticleListByTopUI();
		model.addAttribute("articleList", blogArticleList);
		List<BlogArticleType> blogArticleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleTypeList", blogArticleTypeList);
		List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
		model.addAttribute("articleListByTop", articleListByTop);
		List<BlogArticle> articleListNew = articleService.getArticleListNew();
		model.addAttribute("articleListNew", articleListNew);
		return "article/top";
	}
	
	/**
	 * 根据文章类型查找文章
	 * @param articleTypeId
	 * @return
	 */
	@RequestMapping("/articlebytype/{articleTypeId}")
	public String getArticleListByArticleTypeId(@PathVariable Integer articleTypeId,Model model) {
		if(null == articleTypeId) {
			return "redirect:/article/list";
		}else {
			BlogArticleType blogArticleType = articleService.getArticleTypeById(articleTypeId);
			model.addAttribute("keywords", blogArticleType.getArticleTypeName());
			List<BlogArticle> blogArticleList = articleService.getArticleListByArticleTypeId(articleTypeId);
			List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
			model.addAttribute("articleList", blogArticleList);
			model.addAttribute("articleTypeList", articleTypeList);
			List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
			model.addAttribute("articleListByTop", articleListByTop);
			List<BlogArticle> articleListNew = articleService.getArticleListNew();
			model.addAttribute("articleListNew", articleListNew);
			return "article/list";
		}
	}
	
	/**
	 * 审核文章
	 * @param blogArticle
	 */
	@RequestMapping("/article/verify")
	@ResponseBody
	public void verifyArticle(BlogArticle blogArticle) {
		articleService.updatePassArticle(blogArticle);
	}
	
	/**
	 * 查找审核中的文章
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/verifyui")
	public String verifyArticleUI(Model model) {
		List<BlogArticle> blogArticleList = articleService.getArticlePassing();
		model.addAttribute("articleList", blogArticleList);
		List<BlogArticleType> blogArticleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleTypeList", blogArticleTypeList);
		List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
		model.addAttribute("articleListByTop", articleListByTop);
		List<BlogArticle> articleListNew = articleService.getArticleListNew();
		model.addAttribute("articleListNew", articleListNew);
		return "article/verify";
	}
	
	/**
	 * 查找某个用户发表的博客，自己或他人
	 * @param userId
	 * @return
	 */
	@RequestMapping("/article/user{userId}")
	public String getArticleListByUserId(@PathVariable("userId")Integer userId, //
										Model model,HttpServletRequest request) {
		if(userId == null) {
			return "redirect:/login.jsp";
		}else {
			List<BlogArticle> blogArticleList = articleService.getArticleListByUserId(userId);
			model.addAttribute("articleList", blogArticleList);
			List<BlogArticleType> blogArticleTypeList = articleService.getArticleTypeList();
			model.addAttribute("articleTypeList", blogArticleTypeList);
			BlogUser blogUser = userService.getUserByUserId(userId);
			request.setAttribute("user", blogUser);
			List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
			model.addAttribute("articleListByTop", articleListByTop);
			List<BlogArticle> articleListNew = articleService.getArticleListNew();
			model.addAttribute("articleListNew", articleListNew);
			return "article/userlist";
		}
	}
	
	/**
	 * 删除文章评论
	 * @param articleCommentId
	 * @param model
	 * @return
	 */
	@RequestMapping("/articlecomment/delete")
	@ResponseBody
	public String deleteArticleCommentByArticleId(@RequestParam("articleCommentId") Integer articleCommentId, //
												@RequestParam("articleId") Integer articleId,Model model) {
		if(null == articleCommentId) {
			return "/main";
		}
		if(null == articleId) {
			return "/main";
		}
		else {
			articleService.deleteArticleCommentByArticleCommentId(articleCommentId);
			return "/article/search/"+articleId;
		}
	}
	
	/**
	 * 添加文章评论
	 * @param 
	 */
	@RequestMapping("/articlecomment/add")
	public String addArticleComment(BlogArticleComment blogArticleComment,HttpSession session) {
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		blogArticleComment.setUserIdAuthor(blogUser.getId());
		articleService.addArticleComment(blogArticleComment);
		return "redirect:/article/search/"+blogArticleComment.getArticleId();
	}
	
	/**
	 * 导入索引
	 * @return
	 */
	@RequestMapping("/article/index/import")
	public String importIndex() {
		articleService.indexImport();
		return "redirect:/article/list";
	}
	
	/**
	 * 关键字查询
	 * @param queryString
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/index/search")
	public String search(HttpServletRequest request,Model model) {
		List<BlogArticle> articleList = new ArrayList<BlogArticle>();
		String keywords = request.getParameter("keywords");
		if(null != keywords && !"".equals(keywords)) {
			try {
				// queryString = new String(queryString.getBytes("iso-8859-1"),"utf-8");
				articleList = articleService.indexSearch(keywords);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("keywords", keywords);
			model.addAttribute("articleList", articleList);
			List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
			model.addAttribute("articleTypeList", articleTypeList);
			List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
			model.addAttribute("articleListByTop", articleListByTop);
			List<BlogArticle> articleListNew = articleService.getArticleListNew();
			model.addAttribute("articleListNew", articleListNew);
		}
		return "article/list";
	}
	
	/**
	 * 删除文章
	 * @param articleId
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/delete/{articleId}")
	public String deleteArticleById(@PathVariable("articleId") Integer articleId,Model model) {
		if(null == articleId) {
			return "redirect:/main";
		}else {
			BlogArticle blogArticle = articleService.getArticleById(articleId);
			articleService.deleteArticleById(articleId);
			return "redirect:/article/user"+blogArticle.getUserId();
		}
	}
	
	/**
	 * 查看文章
	 * @param articleId
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/search/{articleId}")
	public String getArticleById(@PathVariable("articleId") Integer articleId,Model model) {
		if(null == articleId) {
			return "redirect:/main";
		}else {
			BlogArticle blogArticle = articleService.getArticleById(articleId);
			model.addAttribute("article", blogArticle);
			List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
			model.addAttribute("articleTypeList", articleTypeList);
			List<BlogArticle> articleListNew = articleService.getArticleListNew();
			model.addAttribute("articleListNew", articleListNew);
			return "article/info";
		}
	}
	
	/**
	 * 编辑文章并提交
	 * @param blogArticleType
	 * @return
	 */
	@RequestMapping("/article/update")
	public String updateArticle(BlogArticle blogArticle,Model model) {
		// 标志，0表示没有敏感词，1表示有敏感词
		int tag = 0;
		// 加载敏感词文件
		String path = ArticleController.class.getClassLoader().getResource(SENSITIVEWORDS_PATH).getPath();
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
					if(blogArticle.getArticleContent().contains(str)) {
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
			articleService.updateArticle(blogArticle);
		}else {
			List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
			model.addAttribute("articleTypeList", articleTypeList);
			model.addAttribute("message", "文章内容包含敏感词！");
			model.addAttribute("article", blogArticle);
			return "article/updateui";
		}
		return "redirect:/article/list";
	}
	
	/**
	 * 跳转到编辑文章的页面
	 * @return
	 */
	@RequestMapping("/article/updateui/{articleId}")
	public String updateArticleUI(@PathVariable("articleId") Integer articleId,Model model) {
		if(null == articleId) {
			return "redirect:/main";
		}
		BlogArticle article = articleService.getArticleById(articleId);
		List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleTypeList", articleTypeList);
		model.addAttribute("article", article);
		return "article/updateui";
	}
	
	/**
	 * 查询所有文章
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/list")
	public String getArticleList(Model model) {
		Integer top = null;     // 0（默认）表示不推荐，1表示推荐
		Integer ispass = 1;  // 审核，0未通过，1通过，2（默认）审核中
		
		List<BlogArticle> articleList = articleService.getArticleList(top, ispass);
		List<BlogArticleType> blogArticleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleList", articleList);
		model.addAttribute("articleTypeList", blogArticleTypeList);
		List<BlogArticle> articleListByTop = articleService.getArticleListByTop();
		model.addAttribute("articleListByTop", articleListByTop);
		List<BlogArticle> articleListNew = articleService.getArticleListNew();
		model.addAttribute("articleListNew", articleListNew);
		return "article/list";
	}
	
	/**
	 * 发表文章
	 * @param 
	 */
	@RequestMapping("/article/add")
	public String addArticle(HttpSession session,BlogArticle blogArticle,Model model){
		BlogUser blogUser = (BlogUser) session.getAttribute("user");
		// 标志，0表示没有敏感词，1表示有敏感词
		int tag = 0;
		blogArticle.setUserId(blogUser.getId());
		// 加载敏感词文件
		String path = ArticleController.class.getClassLoader().getResource(SENSITIVEWORDS_PATH).getPath();
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
					if(blogArticle.getArticleContent().contains(str)) {
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
			articleService.addArticle(blogArticle);
		}else {
			List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
			model.addAttribute("articleTypeList", articleTypeList);
			model.addAttribute("message", "文章内容包含敏感词！");
			model.addAttribute("article", blogArticle);
			return "article/addui";
		}
		return "redirect:/article/list";
	}
	
	/**
	 * 跳转到发表文章的页面
	 * @return
	 */
	@RequestMapping("/article/addui")
	public String addArticleUI(Model model) {
		List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleTypeList", articleTypeList);
		return "article/addui";
	}
	
	/**
	 * 修改文章分类信息
	 * @param blogArticleType
	 * @return
	 */
	@RequestMapping("/articletype/update")
	public String updateArticleType(BlogArticleType blogArticleType) {
		articleService.updateArticleType(blogArticleType);
		return "redirect:list";
	}
	
	/**
	 * 跳转到修改文章分类的页面
	 * @return
	 */
	@RequestMapping("/articletype/updateui/{articletypeId}")
	public String updateArticleTypeUI(@PathVariable("articletypeId") Integer articleTypeId,Model model) {
		if(null == articleTypeId) {
			return "redirect:/main";
		}
		BlogArticleType articleType = articleService.getArticleTypeById(articleTypeId);
		model.addAttribute("articleType", articleType);
		return "articletype/updateui";
	}
	
	/**
	 * 查询所有文章分类列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/articletype/list")
	public String getArticleTypeList(Model model) {
		List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
		model.addAttribute("articleTypeList", articleTypeList);
		return "articletype/list";
	}
	
//	@RequestMapping("/articletypebytable/list")
//	@ResponseBody
//	public LayUIPojo<BlogArticleType> getArticleTypeListByTable(Model model) {
//		List<BlogArticleType> articleTypeList = articleService.getArticleTypeList();
//		LayUIPojo<BlogArticleType> layUIPojo = new LayUIPojo<>();
//		layUIPojo.setCode(0);
//		layUIPojo.setCount(articleTypeList.size());
//		layUIPojo.setMsg("");
//		layUIPojo.setData(articleTypeList);
//		return layUIPojo;
//	}
	
	/**
	 * 添加文章分类
	 * @param 
	 */
	@RequestMapping("/articletype/add")
	public String addArticleType(BlogArticleType blogArticleType) {
		articleService.addArticleType(blogArticleType);
		return "redirect:list";
	}
	
	/**
	 * 跳转到添加文章分类的页面
	 * @return
	 */
	@RequestMapping("/articletype/addui")
	public String addArticleTypeUI() {
		return "articletype/addui";
	}
	
	@RequestMapping(value= {"/article","/articlebytype","/articletype","/articletype/updateui","/article/updateui","/article/search","/article/delete","/article/index","/articlecomment","/article/user"})
	public String toMain() {
		return "redirect:/main";
	}
}
