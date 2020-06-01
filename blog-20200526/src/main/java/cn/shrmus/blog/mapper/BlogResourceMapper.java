package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogResource;
import cn.shrmus.blog.pojo.BlogResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogResourceMapper {
    long countByExample(BlogResourceExample example);

    int deleteByExample(BlogResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(BlogResource record);

    int insertSelective(BlogResource record);

    List<BlogResource> selectByExample(BlogResourceExample example);

    BlogResource selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") BlogResource record, @Param("example") BlogResourceExample example);

    int updateByExample(@Param("record") BlogResource record, @Param("example") BlogResourceExample example);

    int updateByPrimaryKeySelective(BlogResource record);

    int updateByPrimaryKey(BlogResource record);
}