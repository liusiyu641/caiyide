package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BShoppingCar;
import com.caiyide.primary.mapper.BShoppingCarMapper;
import com.caiyide.primary.service.BShoppingCarService;
import com.caiyide.primary.web.param.BShoppingCarParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Service
@Transactional
public class BShoppingCarServiceImpl extends ServiceImpl<BShoppingCarMapper, BShoppingCar> implements BShoppingCarService {

    private static Logger logger = LoggerFactory.getLogger(BShoppingCarServiceImpl.class);

    @Autowired
    private BShoppingCarMapper bShoppingCarMapper;

    @Override
    public BShoppingCar getById(String id){
        return bShoppingCarMapper.getById(id);
    }

    @Override
    public Paging getPageList(BShoppingCarParam bShoppingCarParam){
        Page page = new Page<>();
        bShoppingCarParam.convert(page);
        page.setRecords(bShoppingCarMapper.getPageList(page,bShoppingCarParam));
        return new Paging(page);
    }

    /**
     * 向购物车添加数据
     */

    /**
     * 获取购物车列表
     * @return
     */
    public List<BShoppingCar> getItemRedis(){
        return null;
    }
}
