package com.caiyide.primary.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
 * 收藏表
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@TableName("b_collection")
@ApiModel("收藏表")
public class BCollection extends BaseEntity {

    /**
     * 收藏id
     */
	@ApiModelProperty("收藏id")
	@TableId(value="collect_id", type= IdType.AUTO)
	private Integer collectId;
    /**
     * 用户ID
     */
	@ApiModelProperty("用户ID")
	@TableField("user_id")
	private String userId;
	/**
	 * 商家ID
	 */
	@ApiModelProperty("商家ID")
	@TableField("shop_id")
	private String shopId;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	private Date createtime;


	public Integer getCollectId() {
		return collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	protected Serializable pkVal() {
        return this.collectId;
	}

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
