package com.ccbjb.dao;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface TZhikuCategoryDao extends BaseDao<TZhikuCategory> {
    List<TZhikuCategory> findAllCategories(Map<String, String> map);
    List<TZhikuCategory> findCategoryParents();
    List<TZhikuCategory> findCategoryItems(Long parentId);
}
