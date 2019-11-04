package top.afsun1996.nexos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.afsun1996.nexos.po.Tags;

import java.util.List;

@Mapper
public interface TagsMapper {

    int insertSelective(Tags record);

    List<Tags> selectAllTags();
}