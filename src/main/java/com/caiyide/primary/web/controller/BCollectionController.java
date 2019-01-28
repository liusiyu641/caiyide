package com.caiyide.primary.web.controller;



import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.entity.BCollection;
import com.caiyide.primary.service.BCollectionService;
import com.caiyide.primary.util.IdParam;
import com.caiyide.primary.web.param.BCollectionParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@RestController
@RequestMapping("/bCollection")
@Api(description = "收藏表 API")
public class BCollectionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BCollectionController.class);

    @Autowired
    private BCollectionService bCollectionService;

    /**
    * 添加收藏表
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加",notes = "添加",response = ResponseResult.class)
    public Object addBCollection(@RequestBody BCollection bCollection) throws Exception{
        boolean flag = bCollectionService.insert(bCollection);
        return ResponseResult.handle(flag);
    }

    /**
    * 修改收藏表
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改",notes = "修改",response = ResponseResult.class)
    public Object updateBCollection(@RequestBody BCollection bCollection) throws Exception{
        boolean flag = bCollectionService.updateById(bCollection);
        return ResponseResult.handle(flag);
    }

    /**
    * 删除收藏表
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除",response = ResponseResult.class)
    public Object deleteBCollection(@RequestBody IdParam idParam) throws Exception{
        boolean flag = bCollectionService.deleteById(idParam.getId());
        return ResponseResult.handle(flag);
    }

    /**
    * 获取收藏表
    */
    @PostMapping("/info")
    @ApiOperation(value = "查看",notes = "查看",response = ResponseResult.class)
    public Object getBCollection(@RequestBody IdParam idParam) throws Exception{
        return bCollectionService.getById(idParam.getId());
    }

    /**
    * 收藏表分页列表
    */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取分页列表",notes = "获取分页列表",response = BCollection.class)
    public Object getBCollectionPageList(@RequestBody(required = false) BCollectionParam bCollectionParam) throws Exception{
        return bCollectionService.getPageList(bCollectionParam);
    }
}
