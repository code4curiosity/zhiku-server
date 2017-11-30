package com.ccbjb.dao;

import com.ccbjb.common.domain.ShopOwner;
import com.ccbjb.common.mybatis.BaseDao;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface ShopOwnerDao extends BaseDao<ShopOwner> {

    ShopOwner login(Map<String, Object> map);
    ShopOwner findUserByMobile(String mobile);

}
