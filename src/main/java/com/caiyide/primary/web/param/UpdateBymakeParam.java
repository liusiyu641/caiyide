package com.caiyide.primary.web.param;

/**
 * @outhor liusiyu
 * @create 2019-02-20-16:12
 */
public class UpdateBymakeParam {
    private String orderNo;
    private String mark;
    private  Integer orderType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
