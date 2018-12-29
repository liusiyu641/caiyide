package com.caiyide.primary.util;

import java.util.UUID;

/**
 * @author liujixiang
 * @date 2018/8/8
 */
public class UUIDUtil {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    
}
