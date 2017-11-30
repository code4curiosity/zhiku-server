package com.ccbjb.controller.zhiku;

import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.tips.ITipsService;
import com.ccbjb.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆和退出
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
@Controller
@Scope(value="prototype")
@RequestMapping("zhiku")
public class ZhikuController extends BaseController{
    @Autowired
    ITipsService iTipsService;
    /**
     * 登录跳转
     * @return
     */
    @RequestMapping(value="first")
    public String first(HttpServletRequest request){
        return "index";
    }

    @RequestMapping(value="contact")
    public String contact(HttpServletRequest request){
        return "contact";
    }

    @RequestMapping(value="ebook")
    public String ebook(HttpServletRequest request){
        return "ebook";
    }

    @RequestMapping(value="industry")
    public String industry(HttpServletRequest request){
        return "industry";
    }

    @RequestMapping(value="professional")
    public String professional(HttpServletRequest request){
        return "professional";
    }

    @RequestMapping(value="training")
    public String training(HttpServletRequest request){
        return "training";
    }

    @RequestMapping(value="login")
    public String login(HttpServletRequest request){
        return "login";
    }
    @RequestMapping(value="register")
    public String register(HttpServletRequest request){
        return "register";
    }

}
