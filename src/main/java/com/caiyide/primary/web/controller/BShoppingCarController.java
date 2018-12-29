package com.caiyide.primary.web.controller;


import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.entity.BShoppingCar;
import com.caiyide.primary.service.BShoppingCarService;
import com.caiyide.primary.util.IdParam;
import com.caiyide.primary.web.param.BShoppingCarParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;

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
    private BShoppingCarService bShoppingCarService;

    /**
    * 添加
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加",notes = "添加",response = ResponseResult.class)
    public Object addBShoppingCar(@RequestBody BShoppingCar bShoppingCar) throws Exception{
        boolean flag = bShoppingCarService.insert(bShoppingCar);
        return ResponseResult.handle(flag);
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改",notes = "修改",response = ResponseResult.class)
    public Object updateBShoppingCar(@RequestBody BShoppingCar bShoppingCar) throws Exception{
        boolean flag = bShoppingCarService.updateById(bShoppingCar);
        return ResponseResult.handle(flag);
    }

    /**
    * 删除
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除",response = ResponseResult.class)
    public Object deleteBShoppingCar(@RequestBody IdParam idParam) throws Exception{
        boolean flag = bShoppingCarService.deleteById(idParam.getId());
        return ResponseResult.handle(flag);
    }

    /**
    * 获取
    */
    @PostMapping("/info")
    @ApiOperation(value = "查看",notes = "查看",response = ResponseResult.class)
    public Object getBShoppingCar(@RequestBody IdParam idParam) throws Exception{
        return bShoppingCarService.getById(idParam.getId());
    }

    /**
    * 分页列表
    */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取分页列表",notes = "获取分页列表",response = BShoppingCar.class)
    public Object getBShoppingCarPageList(@RequestBody(required = false) BShoppingCarParam bShoppingCarParam) throws Exception{
        return bShoppingCarService.getPageList(bShoppingCarParam);
    }
}
