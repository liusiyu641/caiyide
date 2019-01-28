package com.caiyide.primary.web.param;

import com.caiyide.primary.common.vo.QueryParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 产品表 查询参数
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
public class BProductParam extends QueryParam {
    /**
     * 创建人ID userID
     */
    @ApiModelProperty("创建人ID userID")
    private String productCreater;

    public String getProductCreater() {
        return productCreater;
    }

    public void setProductCreater(String productCreater) {
        this.productCreater = productCreater;
    }
}
