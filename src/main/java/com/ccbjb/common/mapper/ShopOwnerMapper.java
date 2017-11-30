package com.ccbjb.common.mapper;


import com.ccbjb.common.domain.ShopOwner;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.Map;

public interface ShopOwnerMapper extends TKMMapper<ShopOwner> {
    ShopOwner login(Map<String, Object> map);
    ShopOwner findUserByMobile(String mobile);
}