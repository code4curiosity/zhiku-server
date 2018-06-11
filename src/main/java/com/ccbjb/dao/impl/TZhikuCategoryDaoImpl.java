package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.mapper.TZhikuCategoryMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.TZhikuCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class TZhikuCategoryDaoImpl extends AbstractDao<TZhikuCategory> implements TZhikuCategoryDao {
    @Autowired
    private TZhikuCategoryMapper tZhikuCategoryMapper;


    @Override
    public List<TZhikuCategory> findAllCategories(Map<String, String> map) {
        return tZhikuCategoryMapper.findAllCategories(map);
    }

    @Override
    public List<TZhikuCategory> findCategoryParents() {
        return tZhikuCategoryMapper.findCategoryParents();
    }

    @Override
    public List<TZhikuCategory> findCategoryItems(Long parentId) {
        return tZhikuCategoryMapper.findCategoryItems(parentId);
    }
}
