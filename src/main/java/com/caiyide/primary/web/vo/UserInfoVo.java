package com.caiyide.primary.web.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @outhor liusiyu
 * @create 2019-02-21-9:50
 */
public class UserInfoVo implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @TableId("user_id")
    private String userId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;
    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;
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
    private Integer sex;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    @TableField("head_portrait")
    private String headPortrait;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
