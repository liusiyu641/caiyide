package com.caiyide.primary.config;

import com.caiyide.primary.common.web.interceptor.CrossDomainFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liujixiang
 * @date 2018/8/7
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean crossDomainFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CrossDomainFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
