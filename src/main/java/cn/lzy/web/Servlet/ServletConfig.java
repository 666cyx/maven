package cn.lzy.web.Servlet;


/**
 * @author 陈远翔
 * @date 2023/9/14 15:43
 */
/*import cn.lzy.Servlet.MyListener;
import cn.lzy.Servlet.MyServlet;*/
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(myServlet,"/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilter(MyFilter filter){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setUrlPatterns(Arrays.asList("/toLoginPage","/myFilter"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean getServletListener(MyListener myListener){
        ServletListenerRegistrationBean registrationBean =
                new ServletListenerRegistrationBean(myListener);
        return registrationBean;
    }



}
