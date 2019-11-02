package top.afsun1996.nexos.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.afsun1996.nexos.mapper.ArticleMapper;
import top.afsun1996.nexos.po.Article;

import java.util.List;
import java.util.Map;

/**
 * @program: NexosBlog
 * @description: 文章服务
 * @author: afsun
 * @create: 2019-10-30 11:47
 */
//@Service
@Component
public class ArticleService {

    @Autowired
    ArticleMapper mapper;

    /**
     *  获取文章
     * @param
     * @return
     */
    public List<Article> selectArticleList(){
        return mapper.selectArticleList();
    }
    
    /**
    *@Description: 插入文章
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    public int saveArticle(Article dto){
        return mapper.insertSelective(dto);
    }
    
    /**
    *@Description: 根据id查找对应的文章
    *@Param:
    *@return:
    *@Author: afsun
    *@date: 2019/10/30
    */
    public Article selectArticleById(int id){
        return mapper.selectByPrimaryKey(id);
    }

    /**
    *@Description: 根据条件获取符合的条件数
    *@Param:
    *@return:
    *@Author: afsun
    *@date: 2019/10/30
    */
    public int countByCondition(Map<String,Object> condition){
        return this.mapper.countByCondition(condition);
    }
    
    /**
    *@Description: 根据条件查询列表
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    public List<Article> selectListByCondition(Map<String,Object> condition){
        int startIndex = (int) condition.get("startIndex");
        int pageSize = (int) condition.get("pageSize");
        return this.mapper.selectListByCondition(condition,new RowBounds(startIndex,pageSize));
    }

    /**
    *@Description: 更新文章
    *@Param:
    *@return:
    *@Author: afsun
    *@date: 2019/10/30
    */
    public int updateArticle(Article article){
        return this.mapper.updateByPrimaryKeySelective(article);
    }

    public Article getArticleDetail(int articleId){

        return this.mapper.getArticleDetail(articleId);
    }

    public int addlikesById(int id){
        return this.addlikesById(id);
    }

}