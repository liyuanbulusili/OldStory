package org.smart4j.framework.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 */
public class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls){
        Object instance;
        try {
            instance  = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure");
            throw new RuntimeException(e);
        }
        return instance;
    }
    /**
     * 调用方法
     */
    public static Object invokeMethod(Object object, Method method, Object... params){
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(object,params);
        } catch (Exception e) {
            LOGGER.error("invoke method failure");
            throw new RuntimeException(e);
        }
    return result;
    }
    /**
     * 设置成员变量的值
     */
    public static void setField(Object object, Field field, Object value){
        try {
            field.setAccessible(true);
            field.set(object,value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field failure");
            throw new RuntimeException(e);
        }
    }
}
