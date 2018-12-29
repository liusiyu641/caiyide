package com.caiyide.primary.service;

import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BOrder;
import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.web.param.BOrderParam;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
public interface BOrderService extends IService<BOrder> {

    BOrder getById(String id);

    Paging getPageList(BOrderParam bOrderParam);
}
