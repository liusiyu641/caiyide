package com.caiyide.primary.web.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @outhor liusiyu
 * @create 2019-02-20-17:18
 */
public class OrderDetailVos {
    private  String orderNo;
    private Date orderTime;
    private  List<OrderDetailVo>  listOrder;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderDetailVo> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<OrderDetailVo> listOrder) {
        this.listOrder = listOrder;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
