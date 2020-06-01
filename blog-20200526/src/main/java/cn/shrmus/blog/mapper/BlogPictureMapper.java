package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogPicture;
import cn.shrmus.blog.pojo.BlogPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogPictureMapper {
    long countByExample(BlogPictureExample example);

    int deleteByExample(BlogPictureExample example);

    int deleteByPrimaryKey(Integer pictureId);

    int insert(BlogPicture record);

    int insertSelective(BlogPicture record);

    List<BlogPicture> selectByExample(BlogPictureExample example);

    BlogPicture selectByPrimaryKey(Integer pictureId);

    int updateByExampleSelective(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByExample(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByPrimaryKeySelective(BlogPicture record);

    int updateByPrimaryKey(BlogPicture record);
}