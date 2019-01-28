package com.caiyide.primary.service;


import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BCollection;
import com.caiyide.primary.web.param.BCollectionParam;

/**
 * <p>
 * 收藏表 服务类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
public interface BCollectionService extends IService<BCollection> {

    BCollection getById(String id);


    Paging getPageList(BCollectionParam bCollectionParam);
}
