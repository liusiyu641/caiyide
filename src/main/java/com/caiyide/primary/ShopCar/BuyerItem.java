package com.caiyide.primary.ShopCar;

import com.caiyide.primary.entity.BProduct;

import java.io.Serializable;

public class BuyerItem implements Serializable {

    private static final long serialVersionUID = 1L;

    //SKu对象
    private BProduct bProduct;

    //是否有货
    private Boolean isHave = true;

    //购买的数量
    private Integer amount = 1;


    public BProduct getSku() {
        return bProduct;
    }

    public void setSku(BProduct bProduct) {
        this.bProduct = bProduct;
    }

    public Boolean getIsHave() {
        return isHave;
    }

    public void setIsHave(Boolean isHave) {
        this.isHave = isHave;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bProduct == null) ? 0 : bProduct.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //比较地址
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyerItem other = (BuyerItem) obj;
        if (bProduct == null) {
            if (other.bProduct != null)
                return false;
        } else if (!bProduct.getProductId().equals( other.bProduct.getProductId() ))
            return false;
        return true;
    }
}
