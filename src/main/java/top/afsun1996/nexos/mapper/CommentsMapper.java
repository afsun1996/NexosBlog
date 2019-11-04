package top.afsun1996.nexos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;import top.afsun1996.nexos.po.Comments;import java.util.List;

@Mapper
public interface CommentsMapper {
    int insertSelective(Comments record);

    @Select("select * from nexos_blog.comments where articleid=#{id} ")
    List<Comments> selectByarticleid(int id);

    @Select("select * from nexos_blog.comments order by createTime desc limit 6")
    List<Comments> selectNew();
}