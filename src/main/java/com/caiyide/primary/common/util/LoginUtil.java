package com.caiyide.primary.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;


/**
 * @author liujixiang
 * @date 2018/8/8
 */
public class LoginUtil {

    private static final Logger logger = LoggerFactory.getLogger(LoginUtil.class);

    /**
     * TOKEN有效时间，单位分钟
     */
    public static Integer TOKEN_VALID_TIME_MINUTE;

    static {
        Environment environment = SpringContextUtil.getBean( Environment.class);
        String time = environment.getProperty("caiyide.login.token.valid.time.minute");
        TOKEN_VALID_TIME_MINUTE = Integer.valueOf(time);
        logger.info("TOKEN_VALID_TIME_MINUTE:{}",TOKEN_VALID_TIME_MINUTE);
    }

//    /**
//     * 获取当前登陆用户对象
//     * @return
//     */
//    public static LoginSysUserVo getLoginSysUser(){
//        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) HttpServletRequestUtil.getRequest().getAttribute(CommonConstant.LOGIN_SYS_USER);
//        return loginSysUserVo;
//    }
//
//    /**
//     * 获取当前登陆用户的ID
//     * @return
//     */
//    public static String getUserId(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getUserId();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的账号
//     * @return
//     */
//    public static String getAccount(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getAccount();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的账号
//     * @return
//     */
//    public static String getUserName(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getUserName();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的公司ID
//     * @return
//     */
//    public static String getCompanyId(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getCompanyId();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的区域ID
//     * @return
//     */
//    public static String getAreaId(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getAreaId();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的分公司ID
//     * @return
//     */
//    public static String getFilialeId(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getFilialeId();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的组织ID
//     * @return
//     */
//    public static String getOrgId(){
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getOrgId();
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前登陆用户的用户组
//     * @return
//     */
//    public static String getUserGroup() {
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getUserGroup();
//        }
//        return null;
//    }
//
//    /**
//     * 判断是否是管理员，true:是,false:否
//     * @return
//     */
//    public static Boolean isAdmin() {
//        LoginSysUserVo loginSysUserVo = getLoginSysUser();
//        if (loginSysUserVo !=null){
//            return loginSysUserVo.getAdmin();
//        }
//        return null;
//    }
}
