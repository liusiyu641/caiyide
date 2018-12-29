package com.caiyide.primary.web.controller;


import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.entity.BAdvertisement;
import com.caiyide.primary.service.BAdvertisementService;
import com.caiyide.primary.util.IdParam;
import com.caiyide.primary.web.param.BAdvertisementParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 广告 前端控制器
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@RestController
@RequestMapping("/bAdvertisement")
@Api(description = "广告 API")
public class BAdvertisementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BAdvertisementController.class);

    @Autowired
    private BAdvertisementService bAdvertisementService;

    /**
    * 添加广告
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加",notes = "添加",response = ResponseResult.class)
    public Object addBAdvertisement(@RequestBody BAdvertisement bAdvertisement) throws Exception{
        boolean flag = bAdvertisementService.insert(bAdvertisement);
        return ResponseResult.handle(flag);
    }

    /**
    * 修改广告
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改",notes = "修改",response = ResponseResult.class)
    public Object updateBAdvertisement(@RequestBody BAdvertisement bAdvertisement) throws Exception{
        boolean flag = bAdvertisementService.updateById(bAdvertisement);
        return ResponseResult.handle(flag);
    }

    /**
    * 删除广告
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除",response = ResponseResult.class)
    public Object deleteBAdvertisement(@RequestBody IdParam idParam) throws Exception{
        boolean flag = bAdvertisementService.deleteById(idParam.getId());
        return ResponseResult.handle(flag);
    }

    /**
    * 获取广告
    */
    @PostMapping("/info")
    @ApiOperation(value = "查看",notes = "查看",response = ResponseResult.class)
    public Object getBAdvertisement(@RequestBody IdParam idParam) throws Exception{
        return bAdvertisementService.getById(idParam.getId());
    }

    /**
    * 广告分页列表
    */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取分页列表",notes = "获取分页列表",response = BAdvertisement.class)
    public Object getBAdvertisementPageList(@RequestBody(required = false) BAdvertisementParam bAdvertisementParam) throws Exception{
        return bAdvertisementService.getPageList(bAdvertisementParam);
    }
}
