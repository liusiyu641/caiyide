package com.caiyide.primary.service;

import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BAdvertisement;
import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.web.param.BAdvertisementParam;

/**
 * <p>
 * 广告 服务类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
public interface BAdvertisementService extends IService<BAdvertisement> {

    BAdvertisement getById(String id);


    Paging getPageList(BAdvertisementParam bAdvertisementParam);
}
