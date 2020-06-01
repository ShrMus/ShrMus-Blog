package cn.shrmus.blog.service;

import cn.shrmus.blog.pojo.BlogLeaveMessage;

import java.util.List;

public interface MessageService {

	List<BlogLeaveMessage> getMessageListByUserId(Integer userId);

	void addMessage(BlogLeaveMessage blogLeaveMessage);

	void deleteMessageById(Integer messageId);

}
