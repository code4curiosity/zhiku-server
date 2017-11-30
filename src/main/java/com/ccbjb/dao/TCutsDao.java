package com.ccbjb.dao;

import com.ccbjb.common.domain.TCuts;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface TCutsDao extends BaseDao<TCuts> {
    List<TCuts> findAllCuts(Long pointId);
}
