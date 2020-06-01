package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogLeaveMessage;
import cn.shrmus.blog.pojo.BlogLeaveMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogLeaveMessageMapper {
    long countByExample(BlogLeaveMessageExample example);

    int deleteByExample(BlogLeaveMessageExample example);

    int deleteByPrimaryKey(Integer messageId);

    int insert(BlogLeaveMessage record);

    int insertSelective(BlogLeaveMessage record);

    List<BlogLeaveMessage> selectByExampleWithBLOBs(BlogLeaveMessageExample example);

    List<BlogLeaveMessage> selectByExample(BlogLeaveMessageExample example);

    BlogLeaveMessage selectByPrimaryKey(Integer messageId);

    int updateByExampleSelective(@Param("record") BlogLeaveMessage record, @Param("example") BlogLeaveMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogLeaveMessage record, @Param("example") BlogLeaveMessageExample example);

    int updateByExample(@Param("record") BlogLeaveMessage record, @Param("example") BlogLeaveMessageExample example);

    int updateByPrimaryKeySelective(BlogLeaveMessage record);

    int updateByPrimaryKeyWithBLOBs(BlogLeaveMessage record);

    int updateByPrimaryKey(BlogLeaveMessage record);
}