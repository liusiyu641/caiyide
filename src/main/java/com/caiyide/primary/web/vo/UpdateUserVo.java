package com.caiyide.primary.web.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @outhor liusiyu
 * @create 2018-12-29-17:10
 */
@ApiModel("更新用户信息")
public class UpdateUserVo {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;
    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 1-摊主 2-批发商
     */
    @ApiModelProperty("1-摊主 2-批发商")
    @TableField("user_type")
    private Integer userType;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 微信登录唯一标识
     */
    @ApiModelProperty("微信登录唯一标识")
    private String weixinCode;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headPortrait;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeixinCode() {
        return weixinCode;
    }

    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
