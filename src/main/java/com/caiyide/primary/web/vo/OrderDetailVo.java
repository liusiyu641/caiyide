package com.caiyide.primary.web.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @outhor liusiyu
 * @create 2019-02-20-15:48
 */
public class OrderDetailVo {
    /**
     * 订单id
     */
    @ApiModelProperty("订单id")
    private String orderNo;
    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private Integer productSum;
    /**
     * 总价格
     */
    @ApiModelProperty("总价格")
    private Float productAllPrice;
    /**
     * 商品名字
     */
    @ApiModelProperty("商品名字")
    private String productName;
    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String productImage;

    /**
     * 订单创建时间
     */
    @ApiModelProperty("订单创建时间")
    private Date orderTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getProductSum() {
        return productSum;
    }

    public void setProductSum(Integer productSum) {
        this.productSum = productSum;
    }

    public Float getProductAllPrice() {
        return productAllPrice;
    }

    public void setProductAllPrice(Float productAllPrice) {
        this.productAllPrice = productAllPrice;
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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
