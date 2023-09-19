package cn.lzy.web.functionextensionmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 陈远翔
 * @date 2023/9/12 10:31
 */
@Configuration
public class MyMVCconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/toLoginPage1").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

    }
    @Autowired
    Mylnterceptor mylnterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mylnterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html");
    }
}
