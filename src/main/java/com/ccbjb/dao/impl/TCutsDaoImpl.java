package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.TCuts;
import com.ccbjb.common.mapper.TCutsMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.TCutsDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class TCutsDaoImpl extends AbstractDao<TCuts> implements TCutsDao {
    @Resource
    TCutsMapper tCutsMapper;

    @Override
    public List<TCuts> findAllCuts(Long pointId) {
        return tCutsMapper.findAllCuts(pointId);
    }
}
