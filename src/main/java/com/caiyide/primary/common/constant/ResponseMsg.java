package com.caiyide.primary.common.constant;

public interface ResponseMsg {
    String SERVER_EXCEPTION = "服务器繁忙";
    String NOT_PERMISSION = "没有权限";
    String NOT_LOGIN = "未登录";

    String SMS_TEMPLET_ERR = "短信模板有误";
    String CODE_ERROR = "验证码错误";
    String CODE_HAS_EXPIRED = "您输入的验证码已过期,请重新获取验证码";
    String MOBILE_NULL = "您未输入账号,请重新输入";
    String PASSWORD_NULL = "您未输入密码,请重新输入";
    String NOT_ACCOUNT = "您的账号不存在,请在注册后重新登录";
    String HAVE_ACCOUNT = "您的账号已存在,请前往登录页面登录";
    String ERROR_PASSEORD = "密码输入错误,请重新输入";

}
