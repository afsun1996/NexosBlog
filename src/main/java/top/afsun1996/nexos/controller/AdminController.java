package top.afsun1996.nexos.controller;    /**
 * Created by 孙爱飞 on 2019/9/8.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD2;

/**
 *@description: //用户管理
 *@author: your name
 *@create: 2019-09-08 16:24
 *@version: 1.0
 */
@RequestMapping("user")
@RestController
public class AdminController {

    /**
    *@Description: 用户登录
    *@Param: 
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @RequestMapping("login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login");
    }
    
    /**
    *@Description: 
    *@Param: 
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @RequestMapping("admin")
    public ModelAndView getLoginPage2(){
        ModelAndView modelAndView = new ModelAndView("admin-index");
        modelAndView.addObject("frameshow","/templates/admin/index.html");
        return modelAndView;
    }
    
    /**
    *@Description: 编辑
    *@Param: 
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @RequestMapping("editor")
    public ModelAndView getEditor(){
        return new ModelAndView("admin-editor");
    }

    /**
    *@Description: 
    *@Param: 
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @RequestMapping("article")
    public ModelAndView getArticle(){
        return new ModelAndView("articleshow");
    }
    
    /**
    *@Description:
    *@Param: 
    *@return: 
    *@Author: afsun
    *@date: 2019/10/30
    */
    @RequestMapping("ossConfig")
    public ModelAndView getOssConfig(){
        ModelAndView modelAndView = new ModelAndView("admin-index");
        modelAndView.addObject("frameshow","/templates/admin/oss.html");
        return modelAndView;
    }
}
