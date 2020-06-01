package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogArticleComment;
import cn.shrmus.blog.pojo.BlogArticleCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogArticleCommentMapper {
    long countByExample(BlogArticleCommentExample example);

    int deleteByExample(BlogArticleCommentExample example);

    int deleteByPrimaryKey(Integer articleCommentId);

    int insert(BlogArticleComment record);

    int insertSelective(BlogArticleComment record);

    List<BlogArticleComment> selectByExampleWithBLOBs(BlogArticleCommentExample example);

    List<BlogArticleComment> selectByExample(BlogArticleCommentExample example);

    BlogArticleComment selectByPrimaryKey(Integer articleCommentId);

    int updateByExampleSelective(@Param("record") BlogArticleComment record, @Param("example") BlogArticleCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogArticleComment record, @Param("example") BlogArticleCommentExample example);

    int updateByExample(@Param("record") BlogArticleComment record, @Param("example") BlogArticleCommentExample example);

    int updateByPrimaryKeySelective(BlogArticleComment record);

    int updateByPrimaryKeyWithBLOBs(BlogArticleComment record);

    int updateByPrimaryKey(BlogArticleComment record);
}