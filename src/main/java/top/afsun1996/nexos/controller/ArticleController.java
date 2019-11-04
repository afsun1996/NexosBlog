package top.afsun1996.nexos.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.afsun1996.nexos.domain.ResultInfo;
import top.afsun1996.nexos.po.Comments;
import top.afsun1996.nexos.service.ArticleService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import top.afsun1996.nexos.po.Article;
import top.afsun1996.nexos.service.CommentSerrvice;
import top.afsun1996.nexos.service.TagsService;

import java.util.*;

/**
 * @program: NexosBlog
 * @description: 后台管理
 * @author: afsun
 * @create: 2019-10-30 11:42
 */
@RequestMapping(value = "/article",method= RequestMethod.POST)
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentSerrvice commentSerrvice;

    @Autowired
    TagsService tagsService;
    /**
    *@Description: 保存文章
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @Transactional
    @RequestMapping("/save")
    public ResultInfo SaveArticle(@RequestBody Article article){
        ResultInfo resultInfo = ResultInfo.newInstance();

        int i = articleService.saveArticle(article);
        // 插入失败
        if (i == 0){
            resultInfo.setSuccess(false);
            resultInfo.setResultDesc("文章保存失败");
            return resultInfo;
        }
        // 保存成功
        resultInfo.setSuccess(true);
        resultInfo.setResultDesc("文章保存成功");
        return resultInfo;
    }
    
    /**
    *@Description: 点赞功能
    *@Param:
    *@return:
    *@Author: afsun
    *@date: 2019/10/30
    */
    public ResultInfo addlikes(@RequestBody int id){
        ResultInfo resultInfo = ResultInfo.newInstance();
        this.articleService.addlikesById(id);
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    /**
     *@Description: 显示指定文章
     *@Param:
     *@return:
     *@Author: afsun
     *@date: 2019/10/30
     */
    @RequestMapping("/show/{id}")
    public ResultInfo getShowAritcle(@PathVariable("id")int id){
        ResultInfo resultInfo = ResultInfo.newInstance();
        Article article = articleService.selectArticleById(id);
        resultInfo.setResult(article);
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    /**
    *@Description: 更新
    *@Param:
    *@return:
    *@Author: afsun
    *@date: 2019/10/30
    */
    @RequestMapping("/update")
    public ResultInfo updateArticle(@RequestBody Article article){
        ResultInfo resultInfo = ResultInfo.newInstance();
        this.articleService.updateArticle(article);
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    @RequestMapping("/test")
    public ResultInfo getDefaultView(@RequestBody Map<String,String> input){
        ResultInfo resultInfo = ResultInfo.newInstance();
        System.out.println(input);

        return resultInfo;
    }

    /**
     *@Description: 获取文章列表
     *@Param:
     *@return:
     *@Author: afsun
     *@date: 2019/9/9
     */
    @RequestMapping("/showList")
    public ResultInfo getArticleList(@RequestBody JSONObject input){
        ResultInfo resultInfo = ResultInfo.newInstance();
        Map resultMap = new HashMap();
        // 查询页
        Integer current = input.getInteger("pageNum");
        // 查询页大小
        Integer pageSize = input.getInteger("pageSize");
        String title = input.getString("title");
        // 有查询名称的参数
        if (!StringUtils.isEmpty(title)){
            // 模糊搜索
            input.put("title","%"+title+"%");
        }
        // 请求参数做成搜索参数
        Map condition = input.toJavaObject(Map.class);
        // 所有的项大小
        int count = this.articleService.countByCondition(condition);
        // 计算开始页
        int startIndex =(current-1)*pageSize;
        condition.put("startIndex",startIndex);
        // 计算总页数
        int totalPages = count%pageSize ==0?count/pageSize:count/pageSize+1;
        resultMap.put("totalPages",totalPages);
        resultMap.put("totalCounts",count);
        resultMap.put("lists",this.articleService.selectListByCondition(condition));
        resultInfo.setResult(resultMap);
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    /**
    *@Description: 网站主页
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/11/4
    */
    @RequestMapping("/mainInfo")
    public ResultInfo getMainInfo(@RequestBody JSONObject input){
        ResultInfo resultInfo = ResultInfo.newInstance();
        Map resultMap = new HashMap();
        resultInfo.setResult(resultMap);
        // 获取最新的6个评论
        List<Comments> comments = this.commentSerrvice.selectNew();

        Set<Article> sets = new HashSet<>();
        List<Article> hotarticles = this.articleService.selectMaxLikesArtcle();
        for (Article dto:hotarticles){
            dto.setType("1");
        }
        List<Article> newarticles = this.articleService.selectNews();
        for (Article dto:newarticles){
            dto.setType("2");
        }

        sets.addAll(hotarticles);
        sets.addAll(newarticles);
        resultMap.put("articles",sets);
        resultMap.put("comments",comments);
        resultMap.put("count",this.articleService.count());
        resultMap.put("clicksort",this.articleService.selectOrderViews());
        resultInfo.setSuccess(true);
        return resultInfo;
    }
    
    /**
    *@Description: 获取具体的文章信息
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/10/31
    */
    @RequestMapping("/getArticleDetail")
    public ResultInfo getArticleDetail(@RequestBody JSONObject input){
        ResultInfo resultInfo = ResultInfo.newInstance();
        resultInfo.setSuccess(true);
        Integer id = input.getInteger("id");
        List<Comments> comments = this.commentSerrvice.selectByarticleid(id);
        Article article = this.articleService.selectArticleById(id);
        article.setComments(comments);
        resultInfo.setResult(article);
        return resultInfo;
    }

    /**
     *@Description: 获取标签信息
     *@Param:
     *@return:
     *@Author: afsun
     *@date: 2019/10/31
     */
    @RequestMapping("/getTagList")
    public ResultInfo getTagList(@RequestBody JSONObject input){
        ResultInfo resultInfo = ResultInfo.newInstance();
        resultInfo.setSuccess(true);
        resultInfo.setResult(tagsService.selectAllTags());
        return resultInfo;
    }





}