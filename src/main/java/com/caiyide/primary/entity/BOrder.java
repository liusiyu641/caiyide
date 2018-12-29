package com.caiyide.primary.entity;

import java.math.BigDecimal;
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
 * 订单表
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@TableName("b_order")
@ApiModel("订单表")

public class BOrder extends BaseEntity {

    /**
     * 订单id
     */
	@ApiModelProperty("订单id")
    @TableId("order_no")
	private String orderNo;
    /**
     * 用户id
     */
	@ApiModelProperty("用户id")
	@TableField("user_id")
	private String userId;
    /**
     * 商品ID
     */
	@ApiModelProperty("商品ID")
	@TableField("product_id")
	private Integer productId;
    /**
     * 商品数量
     */
	@ApiModelProperty("商品数量")
	@TableField("product_sum")
	private Integer productSum;
    /**
     * 订单总重量
     */
	@ApiModelProperty("订单总重量")
	@TableField("order_total")
	private Integer orderTotal;
    /**
     * 总价格
     */
	@ApiModelProperty("总价格")
	@TableField("product_All_price")
	private BigDecimal productAllPrice;
    /**
     * 订单状态 --1失效  0-待确认  1-已完成
     */
	@ApiModelProperty("订单状态 --1失效  0-待确认  1-已完成")
	@TableField("order_type")
	private Integer orderType;
    /**
     * 订单创建时间
     */
	@ApiModelProperty("订单创建时间")
	@TableField("order_time")
	private Date orderTime;


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductSum() {
		return productSum;
	}

	public void setProductSum(Integer productSum) {
		this.productSum = productSum;
	}

	public Integer getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}

	public BigDecimal getProductAllPrice() {
		return productAllPrice;
	}

	public void setProductAllPrice(BigDecimal productAllPrice) {
		this.productAllPrice = productAllPrice;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	@Override
	protected Serializable pkVal() {
        return this.orderNo;
	}

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
