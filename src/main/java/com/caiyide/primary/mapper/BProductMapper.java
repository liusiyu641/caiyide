package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.caiyide.primary.entity.BProduct;
import com.caiyide.primary.web.param.BProductNameParam;
import com.caiyide.primary.web.param.BProductParam;
import com.caiyide.primary.web.vo.ProductPageVo;
import com.caiyide.primary.web.vo.getByProductNameVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  * 产品表 Mapper 接口
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Repository
public interface BProductMapper extends BaseMapper<BProduct> {
    Integer getByUserId(String productCreater);

    BProduct getById(@Param("productId") Integer productId);

    List<ProductPageVo> getPageList(Page page, BProductParam bProductParam);

//    void  ChangeInventory(ProductUpVo productUpVo);

    List<BProduct> productList(@Param("productCreater") String productCreater);

    List<getByProductNameVo> getByProductName(Page page, BProductNameParam bProductNameParam);
}