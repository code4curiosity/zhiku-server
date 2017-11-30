package com.ccbjb.dao;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.BaseDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface TPointsDao extends BaseDao<TPoints> {
    List<TPoints> findAllPoints(Map<String, String> map);
    TPoints findPointById(Long id,int type);
    List<TPoints> findParentPoints(int type);

}
