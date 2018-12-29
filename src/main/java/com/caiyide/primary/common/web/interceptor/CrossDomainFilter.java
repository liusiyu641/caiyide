package com.caiyide.primary.common.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.caiyide.primary.common.vo.ResponseResult;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 设置允许跨域
 * @author liujixiang
 * @date
 */
public class CrossDomainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Request-Headers","*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "content-type,x-auth-token,second-pwd");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        if ("OPTIONS".equals(method)){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setCharacterEncoding("UTF-8");
            PrintWriter w = response.getWriter();
            ResponseResult responseResult = new ResponseResult();
            responseResult.setCode(200);
            responseResult.setMsg("ok...");
            w.append(JSON.toJSONString(responseResult));
            return;
        }

        filterChain.doFilter(servletRequest, httpServletResponse);

    }

    @Override
    public void destroy() {

    }
}
