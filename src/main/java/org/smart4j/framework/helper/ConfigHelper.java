package org.smart4j.framework.helper;

import org.smart4j.chapters2.common.PropUtils;
import org.smart4j.framework.ConfigConstant;

import java.util.Properties;

/**
 * 属性文件辅助类
 */
public class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropUtils.loadProps(ConfigConstant.CONFIG_FILE);
    /**
     * 获取jdbc驱动
     */
    public static String getJdbcDriver(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }
    /**
     * 获取jdbc的Url
     */
    public static String getJdbcUrl(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }
    /**
     * 获取jdbc的username
     */
    public static String getJdbcUserName(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }
    /**
     * 获取jdbc的paaaword
     *
     */
    public static String getJdbcPassword(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }
    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }
    /**
     * 获取应用Jsp路径
     */
    public static String getAppJspPath(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INFO/view/");
    }
    /**
     * 获取应用静态文件路径
     */
    public static String getAppAssetPath(){
        return PropUtils.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset/");
    }

}
