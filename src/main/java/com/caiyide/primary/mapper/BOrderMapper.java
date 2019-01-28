package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.caiyide.primary.entity.BOrder;
import com.caiyide.primary.web.param.BOrderParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  * 订单表 Mapper 接口
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Repository
public interface BOrderMapper extends BaseMapper<BOrder> {

    BOrder getById(String id);

    List<BOrder> getPageList(Page page, BOrderParam bOrderParam);

    void createOrder(BOrder bOrder);

}