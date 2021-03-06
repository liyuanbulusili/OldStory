package org.smart4j.framework.helper;

import org.smart4j.chapters2.common.CollectionUtil;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 实现Ioc注入
 */
public class IocHelper {
    static {
        //获取所有Bean类和Bean实例之间的映射操作
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(!CollectionUtil.isEmpty(beanMap)){
            //遍历Bean Map
            for(Map.Entry<Class<?>,Object>beanEntry:beanMap.entrySet() ){
            //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量（简称Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    //遍历Bean Field
                    for(Field beanField : beanFields){
                        //判断当前Bean Field是否带有Inject注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance !=null){
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);

                            }
                        }
                    }
                }


            }
        }

    }
}
