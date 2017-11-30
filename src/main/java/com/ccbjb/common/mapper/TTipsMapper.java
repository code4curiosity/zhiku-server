package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.mybatis.TKMMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTipsMapper extends TKMMapper<TTips> {
    List<TTips> selectTipsByTipsNo (@Param("tipsNo") int tipsNo, @Param("findContent") String findContent);
}
