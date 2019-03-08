package com.caiyide.primary.service;


import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BCollection;
import com.caiyide.primary.web.param.BCollectionParam;
import com.caiyide.primary.web.param.CollectParam;
import org.apache.ibatis.annotations.Param;

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

    ResponseResult addcollect(CollectParam collectParam);

    Paging getPageList(BCollectionParam bCollectionParam);

    ResponseResult deleteById(@Param("id") String id);
}
