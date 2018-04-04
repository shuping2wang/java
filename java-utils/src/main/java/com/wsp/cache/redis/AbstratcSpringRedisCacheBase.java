package com.wsp.cache.redis;
import com.hsy.java.exception.cache.CacheException;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p>缓存工具类接口</p>
 * @path java/com.hsy.java.util.cache.redis
 * @date 25/09/2017 3:26 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class AbstratcSpringRedisCacheBase<V> {
    /**
     * @description <p>添加进缓存当中</p>
     * @param key 存入缓存的key
     * @param obj 待存入redis的值对象
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 3:27 PM
     */
    abstract boolean putCache(String key, V obj) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param obj 待存入redis的值对象
     * @param expireTime 缓存过期时间
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 3:29 PM
     */
    abstract boolean putCacheWithExpireTime(String key, V obj, final long expireTime) throws CacheException;

    /**
     * @description <p>将list添加进缓存</p>
     * @param key 存入缓存的key
     * @param objList 存入缓存的list
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 4:07 PM
     */
    abstract boolean putListCache(String key, List<V> objList) throws CacheException;
    /**
     * @description <p>将list添加进缓存，带缓存过期时间</p>
     * @param key 存入缓存的key
     * @param objList  存入缓存的list
     * @param expireTime  缓存过期时间
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 4:09 PM
     */
    abstract boolean putListCacheWithExpireTime(String key, List<V> objList, final long expireTime) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param targetClass 存进去的数据类型
     * @return 存入的数据
     * @author heshiyuan
     * @date 25/09/2017 4:18 PM
     */
    abstract V getCache(final String key, Class<V> targetClass) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param targetClass 存进去的数据类型
     * @return 存入的list数据
     * @author heshiyuan
     * @date 25/09/2017 4:18 PM
     */
    abstract List<V> getListCache(final String key, Class<V> targetClass) throws CacheException;
    /**
     * @description <p>根据key精确删除数据</p>
     * @param key
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    abstract void deleteCacheByKey(String key) throws CacheException;
    /**
     * @description <p>根据key精确删除数据</p>
     * @param key
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    abstract void deleteCacheByKeys(String... key) throws CacheException;
    /**
     * @description <p>根据key模糊删除数据</p>
     * @param pattern
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    abstract void deleteCacheWithPattern(String pattern) throws CacheException;
    /**
     * @description <p>删除所有key</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    abstract void clearCache() throws CacheException;
    /**
     * @description <p>根据前缀模糊删除</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    abstract void deleteByPrefix(String prex)throws CacheException;
    /**
     * @description <p>根据后缀模糊删除</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    abstract void deleteBySuffix(String suffix) throws CacheException;
}
