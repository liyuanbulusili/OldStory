package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码操作工具类
 *
 */
public class CodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeUtil.class);
    /**
     * 将Url编码
     */
    public static String encodeUrl(String source){
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode Url failure");
            throw new RuntimeException(e);
        }
        return target;
    }
    /**
     * 将Url解码
     */
    public static String decodeUrl(String source){
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("decode Url failure");
            throw new RuntimeException(e);
        }
        return target;
    }
}
