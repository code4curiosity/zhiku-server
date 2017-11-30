package com.ccbjb.service.tips.impl;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.domain.TTipsFunc;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.TTipsDao;
import com.ccbjb.dao.TTipsFuncDao;
import com.ccbjb.service.tips.ITipsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TipsServiceImpl implements ITipsService {

    @Autowired
    TTipsDao tTipsDao;
    @Autowired
    TTipsFuncDao tTipsFuncDao;

    @Transactional
    @Override
    public Result addTip(TTips tTips) {
        if (tTips.getTipsNo() == 0) {
            return ResultGenerator.genFailResult(ResultCode.ERR_112);
        }
        List<TTips> tipsList = tTipsDao.selectTipsByTipsNo(tTips.getTipsNo(), "");
        if (tipsList == null || tipsList.size() == 0) {
            tTips.setCreateTime(new Date());
            TTips newTips = new TTips();
            BeanUtils.copyProperties(tTips, newTips);
            tTipsDao.save(newTips);
            saveFunc(newTips);
        }else {
            if(tipsList.size() > 1) {
                return ResultGenerator.genFailResult(ResultCode.ERR_111);
            }
            if(tipsList.size() > 0) {
                TTips newTips = new TTips();
                BeanUtils.copyProperties(tTips, newTips);
                newTips.setId(tipsList.get(0).getId());
                newTips.setUpdateTime(new Date());
                tTipsDao.update(newTips);
                saveFunc(newTips);
            }

        }

        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result findTips(int tipsNo) {
        List<TTips> tipsList = tTipsDao.selectTipsByTipsNo(tipsNo, "");
        if(tipsList.size() == 1) {
            TTips tips = tipsList.get(0);
            TTips newTips = new TTips();
            BeanUtils.copyProperties(tips, newTips);
            newTips.setExplainTableObj(tips.getExplainTable());
            newTips.setTipsCodeObj(tips.getTipsCode());
            newTips.setNoticeCodeObj(tips.getNoticeCode());
            return ResultGenerator.genSuccessResult(newTips);
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    @Override
    public Result findCatalogue() {
        return ResultGenerator.genSuccessResult(tTipsDao.findAll());
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Result findPage(Map<String,String> map, Integer pageNo,
                           Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<TTips> list = tTipsDao.selectTipsByTipsNo(0, map.get("findContent"));
        PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    private void saveFunc(TTips tTips) {
        if(tTips.getTipsFuncList() != null && tTips.getTipsFuncList().size() > 0) {
            for (TTipsFunc func : tTips.getTipsFuncList()) {
                if (StringUtils.isBlank(func.getId())) {
                    func.setCreateTime(new Date());
                    func.setTipsId(tTips.getId());
                    tTipsFuncDao.save(func);
                } else {
                    func.setUpdateTime(new Date());
                    func.setTipsId(tTips.getId());
                    tTipsFuncDao.update(func);
                }
            }
        }
    }
}
