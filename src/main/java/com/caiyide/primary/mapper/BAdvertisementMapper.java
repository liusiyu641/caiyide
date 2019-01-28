package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.caiyide.primary.entity.BAdvertisement;
import com.caiyide.primary.web.param.BAdvertisementParam;
import com.caiyide.primary.web.vo.AdvertVo;
import org.apache.ibatis.annotations.Param;
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

    List<AdvertVo>  getAdvert(@Param("AdvertType") Integer AdvertType, @Param("AdvertState") Integer AdvertState);

    List<BAdvertisement> getPageList(Page page, BAdvertisementParam bAdvertisementParam);

}