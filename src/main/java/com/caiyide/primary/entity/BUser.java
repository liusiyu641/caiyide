package com.caiyide.primary.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

import com.caiyide.primary.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>
 * 
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-26
 */
@TableName("b_user")
@ApiModel("用户表")
public class BUser extends BaseEntity {

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
	private Integer sex;
    /**
     * 微信登录唯一标识
     */
	@ApiModelProperty("微信登录唯一标识")
	@TableField("weixin_code")
	private String weixinCode;
    /**
     * 头像
     */
	@ApiModelProperty("头像")
	@TableField("head_portrait")
	private String headPortrait;

	@ApiModelProperty("店铺地址")
	private String address;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	@TableField("create_time")
	private Date createTime;
    /**
     * 最近一次登录时间
     */
	@ApiModelProperty("最近一次登录时间")
	@TableField("Lastlogin_time")
	private Date LastloginTime;


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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastloginTime() {
		return LastloginTime;
	}

	public void setLastloginTime(Date LastloginTime) {
		this.LastloginTime = LastloginTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	protected Serializable pkVal() {
        return this.userId;
	}

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
