package com.ccbjb.service.tips;

import com.ccbjb.common.domain.TTips;
import com.ccbjb.common.mybatis.Result;

import java.util.Map;

public interface ITipsService {
    Result addTip(TTips tTips);
    Result findTips(int tipsNo);
    Result findCatalogue();
    Result findPage(Map<String, String> resultMap, Integer pageNo,
                    Integer pageSize);

}
