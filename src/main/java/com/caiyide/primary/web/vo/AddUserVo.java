package com.caiyide.primary.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @outhor liusiyu
 * @create 2018-12-28-19:18
 */
@ApiModel("添加用户")
public class AddUserVo  implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    /**
     * 微信登录唯一标识
     */
    @ApiModelProperty("微信登录唯一标识")
    private String weixinCode;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 最近一次登录时间
     */
    @ApiModelProperty("最近一次登录时间")
    private Date LastloginTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWeixinCode() {
        return weixinCode;
    }

    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastloginTime() {
        return LastloginTime;
    }

    public void setLastloginTime(Date lastloginTime) {
        LastloginTime = lastloginTime;
    }
}
