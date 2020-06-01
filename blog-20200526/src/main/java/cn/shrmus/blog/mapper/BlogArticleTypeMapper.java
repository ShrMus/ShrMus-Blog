package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogArticleType;
import cn.shrmus.blog.pojo.BlogArticleTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogArticleTypeMapper {
    long countByExample(BlogArticleTypeExample example);

    int deleteByExample(BlogArticleTypeExample example);

    int deleteByPrimaryKey(Integer articleTypeId);

    int insert(BlogArticleType record);

    int insertSelective(BlogArticleType record);

    List<BlogArticleType> selectByExample(BlogArticleTypeExample example);

    BlogArticleType selectByPrimaryKey(Integer articleTypeId);

    int updateByExampleSelective(@Param("record") BlogArticleType record, @Param("example") BlogArticleTypeExample example);

    int updateByExample(@Param("record") BlogArticleType record, @Param("example") BlogArticleTypeExample example);

    int updateByPrimaryKeySelective(BlogArticleType record);

    int updateByPrimaryKey(BlogArticleType record);
}