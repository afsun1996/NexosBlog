package top.afsun1996.nexos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.afsun1996.nexos.mapper.ArticleMapper;
import top.afsun1996.nexos.po.Article;

import java.util.List;
import java.util.Map;

/**
 * @program: NexosBlog
 * @description: 默认页面
 * @author: afsun
 * @create: 2019-09-09 14:06
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    ArticleMapper articleMapper;

    private static final int pageSize = 2;
    
    /**
    *@Description: 默认首页
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/9/9
    */
    @RequestMapping("/")
    public ModelAndView getDefaultView(){
        PageHelper.startPage(0, pageSize);
        List<Article> articles = articleMapper.selectPagination();
        PageInfo<Article> pageInfo = new PageInfo(articles);
        ModelAndView mv = new ModelAndView("blog");
        mv.addObject("pageinfo",pageInfo);
        return mv;
    }

    @RequestMapping("/showArticle/{id}")
    public ModelAndView getShowAritcle(@PathVariable("id")int id){
        Article article = articleMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView("articleshow");
        mv.addObject("article",article);
        return mv;
    }
    

}