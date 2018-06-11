package com.ccbjb.controller.zhiku;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.domain.TZhikuInfo;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.zhiku.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Scope(value="prototype")
@RequestMapping("info")
public class InfoController extends BaseController{
    @Autowired
    IInfoService infoService;

    @RequestMapping(value="list")
    public Result list(String categoryId, String findContent, Integer pageNo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("findContent", findContent);
        return infoService.findPage(categoryId, map,pageNo,pageSize);
    }

    @RequestMapping(value="selectInfoById")
    public Result selectInfoById(String infoId) {
        return infoService.selectInfoById(infoId);
    }

    /**
     * 字典添加
     * @param info
     * @return
     */
    @PostMapping(value="save")
    public Result save(TZhikuInfo info){
        Result result = null;
        try {
            infoService.insertSelective(info);
            result = ResultGenerator.genSuccessResult("添加成功");
        } catch (Exception e) {
            result = ResultGenerator.genFailResult();
            LoggerUtils.fmtError(getClass(), e, "添加消息报错。source[%s]",info.toString());
        }
        return result;
    }

    @PostMapping(value="deleteInfoById")
    public Result deleteDicById(String categoryId, Long[] ids){
        return infoService.deleteInfoById(categoryId, ids);
    }

    @GetMapping(value="selectInfoParents")
    public Result selectDicParents(String categoryId){
        return infoService.selectInfoParents(categoryId);
    }
}
