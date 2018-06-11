package com.ccbjb.dao;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.domain.TZhikuInfo;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface TZhikuInfoDao extends BaseDao<TZhikuInfo> {

    List<TZhikuInfo> selectAllInfo(String categoryId, String findContent);
    List<TZhikuInfo> findInfoParents(String categoryId);
    List<TZhikuInfo> findInfoItems(Long parentId);
}
