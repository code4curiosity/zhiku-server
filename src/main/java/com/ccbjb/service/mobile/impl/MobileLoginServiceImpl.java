package com.ccbjb.service.mobile.impl;

import com.ccbjb.common.domain.ShopOwner;
import com.ccbjb.dao.ShopOwnerDao;
import com.ccbjb.dao.cache.RedisDao;
import com.ccbjb.logic.user.MobileUserManager;
import com.ccbjb.service.mobile.MobileLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
public class MobileLoginServiceImpl implements MobileLoginService{

    @Autowired
    ShopOwnerDao iShopOwnerDao;
    @Autowired
    private RedisDao redisDao;
    @Override
    public ShopOwner login(ShopOwner user) {
        Map<String,Object> map = new HashMap<String, Object>();
        String mobile = user.getMobile();
        String password = user.getPswd();
        ShopOwner result = iShopOwnerDao.findUserByMobile(mobile);
        result.setPswd(password);
        if(result!=null){
            map.put("mobile", mobile);
            user = MobileUserManager.md5Pswd(result);
            map.put("pswd", result.getPswd());

            result = iShopOwnerDao.login(map);
            if(result!=null){
                //1：访问redis
                //String tokenId = redisDao.getTokenId(result.getEmail());
                String tokenId = MobileUserManager.createTokenId();
                redisDao.putUserId(tokenId, result.getMobile());
                result.setTokenId(tokenId);
            }
        }
        return result;
    }
}
