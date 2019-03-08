package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BOrder;
import com.caiyide.primary.entity.BProduct;
import com.caiyide.primary.mapper.BOrderMapper;
import com.caiyide.primary.mapper.BProductMapper;
import com.caiyide.primary.service.BOrderService;
import com.caiyide.primary.util.OrderUtil;
import com.caiyide.primary.web.param.BOrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    private static Logger logger = LoggerFactory.getLogger( BOrderServiceImpl.class );

    @Autowired
    private BOrderMapper bOrderMapper;
    @Autowired
    private BProductMapper bProductMapper;

    @Override
    public BOrder getById(String id) {
        return bOrderMapper.getById( id );
    }

    @Override
    public Paging getPageList(BOrderParam bOrderParam) {
        Page page = new Page<>();
        bOrderParam.convert( page );
        page.setRecords( bOrderMapper.getPageList( page, bOrderParam ) );
        return new Paging( page );
    }

    @Override
    public ResponseResult createOrder(BOrder bOrder) {
        //获取产品数量
//        BProduct bProduct = bProductMapper.getById( bOrder.getProductId() );
//        if (bProduct == null) {
//            ResponseResult.error( "没有该商品！" );
//        }
//        Integer productSum = bProduct.getProductTotal();
        //判断库存是否足够
//        if (productSum < bOrder.getProductSum()) {
//            return ResponseResult.error( "商品库存不足" );
//        }
        BOrder orderparam = new BOrder();
        orderparam.setOrderNo( OrderUtil.random() );
        orderparam.setOrderTime( new Date() );
        orderparam.setOrderType( bOrder.getOrderType() );
        orderparam.setProductAllPrice( bOrder.getProductAllPrice() );
        orderparam.setProductId( bOrder.getProductId() );
        orderparam.setProductSum( bOrder.getProductSum() );
        orderparam.setUserId( bOrder.getUserId() );
        bOrderMapper.createOrder( orderparam );
        return ResponseResult.success( "添加成功" );
    }
}
