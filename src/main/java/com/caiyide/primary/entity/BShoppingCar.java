package com.caiyide.primary.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.caiyide.primary.common.entity.BaseEntity;

import java.io.Serializable;

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
 * @date 2018-12-28
 */
@TableName("b_shopping_car")
@ApiModel("")
public class BShoppingCar extends BaseEntity {

    /**
     * 购物车id
     */
	@ApiModelProperty("购物车id")
	@TableId(value="car_id", type= IdType.AUTO)
	private Integer carId;
    /**
     * 用户ID
     */
	@ApiModelProperty("用户ID")
	@TableField("user_id")
	private String userId;
    /**
     * 商品数量
     */
	@ApiModelProperty("商品数量")
	@TableField("product_sum")
	private Integer productSum;
    /**
     * 商品ID
     */
	@ApiModelProperty("商品ID")
	@TableField("product_id")
	private Integer productId;
    /**
     * 购物车状态 -1失效 0-等待确认 1-已完成
     */
	@ApiModelProperty("购物车状态 -1失效 0-等待确认 1-已完成")
	@TableField("car_type")
	private Integer carType;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	private Date createtime;


	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getProductSum() {
		return productSum;
	}

	public void setProductSum(Integer productSum) {
		this.productSum = productSum;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCarType() {
		return carType;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Override
	protected Serializable pkVal() {
        return this.carId;
	}

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
