package com.caiyide.primary.common.constant;

/**
 * 响应码
 *
 * @author liujixiang
 * @date 2018/08/05
 */
public interface ResponseCode {

    /**
     * 参数异常
     */
    Integer PARAMETER_EXCEPTION = 1000;

    /**
     * 操作成功
     */
    Integer SUCCESS = 200;
    /**
     * 操作失败
     */
    Integer ERROR = 500;
    /**
     * 服务器内部错误
     */
    String SERVER_ERROR = "SERVER_ERROR";
    /**
     * 系统级方法异常
     */
    Integer SYSTEM_EXCEPTION = 1003;
    /**
     * 数据库异常
     */
    Integer DAO_EXCEPTION = 1001;
    /**
     * 业务类异常
     */
    Integer BUSINESS_EXCEPTION = 1002;
    /**
     * 未找到对应资源404
     */
    Integer NOT_FOUND = 404;
    /**
     * 未知异常
     */
    String UNKNOWN_EXCEPTION = "UNKNOWN_EXCEPTION";
    /**
     * 没有结果
     */
    Integer NOT_RESULT = 1004;

    /**
     * 没有权限
     */
    Integer NOT_PERMISSION = 403;

    /**
     * IP不允许访问
     */
    String IP_NOT_ALLOWED_ACCESS = "IP_NOT_ALLOWED_ACCESS";

    /**
     * 没有TOKEN
     */
    String NOT_TOKEN = "NOT_TOKEN";

    /**
     * TOKEN错误
     */
    String TOKEN_ERROR = "TOKEN_ERROR";

    /**
     * 登录失败
     */
    String LOGIN_FAIL = "LOGIN_FAIL";

    /**
     * 未登录
     */
    Integer NOT_LOGIN = 401;

    /**
     * 为完善资料
     */
    Integer NOT_INFO_PERFECT = 402;
    /**
     * 第一次登陆
     */
    Integer FIRST_LOGIN=403;
}
