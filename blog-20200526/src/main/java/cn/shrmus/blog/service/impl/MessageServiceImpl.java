package cn.shrmus.blog.service.impl;

import cn.shrmus.blog.mapper.BlogLeaveMessageMapper;
import cn.shrmus.blog.pojo.BlogLeaveMessage;
import cn.shrmus.blog.pojo.BlogLeaveMessageExample;
import cn.shrmus.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private BlogLeaveMessageMapper blogLeaveMessageMapper;
	
	/**
	 * 查询用户的留言板
	 */
	@Override
	public List<BlogLeaveMessage> getMessageListByUserId(Integer userId) {
		BlogLeaveMessageExample blogLeaveMessageExample = new BlogLeaveMessageExample();
		blogLeaveMessageExample.setOrderByClause("message_id desc");
		BlogLeaveMessageExample.Criteria criteria = blogLeaveMessageExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andMessagePidEqualTo(0);
		List<BlogLeaveMessage> messageList = blogLeaveMessageMapper.selectByExampleWithBLOBs(blogLeaveMessageExample);
		return messageList;
	}
	
	/**
	 * 添加留言
	 */
	@Transactional
	public void addMessage(BlogLeaveMessage blogLeaveMessage) {
		blogLeaveMessage.setMessagePublishTime(new Date());
		blogLeaveMessageMapper.insert(blogLeaveMessage);
	}

	/**
	 * 删除留言
	 */
	@Transactional
	public void deleteMessageById(Integer messageId) {
		BlogLeaveMessage blogLeaveMessage = blogLeaveMessageMapper.selectByPrimaryKey(messageId);
		List<BlogLeaveMessage> messagesList = blogLeaveMessage.getMessagesList();
		for(BlogLeaveMessage leaveMessage : messagesList) {
			blogLeaveMessageMapper.deleteByPrimaryKey(leaveMessage.getMessageId());
		}
		blogLeaveMessageMapper.deleteByPrimaryKey(messageId);
	}
}
