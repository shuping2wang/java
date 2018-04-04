package com.wsp.cache.redis.impl;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import com.hsy.java.util.serializer.SerializerHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
public abstract class AbstractSpringRedisCacheEnhance extends AbstractSpringRedisCacheBase{

    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    private ValueOperations<String,Object> valueOperations;
    private ListOperations<String,Object> listOperations;
    private HashOperations hashOperations;

    @PostConstruct
    public void getValueOperation(){
        valueOperations = getRedisTemplate().opsForValue();
        listOperations = getRedisTemplate().opsForList();
        hashOperations = getRedisTemplate().opsForHash();
    }

    public <T> boolean putCache(String key, T obj){
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        try{
            valueOperations.set(key,obj);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putCacheWithExpireTime(String key, T obj, long expireTime){
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        try{
            valueOperations.set(key,obj,expireTime);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putCacheWithExpireTimeAndTimeUnit(String key, T obj, long expireTime, TimeUnit timeUnit){
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        try{
            valueOperations.set(key,obj,expireTime,timeUnit);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        try{
            return listPushResult(listOperations.leftPush(key,objList)) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, long expireTime) {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        try{
            return listPushResult(listOperations.leftPush(key,objList,expireTime)) ;

        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    private boolean listPushResult(Long count){
        if(count > 0){
            _logger.error("list leftPush success;set {} count",count);
            return true ;
        }else{
            _logger.error("list leftPush error");
            return false ;
        }
    }

    public <T> T getCache(String key) {
        return (T) valueOperations.get(key);
    }

    public <T> List<T> getListCache(String key) {
        return (List<T>) listOperations.leftPop(key);
    }
}
