package com.caiyide.primary.common.exception;

import com.alibaba.fastjson.JSON;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.util.AnsiUtil;
import com.caiyide.primary.common.constant.ResponseCode;
import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liujixiang
 * @date 2018/08/05
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 非法参数验证异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseResult handleMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> list = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            list.add(fieldError.getDefaultMessage());
        }
        logger.error("handleMethodArgumentNotValidException");
        logger.error("fieldErrors"+list);
        logger.error("fieldErrors"+ JSON.toJSONString(list));
        return new ResponseResult(ResponseCode.PARAMETER_EXCEPTION,"参数异常",list);
    }
    /**
     * 业务层异常处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult businessExceptionHandler(HttpServletRequest request, BusinessException exception) {
        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        String exceptionMsg = "businessException:" + exception.getMessage()+":"+stackTraceElements[0].toString();
        logger.error( AnsiUtil.getAnsi(Ansi.Color.RED,exceptionMsg));
        Integer code = exception.getCode();
        code = (code==null?ResponseCode.BUSINESS_EXCEPTION:code);
        return new ResponseResult(code,exception.getMessage());
    }

    /**
     * 默认的异常处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult exceptionHandler(HttpServletRequest request, Exception exception) {
        logger.error("exception:",exception);
        return new ResponseResult(ResponseCode.ERROR,"系统异常!");
    }
}
