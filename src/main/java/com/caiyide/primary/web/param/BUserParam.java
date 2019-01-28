package com.caiyide.primary.web.param;


import com.caiyide.primary.common.vo.QueryParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 *  查询参数
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-26
 */

public class BUserParam extends QueryParam {
    @ApiModelProperty("商品类型")
    private  Integer productType;

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }
}
