package com.caiyide.primary.util;

/**
 * @author liujixiang
 * @date 2018/8/6
 */
public class TokenUtil {

    /**
     * 生成token
     * @return
     */
    public static String generateXAuthToken(){
        String token = UUIDUtil.getUUID();
        return token;
    }

    /**
     * 生成token
     * @return
     */
    public static String generateFirstLoginRestPwdToken(){
        String token =  UUIDUtil.getUUID();
        return token;
    }

    /**
     * 生成验证码token
     * @return
     */
    public static String generateVerificationCodeToken(){
        String token = "verification-code-token:" + UUIDUtil.getUUID();
        return token;
    }
}
