package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BProduct;
import com.caiyide.primary.mapper.BProductMapper;
import com.caiyide.primary.service.BProductService;
import com.caiyide.primary.web.param.BProductNameParam;
import com.caiyide.primary.web.param.BProductParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Service
@Transactional
public class BProductServiceImpl extends ServiceImpl<BProductMapper, BProduct> implements BProductService {

    private static Logger logger = LoggerFactory.getLogger(BProductServiceImpl.class);

    @Autowired
    private BProductMapper bProductMapper;

    @Override
    public BProduct getById(Integer id){
        return bProductMapper.getById(id);
    }



    @Override
    public Paging getPageList(BProductParam bProductParam){
        Page page = new Page<>();
        bProductParam.convert(page);
        page.setRecords(bProductMapper.getPageList(page,bProductParam));
        return new Paging(page);
    }

    @Override
    public Paging getByProductName(BProductNameParam bProductNameParam) {
        Page page = new Page<>();
        bProductNameParam.convert(page);
        page.setRecords( bProductMapper.getByProductName(page,bProductNameParam));
        return new Paging(page);
    }
}
