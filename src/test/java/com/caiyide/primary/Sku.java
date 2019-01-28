package com.caiyide.primary;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.caiyide.primary.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 产品表
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@TableName("b_product")
@ApiModel("产品表")
public class Sku extends BaseEntity {

	private  Long Skuid;
    /**
     * 产品ID
     */
	@ApiModelProperty("产品ID")
	private Integer productId;
    /**
     * 商品名字
     */
	@ApiModelProperty("商品名字")
	@TableField("product_name")
	private String productName;
    /**
     * 商品图片
     */
	@ApiModelProperty("商品图片")
	@TableField("product_image")
	private String productImage;
    /**
     * 商品单价
     */
	@ApiModelProperty("商品单价")
	@TableField("product_price")
	private Double productPrice;
    /**
     * 商品总量
     */
	@ApiModelProperty("商品总量")
	@TableField("product_total")
	private Integer productTotal;
    /**
     * 1-蔬菜 2-肉类
     */
	@ApiModelProperty("1-蔬菜 2-肉类")
	@TableField("product_type")
	private Integer productType;
    /**
     * 创建人ID userID
     */
	@ApiModelProperty("创建人ID userID")
	@TableField("product_creater")
	private String productCreater;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	@TableField("create_time")
	private Date createTime;

	public Long getSkuid() {
		return Skuid;
	}

	public void setSkuid(Long skuid) {
		Skuid = skuid;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(Integer productTotal) {
		this.productTotal = productTotal;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getProductCreater() {
		return productCreater;
	}

	public void setProductCreater(String productCreater) {
		this.productCreater = productCreater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	protected Serializable pkVal() {
        return this.Skuid;
	}

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
