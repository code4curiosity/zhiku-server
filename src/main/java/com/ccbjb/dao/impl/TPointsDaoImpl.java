package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mapper.TPointsMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.TPointsDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class TPointsDaoImpl extends AbstractDao<TPoints> implements TPointsDao {
    @Resource
    TPointsMapper tPointsMapper;

    @Override
    public List<TPoints> findAllPoints(Map<String, String> map){
        return tPointsMapper.findAllPoints(map);
    }

    @Override
    public TPoints findPointById(Long id,int type) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("type", type);
        return tPointsMapper.findPointById(paramMap);
    }

    @Override
    public List<TPoints> findParentPoints(int type){
        return tPointsMapper.findParentPoints(type);
    }

    @Override
    public int findHasChildPoint(Long id) {
        return tPointsMapper.findHasChildPoint(id);
    }


}
