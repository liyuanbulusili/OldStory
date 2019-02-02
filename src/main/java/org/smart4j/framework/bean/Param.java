package org.smart4j.framework.bean;

import org.smart4j.chapters2.common.CastUtils;

import java.util.Map;
/**
 * 请求参数对象
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    /**
     * 根据参数名获取long型参数值
     */
    public long getLong(long name){
        return CastUtils.castLong(paramMap.get(name));
    }
    /**
     * 获取所有字段信息
     */
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
