package com.wsp.cache.redis.impl;
import com.hsy.java.util.serializer.SerializerHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.List;
/**
 * @author heshiyuan
 * @description <p>spring-data-redis缓存工具类</p>
 * @path java/com.hsy.java.util.cache.redis
 * @date 25/09/2017 3:01 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class AbstractSpringRedisCache extends AbstractSpringRedisCacheBase{
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    public abstract RedisTemplate<String,Object> getRedisTemplate() ;

    public <T> boolean putCache(String key, T obj) {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serialize(obj) ;
        // java8 labbda表达式
        return getRedisTemplate().execute(
            (RedisConnection redisConnection) -> redisConnection.setNX(bkey,bvalue)
        ) ;
    }

    public <T> boolean putCacheWithExpireTime(String key, T obj, long expireTime){
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serialize(obj) ;
        return this.getRedisTemplate().execute(
                (RedisConnection redisConnection) -> {
                    redisConnection.setEx(bkey,expireTime,bvalue);
                    return true;
                }
        ) ;
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serializeList(objList) ;
        // java8 labbda表达式
        return getRedisTemplate().execute(
            (RedisConnection redisConnection) -> redisConnection.setNX(bkey,bvalue)
        ) ;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, long expireTime) {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serializeList(objList) ;
        return this.getRedisTemplate().execute(
            (RedisConnection redisConnection) -> {
                redisConnection.setEx(bkey,expireTime,bvalue);
                return true;
            }
        ) ;
    }

    public <T> T getCache(String key, Class<T> targetClass) {
        byte[] result = this.getRedisTemplate().execute(
            (RedisConnection redisConnection) -> redisConnection.get(key.getBytes())
        );
        if(null == result){
            return null ;
        }
        return SerializerHelper.deserialize(result,targetClass);
    }

    public <T> List<T> getListCache(String key, Class<T> targetClass) {
        byte[] result = this.getRedisTemplate().execute(
                (RedisConnection redisConnection) -> redisConnection.get(key.getBytes())
        );
        if(null == result){
            return null ;
        }
        return SerializerHelper.deserializeList(result,targetClass);
    }
}
