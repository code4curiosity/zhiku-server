package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.ShopOwner;
import com.ccbjb.common.mapper.ShopOwnerMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.ShopOwnerDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class ShopOwnerDaoImpl extends AbstractDao<ShopOwner> implements ShopOwnerDao {
    @Resource
    private ShopOwnerMapper shopOwnerMapper;

    @Override
    public ShopOwner login(Map<String, Object> map) {
        return shopOwnerMapper.login(map);
    }

    @Override
    public ShopOwner findUserByMobile(String mobile) {
        return shopOwnerMapper.findUserByMobile(mobile);
    }
}
