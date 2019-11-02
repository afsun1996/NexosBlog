package top.afsun1996.nexos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import top.afsun1996.nexos.po.Article;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {

    /**
     *  获取文章
     * @param
     * @return
     */
    List<Article> selectArticleList();

    /**
    *@Description: 插入文章
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    int insertSelective(Article record);

    /**
    *@Description: 根据id查找对应的文章
    *@Param:
    *@return:
    *@Author: afsun
    *@date: 2019/10/30
    */
    Article selectByPrimaryKey(Integer id);

    int countByCondition(Map<String,Object> condition);

    List<Article> selectListByCondition(Map<String,Object> condition);

    List<Article> selectListByCondition(Map<String,Object> condition, RowBounds rowBounds);

    int updateByPrimaryKeySelective(Article record);

    @Update("update nexos_blog.article set likes = likes+1 where articleId=#{id} ")
    int addlikesById(int id);

    @Select("select * from nexos_blog.article where id = #{id} ")
    Article getArticleDetail(int id);

}