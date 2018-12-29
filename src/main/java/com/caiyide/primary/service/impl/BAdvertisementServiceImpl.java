package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BAdvertisement;
import com.caiyide.primary.mapper.BAdvertisementMapper;
import com.caiyide.primary.service.BAdvertisementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.web.param.BAdvertisementParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 广告 服务实现类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Service
@Transactional
public class BAdvertisementServiceImpl extends ServiceImpl<BAdvertisementMapper, BAdvertisement> implements BAdvertisementService {

    private static Logger logger = LoggerFactory.getLogger(BAdvertisementServiceImpl.class);

    @Autowired
    private BAdvertisementMapper bAdvertisementMapper;

    @Override
    public BAdvertisement getById(String id){
        return bAdvertisementMapper.getById(id);
    }

    @Override
    public Paging getPageList(BAdvertisementParam bAdvertisementParam){
        Page page = new Page<>();
        bAdvertisementParam.convert(page);
        page.setRecords(bAdvertisementMapper.getPageList(page,bAdvertisementParam));
        return new Paging(page);
    }
}
