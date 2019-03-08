package com.caiyide.primary.ShopCar;

import java.io.Serializable;

/**
 * @outhor liusiyu
 * @create 2019-02-15-13:54
 */
public class AddCarParam implements Serializable {
    private  Integer productId;
    private  Integer amount;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
