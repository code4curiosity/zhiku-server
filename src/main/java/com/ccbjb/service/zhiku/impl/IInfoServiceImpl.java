package com.ccbjb.service.zhiku.impl;

import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.domain.TZhikuInfo;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.TZhikuInfoDao;
import com.ccbjb.service.zhiku.IInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class IInfoServiceImpl implements IInfoService{
    @Autowired
    TZhikuInfoDao tZhikuInfoDao;

    @Transactional
    @Override
    public Result findPage(String categoryId, Map<String, String> resultMap, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<TZhikuInfo> list = tZhikuInfoDao.selectAllInfo(categoryId, resultMap.get("findContent"));
        PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @Transactional
    @Override
    public List<TZhikuInfo> findAllNoPage(String categoryId) {
        return tZhikuInfoDao.selectAllInfo(categoryId, "");
    }

    @Transactional
    @Override
    public Result selectInfoById(String infoId) {
        TZhikuInfo tZhikuInfo = tZhikuInfoDao.findById(Long.parseLong(infoId));
        tZhikuInfo.setInfoParents(tZhikuInfoDao.findInfoParents(String.valueOf(tZhikuInfo.getCategoryId())));
        return ResultGenerator.genSuccessResult(tZhikuInfo);
    }

    @Transactional
    @Override
    public void insertSelective(TZhikuInfo info) {
        if(StringUtils.isBlank(info.getId())){

            info.setCreateTime(new Date());
            info.setUpdateTime(new Date());
            tZhikuInfoDao.save(info);
        }else{
            info.setUpdateTime(new Date());
            tZhikuInfoDao.update(info);
            List<TZhikuInfo> infoItems = tZhikuInfoDao.findInfoItems(info.getId());
            for (TZhikuInfo item: infoItems) {
                item.setUpdateTime(new Date());
                item.setCategoryId(info.getCategoryId());
                tZhikuInfoDao.update(item);
            }
        }
    }

    @Override
    public Result selectInfoParents(String categoryId) {
        return ResultGenerator.genSuccessResult(tZhikuInfoDao.findInfoParents(categoryId));
    }

    @Transactional
    @Override
    public Result deleteInfoById(String categoryId, Long[] ids) {
        Result result = null;
        try {
            int count=0;
            String resultMsg = "";

            for (Long id : ids) {
                List<TZhikuInfo> dicItems = tZhikuInfoDao.findInfoItems(id);
                if(CollectionUtils.isEmpty(dicItems)){
                    this.deleteByPrimaryKey(id);
                    count++;
                }else {
                    return ResultGenerator.genFailResult(ResultCode.ERR_113);
                }
            }
            resultMsg = "成功删除"+count+"个消息！";
            result = ResultGenerator.genSuccessResult(resultMsg);
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "根据IDS删除消息出现错误，ids[%s]", ids);
            result = ResultGenerator.genFailResult();
        }
        return result;
    }

    @Transactional
    public void deleteByPrimaryKey(Long id) {
        tZhikuInfoDao.deleteById(id);
    }
}
