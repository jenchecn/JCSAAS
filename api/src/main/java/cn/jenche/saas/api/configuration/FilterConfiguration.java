package cn.jenche.saas.api.configuration;

import cn.jenche.saas.api.configuration.filter.PublicFilterHandle;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/19 14:36
 * @Description:
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean PublicAPIFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new PublicFilterHandle());//实例化Filter类
        filterRegistrationBean.addUrlPatterns("/api/*");//设置匹配模式 API路径下的都需要进行筛选器筛选
        filterRegistrationBean.setOrder(1);//设置执行顺序
        return filterRegistrationBean;
    }
}
