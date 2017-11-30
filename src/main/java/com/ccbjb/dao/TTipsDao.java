package com.ccbjb.dao;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.mapper.TTipsMapper;
import com.ccbjb.common.mybatis.BaseDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface TTipsDao extends BaseDao<TTips> {

    List<TTips> selectTipsByTipsNo (int tipsNo, String findContent);
}
