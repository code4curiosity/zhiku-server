package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;
import java.util.Map;

public interface TPointsMapper extends TKMMapper<TPoints> {
    List<TPoints> findAllPoints(Map<String, String> map);
    TPoints findPointById(Map<String, Object> paramMap);
    List<TPoints> findParentPoints(int type);
}