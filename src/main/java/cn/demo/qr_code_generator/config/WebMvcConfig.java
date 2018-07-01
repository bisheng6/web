package cn.demo.qr_code_generator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport
{
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        super.addResourceHandlers(registry);
        // TODO: 2018/6/29 打包成jar包时需要修改绝对路径
        //                                          访问的前缀                               文件的绝对路径
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/Learn/Document/Document/Web工程/upload");
        registry.addResourceHandler("**").addResourceLocations("/src/main/resources/static");
    }
}
