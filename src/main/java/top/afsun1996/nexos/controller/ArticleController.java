package top.afsun1996.nexos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import top.afsun1996.nexos.domain.ResultInfo;
import top.afsun1996.nexos.service.ArticleService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.afsun1996.nexos.po.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: NexosBlog
 * @description: 后台管理
 * @author: afsun
 * @create: 2019-10-30 11:42
 */
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
    *@Description: 保存文章
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @Transactional
    @RequestMapping("/save}")
    public ResultInfo SaveArticle(Article article){
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
    public ResultInfo updateArticle(Article article){
        ResultInfo resultInfo = ResultInfo.newInstance();
        this.articleService.updateArticle(article);
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    /**
     *@Description: 默认首页
     *@Param:
     *@return:
     *@Author: afsun
     *@date: 2019/9/9
     */
    @RequestMapping("/showList")
    public ResultInfo getDefaultView(JSONObject input){
        ResultInfo resultInfo = ResultInfo.newInstance();
        Map resultMap = new HashMap();
        // 查询页
        Integer current = input.getInteger("current");
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




}