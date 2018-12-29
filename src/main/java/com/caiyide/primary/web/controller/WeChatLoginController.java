package com.caiyide.primary.web.controller;

import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BUser;
import com.caiyide.primary.service.BUserService;
import com.caiyide.primary.service.impl.WeChatLogin;
import com.caiyide.primary.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor liusiyu
 * @create 2018-12-27-11:53
 */
@RestController
@RequestMapping("/login")
@Api(description = "登陆 API")
public class WeChatLoginController {
    private static final Logger logger = LoggerFactory.getLogger(BUserController.class);

    @Autowired
    private WeChatLogin weChatLogin;
    /**
     * 微信小程序登陆
     */
    @PostMapping("/wechatlogin")
    @ApiOperation(value = "微信小程序登陆",notes = "微信小程序登陆",response = ResponseResult.class)
    public ResponseResult wechatlogin(String code) throws Exception{
        return   weChatLogin.login( code );
    }

}
