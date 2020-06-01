package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogQuestion;

import java.util.List;

public interface QuestionService {
	public List<BlogQuestion> getQuestionList();

	public void addQuestion(BlogQuestion blogQuestion);

	public BlogQuestion getQuestionById(Integer questionId);
	
	public void accpetQuestion(Integer questionId, Integer answerId, Integer userIdReply);

	public void indexImport();

	public List<BlogQuestion> indexSearch(String queryString);
}
