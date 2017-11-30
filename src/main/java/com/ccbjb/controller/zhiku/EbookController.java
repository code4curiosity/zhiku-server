package com.ccbjb.controller.zhiku;

import com.ccbjb.common.mybatis.Result;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.tips.ITipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆和退出
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
@Controller
@Scope(value="prototype")
@RequestMapping("ebook")
public class EbookController extends BaseController{
    @Autowired
    ITipsService iTipsService;

    @RequestMapping(value="vbabook")
    public ModelAndView vbabook(HttpServletRequest request, int tipsNo){
        return new ModelAndView("vbabook", "result", iTipsService.findTips(tipsNo));
    }

    @RequestMapping(value="catalogue")
    public ModelAndView catalogue() {
        return new ModelAndView("catalogue", "result", iTipsService.findCatalogue());
    }

    @RequestMapping(value="list")
    @ResponseBody
    public Result list(String findContent, Integer pageNo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("findContent", findContent);
        return iTipsService.findPage(map,pageNo,pageSize);
    }

    @RequestMapping(value="selectTipById")
    @ResponseBody
    public Result selectTipById(int tipsNo) {
        return iTipsService.findTips(tipsNo);
    }

}
