package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.caiyide.primary.entity.BShoppingCar;
import com.caiyide.primary.web.param.BShoppingCarParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Repository
public interface BShoppingCarMapper extends BaseMapper<BShoppingCar> {

    BShoppingCar getById(String id);

    List<BShoppingCar> getPageList(Page page, BShoppingCarParam bShoppingCarParam);

}