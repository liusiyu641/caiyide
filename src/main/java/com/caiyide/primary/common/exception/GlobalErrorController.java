package com.caiyide.primary.common.exception;

import com.caiyide.primary.common.constant.ResponseCode;
import com.caiyide.primary.common.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 全局Error/404处理
 * @author liujixiang
 * @date 2018/08/05
 */
@ApiIgnore
@RestController
public class GlobalErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalErrorController.class);

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public ResponseResult handleError(){
        logger.error("4004");
        return new ResponseResult( ResponseCode.NOT_FOUND,"你请求的路径不存在");
    }

    @Override
    public String getErrorPath() {
        logger.error("errorPath....");
        return ERROR_PATH;
    }
}
