package com.ccbjb.controller.zhiku;

import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.tips.ITipsService;
import com.ccbjb.service.zhiku.ICategoryService;
import com.ccbjb.service.zhiku.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    IInfoService infoService;
    @Autowired
    ICategoryService categoryService;
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

    @RequestMapping(value="industry")
    public ModelAndView industry(HttpServletRequest request, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo){
        // 行业知识
        ModelAndView model = new ModelAndView("industry");
        model.addObject("page", categoryService.findCategoryItemsPage(1L,pageNo,9));
        model.addObject("navIndex", 1);
        return model;
    }

    @RequestMapping(value="professional")
    public ModelAndView professional(HttpServletRequest request, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo){
        // 专业技术
        ModelAndView model = new ModelAndView("professional");
        model.addObject("page", categoryService.findCategoryItemsPage(2L,pageNo,9));
        model.addObject("navIndex", 2);
        return model;
    }

    @RequestMapping(value="ebook")
    public ModelAndView ebook(HttpServletRequest request,@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo){
        ModelAndView model = new ModelAndView("ebook");
        model.addObject("page", categoryService.findCategoryItemsPage(4L,pageNo,9));
        model.addObject("navIndex", 3);
        return model;
    }

    @RequestMapping(value="training")
    public ModelAndView training(HttpServletRequest request,@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo){
        // 培训机构
        ModelAndView model = new ModelAndView("training");
        model.addObject("page", categoryService.findCategoryItemsPage(3L,pageNo,9));
        model.addObject("navIndex", 4);
        return model;
    }


    @RequestMapping(value="chair")
    public ModelAndView chair(HttpServletRequest request,@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo){
        // 线下讲座
        ModelAndView model = new ModelAndView("chair");
        model.addObject("page", categoryService.findCategoryItemsPage(5L,pageNo,9));
        model.addObject("navIndex", 5);
        return model;
    }


    @RequestMapping(value="login")
    public String login(HttpServletRequest request){
        return "login";
    }
    @RequestMapping(value="register")
    public String register(HttpServletRequest request){
        return "register";
    }

    @RequestMapping(value="info")
    public ModelAndView info(String categoryId, Integer navIndex){
        ModelAndView model = new ModelAndView("info");
        model.addObject("infoList",infoService.findAllNoPage(categoryId));
        model.addObject("navIndex", navIndex);
        return model;
    }

}
