package com.cocky.springmvc.config;

import com.cocky.springmvc.domain.CustomMessageConverter;
import com.cocky.springmvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@ComponentScan("com.cocky.springmvc")
@EnableWebMvc //开启WebMvc支持
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(1000000);
        return multipartResolver;
    }

    /**
     * 增加自定义的HttpMessageConverter
     * @return
     */
    @Bean
    public CustomMessageConverter converters() {
        return new CustomMessageConverter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**") /*对外暴露的访问路径*/ .addResourceLocations("classpath:/assets/") /*文件放置的目录*/;
        super.addResourceHandlers(registry);
    }

    /**
     * 重写addInteceptors方法，注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 添加自定义HttpMessageConverter
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converters());
    }

    /**
     * 添加页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
    }

    @Bean  //配置拦截器的Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    //设置不忽略路径参数.后的值 http://localhost:8080/advice.xx 默认情况xx会被忽略
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

}
