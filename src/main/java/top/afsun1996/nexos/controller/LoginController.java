package top.afsun1996.nexos.controller;    /**
 * Created by 孙爱飞 on 2019/9/8.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *@description: //登录
 *@author: your name
 *@create: 2019-09-08 16:24
 *@version: 1.0
 */
@RequestMapping("user")
@RestController
public class LoginController {

    @RequestMapping("login")
    public ModelAndView getLoginPage(){
        System.out.println("hello");
        return new ModelAndView("login");
    }
}
