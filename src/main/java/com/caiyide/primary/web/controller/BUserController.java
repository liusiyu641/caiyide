package com.caiyide.primary.web.controller;



import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.common.web.controller.BaseController;
import com.caiyide.primary.entity.BUser;
import com.caiyide.primary.service.BUserService;
import com.caiyide.primary.util.IdParam;
import com.caiyide.primary.util.LoginUtil;
import com.caiyide.primary.util.UUIDUtil;
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
 *  前端控制器
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-26
 */
@RestController
@RequestMapping("/bUser")
@Api(description = "用户管理 API")
public class BUserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BUserController.class);

    @Autowired
    private BUserService bUserService;

    /**
    * 添加
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加",notes = "添加",response = ResponseResult.class)
    public Object addBUser(@RequestBody BUser bUser) throws Exception{
        bUser.setUserId( UUIDUtil.getUUID());
        boolean flag = bUserService.insert(bUser);
        return ResponseResult.handle(flag);
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改",notes = "修改",response = ResponseResult.class)
    public Object updateBUser(@RequestBody BUser bUser) throws Exception{
        boolean flag = bUserService.updateById(bUser);
        return ResponseResult.handle(flag);
    }

    /**
    * 删除
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除",notes = "删除",response = ResponseResult.class)
    public Object deleteBUser(@RequestBody IdParam idParam) throws Exception{
        boolean flag = bUserService.deleteById(idParam.getId());
        return ResponseResult.handle(flag);
    }

    /**
    * 获取
    */
    @PostMapping("/info")
    @ApiOperation(value = "查看",notes = "查看",response = ResponseResult.class)
    public Object getBUser() throws Exception{
        String id = LoginUtil.getLoginSysUser().getUserId();
        return bUserService.getById(id);
    }




}
