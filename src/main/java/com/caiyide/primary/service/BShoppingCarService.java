package com.caiyide.primary.service;

import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BShoppingCar;
import com.caiyide.primary.web.param.BShoppingCarParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
public interface BShoppingCarService extends IService<BShoppingCar> {

    BShoppingCar getById(String id);

    Paging getPageList(BShoppingCarParam bShoppingCarParam);
}
