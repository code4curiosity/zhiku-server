package com.ccbjb.controller.mobile;

import com.ccbjb.common.domain.ShopOwner;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.mobile.MobileLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆和退出
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
@RestController
@Scope(value="prototype")
@RequestMapping("api")
public class MobileLoginController extends BaseController {

    @Autowired
    MobileLoginService mobileLoginService;

    @PostMapping(value="mobileLogin")
    public Result empLogin(ShopOwner shopOwner, HttpServletRequest request)throws Exception{
        ShopOwner user = mobileLoginService.login(shopOwner);
        Result result = null;
        if(user!=null){
            Map m = new HashMap<String,String>();
            m.put("resultMsg","登陆成功");
            m.put("tokenId",user.getTokenId());
            result = ResultGenerator.genSuccessResult(m);
        }else{
            result = ResultGenerator.genFailResult(ResultCode.ERR_105);
        }
        return result;
    }
}
