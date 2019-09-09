package top.afsun1996.nexos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.afsun1996.nexos.po.Article;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {

    /**
     *  分页获取文章
     * @param
     * @return
     */
    List<Article> selectPagination();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}