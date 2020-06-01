package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogQuestion;
import cn.shrmus.blog.pojo.BlogQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogQuestionMapper {
    long countByExample(BlogQuestionExample example);

    int deleteByExample(BlogQuestionExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(BlogQuestion record);

    int insertSelective(BlogQuestion record);

    List<BlogQuestion> selectByExampleWithBLOBs(BlogQuestionExample example);

    List<BlogQuestion> selectByExample(BlogQuestionExample example);

    BlogQuestion selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") BlogQuestion record, @Param("example") BlogQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogQuestion record, @Param("example") BlogQuestionExample example);

    int updateByExample(@Param("record") BlogQuestion record, @Param("example") BlogQuestionExample example);

    int updateByPrimaryKeySelective(BlogQuestion record);

    int updateByPrimaryKeyWithBLOBs(BlogQuestion record);

    int updateByPrimaryKey(BlogQuestion record);
}