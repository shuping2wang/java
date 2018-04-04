package com.wsp.json;

import com.alibaba.fastjson.JSON;

public class JsonHelper {
    /**
      * @description <p></p>
      * @author wsp
      * @date 2018/3/24 13:47
      * @copyright	此方法版权归本人所有
      */
    public static String objToStr(Object obj){
        if(null==obj) return null;
        return JSON.toJSONString(obj);
    }
}
