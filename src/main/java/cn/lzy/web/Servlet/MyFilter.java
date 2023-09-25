package cn.lzy.web.Servlet;


/**
 * @author 陈远翔
 * @date 2023/9/14 15:44
 */


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*Filter.super.init(filterConfig);*/
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=====hello MyFilter=====");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}