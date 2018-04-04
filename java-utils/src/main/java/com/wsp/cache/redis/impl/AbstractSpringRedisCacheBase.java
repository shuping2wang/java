package com.wsp.cache.redis.impl;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
public abstract class AbstractSpringRedisCacheBase {

    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    public abstract RedisTemplate<String,Object> getRedisTemplate() ;

    public void deleteCacheByKey(String key) {
        this.getRedisTemplate().delete(key);
    }

    public void deleteCacheByKeys(String... keys) {
        if(!org.springframework.util.StringUtils.isEmpty(keys) && keys.length != 0) {
            try{
                if(keys.length == 1) {
                    if(org.springframework.util.StringUtils.isEmpty(keys[0])) {
                        throw new IllegalArgumentException("指定删除的key不能为空");
                    }
                    this.getRedisTemplate().delete(keys[0]);
                } else {
                    this.getRedisTemplate().delete(Arrays.asList(keys));
                }
            }catch(Exception e){
                throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
            }
        } else {
            throw new IllegalArgumentException("指定删除的key不能为空");
        }
    }

    public void deleteCacheWithPattern(String pattern) {
        if(org.springframework.util.StringUtils.isEmpty(pattern)) {
            throw new IllegalArgumentException("指定删除的key不能为空");
        } else {
            Set<String> keys = this.getRedisTemplate().keys(pattern);
            this.getRedisTemplate().delete(keys);
        }
    }

    public void clearCache() {
        deleteCacheWithPattern("*");
    }

    public void deleteByPrefix(String prex) {
        if(org.springframework.util.StringUtils.isEmpty(prex)) {
            throw new IllegalArgumentException("指定删除的key前缀不能为空");
        } else {
            Set<String> keys = this.getRedisTemplate().keys(prex + "*");
            this.getRedisTemplate().delete(keys);
        }
    }
    public void deleteBySuffix(String suffix) {
        if(org.springframework.util.StringUtils.isEmpty(suffix)) {
            throw new IllegalArgumentException("指定删除的key后缀不能为空");
        } else {
            Set<String> keys = this.getRedisTemplate().keys("*" + suffix);
            this.getRedisTemplate().delete(keys);
        }
    }
}
