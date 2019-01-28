package com.caiyide.primary.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.caiyide.primary.common.constant.ResponseCode;
import com.caiyide.primary.common.util.DateUtil;
import com.caiyide.primary.common.util.IpUtil;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.util.AnsiUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Controller Aop
 * 获取响应结果信息
 * </p>
 *
 * @author liujixiang
 * @date 2018/08/05
// */
@Aspect
@Component
public class ResponseResultAop {

    private static Logger logger = LoggerFactory.getLogger(ResponseResultAop.class);

    /**
     * 切点
     */
    private static final String POINTCUT = "execution(public * com.caiyide.primary.web.controller..*.*(..))";
    /**
     * 默认的请求内容类型,表单提交
     **/
    private static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    /**
     * JSON请求内容类型
     **/
    private static final String APPLICATION_JSON = "application/json";
    /**
     * GET请求
     **/
    private static final String GET = "GET";
    /**
     * POST请求
     **/
    private static final String POST = "POST";


    @Around(POINTCUT)
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取请求相关信息
        try {
            // 获取当前的HttpServletRequest对象
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();


            Map<String,Object> map = new LinkedHashMap<>();

            // 获取请求类名和方法名称
            Signature signature = joinPoint.getSignature();

            // 获取真实的方法对象
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();

            // 请求全路径
            String url = request.getRequestURI();
            map.put("path",url);
            // IP地址
            String ip = IpUtil.getRequestIp();
            map.put("ip",ip);

            // 获取请求方式
            String requestMethod = request.getMethod();
            map.put("requestMethod",requestMethod);

            // 获取请求内容类型
            String contentType = request.getContentType();
            map.put("contentType",contentType);

            // 判断控制器方法参数中是否有RequestBody注解
            Annotation[][] annotations = method.getParameterAnnotations();
            boolean isRequestBody = isRequestBody(annotations);
            map.put("isRequestBody",isRequestBody);
            // 设置请求参数
            Object requestParamJson = getRequestParamJsonString(joinPoint, request, requestMethod, contentType, isRequestBody);
            map.put("param",requestParamJson);
            map.put("time", DateUtil.getYYYYMMDDHHMMSS(new Date()));

            logger.info( AnsiUtil.getAnsi(Ansi.Color.GREEN,"requestInfo:"+JSON.toJSONString(map)));

        } catch (Exception e) {
            e.printStackTrace();
        }



        // 执行目标方法,获得返回值
        Object result = joinPoint.proceed();
        Object responseResult = null;
        try {
            responseResult = result;

            if (result != null) {
                if (result instanceof String) { // 如果返回视图页面,则注释
                    //responseResult = new ResponseResult(ResponseCode.SUCCESS,String.valueOf(result));
                }else if (result instanceof ModelAndView){
                }else if (!(result instanceof ResponseResult)) {
                    responseResult = new ResponseResult( ResponseCode.SUCCESS,"操作成功", result);
                }
            }else{
                responseResult = new ResponseResult(ResponseCode.NOT_RESULT,"没有数据", result);
            }

            if (responseResult != null && (responseResult instanceof ResponseResult)){
                ResponseResult rr = (ResponseResult) responseResult;
                Integer code = rr.getCode();
                if (code != 200){
                    logger.error(AnsiUtil.getAnsi(Ansi.Color.RED,"responseResult:"+JSON.toJSONString(responseResult)));
                }else{
                    logger.info(AnsiUtil.getAnsi(Ansi.Color.BLUE,"responseResult:"+JSON.toJSONString(responseResult)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseResult;
    }



    /**
     * 获取请求参数JSON字符串
     *
     * @param joinPoint
     * @param request
     * @param requestMethod
     * @param contentType
     * @param isRequestBody
     */
    private Object getRequestParamJsonString(ProceedingJoinPoint joinPoint, HttpServletRequest request, String requestMethod, String contentType, boolean isRequestBody) {
        /**
         * 判断请求内容类型
         * 通常有3中请求内容类型
         * 1.发送get请求时,contentType为null
         * 2.发送post请求时,contentType为application/x-www-form-urlencoded
         * 3.发送post json请求,contentType为application/json
         * 4.发送post json请求并有RequestBody注解,contentType为application/json
         */
        Object paramObject = null;
        int requestType = 0;
        if (GET.equals(requestMethod)) {
            requestType = 1;
        } else if (POST.equals(requestMethod)) {
            if (contentType == null) {
                requestType = 5;
            } else if (contentType.startsWith(APPLICATION_X_WWW_FORM_URLENCODED)) {
                requestType = 2;
            } else if (contentType.startsWith(APPLICATION_JSON)) {
                if (isRequestBody) {
                    requestType = 4;
                } else {
                    requestType = 3;
                }
            }
        }

        // 1,2,3中类型时,获取getParameterMap中所有的值,处理后序列化成JSON字符串
        if (requestType == 1 || requestType == 2 || requestType == 3 || requestType == 5) {
            Map<String, String[]> paramsMap = request.getParameterMap();
            paramObject = getJsonForParamMap(paramsMap);
        } else if (requestType == 4) { // POST,application/json,RequestBody的类型,简单判断,然后序列化成JSON字符串
            Object[] args = joinPoint.getArgs();
            paramObject = argsArrayToJsonString(args);
        }

        return paramObject;
    }

    /**
     * 判断控制器方法参数中是否有RequestBody注解
     *
     * @param annotations
     * @return
     */
    private boolean isRequestBody(Annotation[][] annotations) {
        boolean isRequestBody = false;
        for (Annotation[] annotationArray : annotations) {
            for (Annotation annotation : annotationArray) {
                if (annotation instanceof RequestBody) {
                    isRequestBody = true;
                }
            }
        }
        return isRequestBody;
    }

    /**
     * 请求参数拼装
     *
     * @param args
     * @return
     */
    private Object argsArrayToJsonString(Object[] args) {
        if (args == null) {
            return null;
        }
        if (args.length == 1) {
            return args[0];
        } else {
            return args;
        }
    }


    /**
     * 获取参数Map的JSON字符串
     *
     * @param paramsMap
     * @return
     */
    public JSONObject getJsonForParamMap(Map<String, String[]> paramsMap) {
        int paramSize = paramsMap.size();
        if (paramsMap == null || paramSize == 0) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, String[]> kv : paramsMap.entrySet()) {
            String key = kv.getKey();
            String[] values = kv.getValue();
            if (values == null) { // 没有值
                jsonObject.put(key, null);
            } else if (values.length == 1) { // 一个值
                jsonObject.put(key, values[0]);
            } else { // 多个值
                jsonObject.put(key, values);
            }
        }
        return jsonObject;
    }


}
