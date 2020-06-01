package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogArticle;
import cn.shrmus.blog.pojo.BlogArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogArticleMapper {
    long countByExample(BlogArticleExample example);

    int deleteByExample(BlogArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(BlogArticle record);

    int insertSelective(BlogArticle record);

    List<BlogArticle> selectByExampleWithBLOBs(BlogArticleExample example);

    List<BlogArticle> selectByExample(BlogArticleExample example);

    BlogArticle selectByPrimaryKey(Integer articleId);
    
    BlogArticle selectById(Integer articleId);

    int updateByExampleSelective(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByExample(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByPrimaryKeySelective(BlogArticle record);

    int updateByPrimaryKeyWithBLOBs(BlogArticle record);

    int updateByPrimaryKey(BlogArticle record);
}