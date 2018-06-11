package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.TZhikuInfo;
import com.ccbjb.common.mapper.TZhikuInfoMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.TZhikuInfoDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class TZhikuInfoDaoImpl extends AbstractDao<TZhikuInfo> implements TZhikuInfoDao {

    @Resource
    TZhikuInfoMapper tZhikuInfoMapper;


    @Override
    public List<TZhikuInfo> selectAllInfo(String categoryId, String findContent) {
        return tZhikuInfoMapper.selectInfoByInfoNo(categoryId, findContent);
    }

    @Override
    public List<TZhikuInfo> findInfoParents(String categoryId) {
        return tZhikuInfoMapper.findInfoParents(categoryId);
    }

    @Override
    public List<TZhikuInfo> findInfoItems(Long parentId) {
        return tZhikuInfoMapper.findInfoItems(parentId);
    }
}
