package org.smart4j.chapters2.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if(str !=null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }
    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);

    }

    public static String[] splitString(String body, String s) {
        String[] sp = body.split("s");
        return sp;
    }
}
