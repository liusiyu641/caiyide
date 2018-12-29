package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.entity.BAdvertisement;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.caiyide.primary.web.param.BAdvertisementParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  * 广告 Mapper 接口
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Repository
public interface BAdvertisementMapper extends BaseMapper<BAdvertisement> {

    BAdvertisement getById(String id);

    List<BAdvertisement> getPageList(Page page, BAdvertisementParam bAdvertisementParam);

}