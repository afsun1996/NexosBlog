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


    


    

}