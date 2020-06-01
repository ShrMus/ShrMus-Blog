package cn.shrmus.blog.mapper;

import cn.shrmus.blog.pojo.BlogAlbum;
import cn.shrmus.blog.pojo.BlogAlbumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogAlbumMapper {
    long countByExample(BlogAlbumExample example);

    int deleteByExample(BlogAlbumExample example);

    int deleteByPrimaryKey(Integer albumId);

    int insert(BlogAlbum record);

    int insertSelective(BlogAlbum record);

    List<BlogAlbum> selectByExample(BlogAlbumExample example);

    BlogAlbum selectByPrimaryKey(Integer albumId);

    int updateByExampleSelective(@Param("record") BlogAlbum record, @Param("example") BlogAlbumExample example);

    int updateByExample(@Param("record") BlogAlbum record, @Param("example") BlogAlbumExample example);

    int updateByPrimaryKeySelective(BlogAlbum record);

    int updateByPrimaryKey(BlogAlbum record);
}