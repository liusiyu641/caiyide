package com.caiyide.primary.web.controller;


import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.entity.BProduct;
import com.caiyide.primary.service.BProductService;
import com.caiyide.primary.util.IdParam;
import com.caiyide.primary.web.param.BProductParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品表 前端控制器
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@RestController
@RequestMapping("/bProduct")
@Api(description = "产品表 API")
public class BProductController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BProductController.class);

    @Autowired
    private BProductService bProductService;

    /**
    * 添加产品表
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加",notes = "添加",response = ResponseResult.class)
    public Object addBProduct(@RequestBody BProduct bProduct) throws Exception{
        boolean flag = bProductService.insert(bProduct);
        return ResponseResult.handle(flag);
    }

    /**
    * 修改产品表
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改",notes = "修改",response = ResponseResult.class)
    public Object updateBProduct(@RequestBody BProduct bProduct) throws Exception{
        boolean flag = bProductService.updateById(bProduct);
        return ResponseResult.handle(flag);
    }

    /**
    * 删除产品表
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除",response = ResponseResult.class)
    public Object deleteBProduct(@RequestBody IdParam idParam) throws Exception{
        boolean flag = bProductService.deleteById(idParam.getId());
        return ResponseResult.handle(flag);
    }

    /**
    * 获取产品表
    */
    @PostMapping("/info")
    @ApiOperation(value = "查看",notes = "查看",response = ResponseResult.class)
    public Object getBProduct(@RequestBody IdParam idParam) throws Exception{
        return bProductService.getById(idParam.getId());
    }

    /**
    * 产品表分页列表
    */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取分页列表",notes = "获取分页列表",response = BProduct.class)
    public Object getBProductPageList(@RequestBody(required = false) BProductParam bProductParam) throws Exception{
        return bProductService.getPageList(bProductParam);
    }
}
