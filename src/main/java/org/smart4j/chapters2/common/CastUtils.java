package org.smart4j.chapters2.common;

/**
 * 处理数据类型转型操作
 */
public final class CastUtils {
    /**
     * 转为String类型
     */
    public static String castString(Object object){
        return CastUtils.castString(object,"");
    }
    /**
     * 转为String类型（提供默认值）
     */
    public static String castString(Object object,String defaultValue){
        return object!=null?String.valueOf(object):defaultValue;

    }
    /**
     * 转为double型
     */
    public static double castDouble(Object object){
        return CastUtils.castDouble(object,0);
    }
    /**
     * 转为double型（提供默认值）
     */
    public static double castDouble(Object object,double defaultValue){
        double doubleValue = defaultValue;
        if(object!=null){
            String castString = castString(object);
            if(StringUtil.isNotEmpty(castString)){
                try{
                doubleValue = Double.parseDouble(castString);
                }
                catch(NumberFormatException e){
                    doubleValue = defaultValue;
                    }
            }

        }
        return doubleValue;
    }

/**
 * 转为long型
 */
public static long castLong(Object object){
    return castLong(object,0);
}
/**
 * 转为long型(提供默认值)
 */
public static long castLong(Object object,long defaultValue){
    long value = defaultValue;
    if(object!=null){
        String castLong = castString(object);
        if(StringUtil.isNotEmpty(castLong)){
            try {
                value = Long.parseLong(castLong);
            }catch (NumberFormatException e) {
                value = defaultValue;
            }
        }

    }
    return value;
}
/**
 * 转为int型
 */
public static int castInt(Object object){
    return CastUtils.castInt(object,0);
}
/**
 * 转为int型（提供默认值）
 */
public static int castInt(Object object,int defaultValue) {
    int value = defaultValue;
    if(object!=null){
        String castString = castString(object);
        if(StringUtil.isNotEmpty(castString)){
            try {
                value = Integer.parseInt(castString);
            } catch (NumberFormatException e) {
                value= defaultValue;
            }


        }
    }
    return value;
}

    /**
     * 转为boolean型
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object){
    return CastUtils.castBoolean(object,false);
}
/**
 * 转为boolean型（提供默认值）
 */
public static boolean castBoolean(Object object,Boolean defaultValue){
    Boolean booleanValue = defaultValue;
    if(object!=null){
        boolean parseBoolean = Boolean.parseBoolean(castString(booleanValue));
    }
    return booleanValue;
}

 }