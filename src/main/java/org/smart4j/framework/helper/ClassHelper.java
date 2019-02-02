package org.smart4j.framework.helper;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

public final class ClassHelper {
    /**
     * 定义类集合
     */
    private static final Set<Class<?>> CLASS_SET;
    static{
        String  basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getCLassSet(basePackage);
    }
    /**
     * 获取应用包下的所有类
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }
    /**
     * 获取应用包名下所有Service 类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
/**
 * 获取应用包名下所有Controller类
 */
public static Set<Class<?>> getControllerClassSet(){
    Set<Class<?>> classSet = new HashSet<>();
    for(Class<?> cls:CLASS_SET){
        if(cls.isAnnotationPresent(Controller.class)){
            classSet.add(cls);
        }

    }
    return classSet;

}
/**
 * 获取应用包下所有Bean类（包括：Service、Controller）
 */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;



        }
    }
