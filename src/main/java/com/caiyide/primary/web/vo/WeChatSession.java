package com.caiyide.primary.web.vo;

/**
 * @outhor liusiyu
 * @create 2018-12-27-10:37
 */
public class WeChatSession {
   private   String openid;
   private   String session_key;
   private   Number errcode;
   private   String errmsg;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Number getErrcode() {
        return errcode;
    }

    public void setErrcode(Number errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
