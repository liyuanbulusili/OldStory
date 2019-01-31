package org.smart4j.chapters2.common;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 */
public class CollectionUtil {
    /**
     * 判断集合Collection是否为空
     */
    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);


    }
    /**
     *判断Map是否为空
     */
    public static boolean isEmpty(Map map){
        return isEmpty(map);

    }
}
