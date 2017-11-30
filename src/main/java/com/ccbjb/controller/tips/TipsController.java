package com.ccbjb.controller.tips;

import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.tips.ITipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tips")
public class TipsController extends BaseController {

    @Autowired
    ITipsService iTipsService;

    @PostMapping("addTip")
    public Result addTip(@RequestBody TTips tTips) {
        return iTipsService.addTip(tTips);
    }
}
