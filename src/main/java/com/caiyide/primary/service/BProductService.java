package com.caiyide.primary.service;

import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BProduct;
import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.web.param.BProductParam;

/**
 * <p>
 * 产品表 服务类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
public interface BProductService extends IService<BProduct> {

    BProduct getById(String id);


    Paging getPageList(BProductParam bProductParam);
}
