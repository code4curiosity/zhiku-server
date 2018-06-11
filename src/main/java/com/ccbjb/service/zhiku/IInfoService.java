package com.ccbjb.service.zhiku;

import com.ccbjb.common.domain.TZhikuInfo;
import com.ccbjb.common.mybatis.Result;

import java.util.List;
import java.util.Map;

public interface IInfoService {
    Result findPage(String categoryId, Map<String, String> resultMap, Integer pageNo,
                    Integer pageSize);
    List<TZhikuInfo> findAllNoPage(String categoryId);
    Result selectInfoById(String infoId);

    void insertSelective(TZhikuInfo info);

    Result selectInfoParents(String categoryId);

    Result deleteInfoById(String categoryId, Long[] ids);
}
