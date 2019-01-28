package com.caiyide.primary.web.controller;


import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.service.impl.ShoppingCart;
import com.caiyide.primary.web.vo.ProductUpVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@RestController
@RequestMapping("/bShoppingCar")
@Api(description = " API")
public class BShoppingCarController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BShoppingCarController.class);

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    HttpServletRequest request;
    /**
     * 购物车
     */
    @PostMapping("/ShopCar")
    @ApiOperation(value = "添加购物车",notes = "添加购物车",response = ResponseResult.class)
    public Object car(@RequestBody ProductUpVo productUpVo ) throws Exception{
        return  shoppingCart.car( productUpVo );
    }
    /**
     * 购物车
     */
//    @PostMapping("/删除购物车")
//    @ApiOperation(value = "删除购物车",notes = "删除购物车",response = ResponseResult.class)
//    public Object car(@RequestBody SigParma sigParma ) throws Exception{
//        return   shoppingCart.delectCar( sigParma.getSingleParma() );
//    }

    /**
     * 购物车列表
     */
    @PostMapping("/Carlist")
    @ApiOperation(value = "获取购物车",notes = "获取购物车",response = ResponseResult.class)
    public Object carlist() throws Exception{
        return   shoppingCart.Carlist( );
    }

}
