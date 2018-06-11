package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.TZhikuInfo;
import com.ccbjb.common.mybatis.TKMMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TZhikuInfoMapper extends TKMMapper<TZhikuInfo> {
    List<TZhikuInfo> selectInfoByInfoNo(@Param("categoryId") String categoryId, @Param("findContent") String findContent);
    List<TZhikuInfo> findInfoParents(String categoryId);
    List<TZhikuInfo> findInfoItems(@Param("parentId")Long parentId);
}
