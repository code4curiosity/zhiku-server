package com.ccbjb.dao.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 缓存dao
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
@Repository
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JedisPool jedisPool;

    public RedisDao(String host, int port, String password) {
        jedisPool = new JedisPool(new GenericObjectPoolConfig(), host, port, 2000, password);
    }

    public String getUserId(String tokenId) {
        //redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "tokenId:" + tokenId;
                String userId = jedis.get(key);
                return userId;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putUserId(String tokenId,String userId) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "tokenId:" + tokenId;
                //超时缓存
                int timeout = 60 * 60;//1小时
                String result = jedis.setex(key, timeout, userId);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }


}
