package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BOrder;
import com.caiyide.primary.mapper.BOrderMapper;
import com.caiyide.primary.service.BOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.web.param.BOrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Service
@Transactional
public class BOrderServiceImpl extends ServiceImpl<BOrderMapper, BOrder> implements BOrderService {

    private static Logger logger = LoggerFactory.getLogger(BOrderServiceImpl.class);

    @Autowired
    private BOrderMapper bOrderMapper;

    @Override
    public BOrder getById(String id){
        return bOrderMapper.getById(id);
    }

    @Override
    public Paging getPageList(BOrderParam bOrderParam){
        Page page = new Page<>();
        bOrderParam.convert(page);
        page.setRecords(bOrderMapper.getPageList(page,bOrderParam));
        return new Paging(page);
    }
}
