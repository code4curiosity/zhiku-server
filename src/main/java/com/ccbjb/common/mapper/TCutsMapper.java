package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.TCuts;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;

public interface TCutsMapper extends TKMMapper<TCuts> {

    List<TCuts> findAllCuts(Long pointId);
}