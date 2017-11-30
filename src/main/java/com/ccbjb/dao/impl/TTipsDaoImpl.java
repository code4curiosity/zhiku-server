package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.mapper.TTipsMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.TTipsDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class TTipsDaoImpl extends AbstractDao<TTips> implements TTipsDao {

    @Resource
    TTipsMapper tTipsMapper;

    @Override
    public List<TTips> selectTipsByTipsNo(int tipsNo, String findContent) {
        return tTipsMapper.selectTipsByTipsNo(tipsNo, findContent);
    }
}
