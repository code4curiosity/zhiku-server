package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;
import java.util.Map;

public interface TZhikuCategoryMapper extends TKMMapper<TZhikuCategory> {
    List<TZhikuCategory> findAllCategories(Map<String, String> map);
    List<TZhikuCategory> findCategoryParents();
    List<TZhikuCategory> findCategoryItems(Long parentId);
}