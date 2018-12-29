package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.entity.BProduct;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.caiyide.primary.web.param.BProductParam;
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

    BProduct getById(String id);

    List<BProduct> getPageList(Page page, BProductParam bProductParam);

}