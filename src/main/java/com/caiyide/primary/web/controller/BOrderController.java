package com.caiyide.primary.web.controller;


import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.entity.BOrder;
import com.caiyide.primary.service.BOrderService;
import com.caiyide.primary.util.IdParam;
import com.caiyide.primary.web.param.BOrderParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@RestController
@RequestMapping("/bOrder")
@Api(description = "订单表 API")
public class BOrderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BOrderController.class);

    @Autowired
    private BOrderService bOrderService;

    /**
    * 添加订单表
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加",notes = "添加",response = ResponseResult.class)
    public ResponseResult addBOrder(@RequestBody BOrder bOrder) throws Exception{
        return bOrderService.createOrder( bOrder );
    }

    /**
    * 修改订单表
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改",notes = "修改",response = ResponseResult.class)
    public Object updateBOrder(@RequestBody BOrder bOrder) throws Exception{
        boolean flag = bOrderService.updateById(bOrder);
        return ResponseResult.handle(flag);
    }

    /**
    * 删除订单表
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除",response = ResponseResult.class)
    public Object deleteBOrder(@RequestBody IdParam idParam) throws Exception{
        boolean flag = bOrderService.deleteById(idParam.getId());
        return ResponseResult.handle(flag);
    }

    /**
    * 获取订单表
    */
    @PostMapping("/info")
    @ApiOperation(value = "查看",notes = "查看",response = ResponseResult.class)
    public Object getBOrder(@RequestBody IdParam idParam) throws Exception{
        return bOrderService.getById(idParam.getId());
    }

    /**
    * 订单表分页列表
    */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取分页列表",notes = "获取分页列表",response = BOrder.class)
    public Object getBOrderPageList(@RequestBody(required = false) BOrderParam bOrderParam) throws Exception{
        return bOrderService.getPageList(bOrderParam);
    }
}
