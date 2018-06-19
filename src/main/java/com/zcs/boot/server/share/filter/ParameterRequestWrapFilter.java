package com.zcs.boot.server.share.filter;

import com.zcs.boot.server.enums.Globals;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: zhengcs
 * @Desc:请求重装过滤器
 * @Date: 2018/6/7 14:42
 * @Modified:
 **/
@WebFilter(urlPatterns = "/*")
@Order(Integer.MIN_VALUE)
public class ParameterRequestWrapFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("过滤器"+((HttpServletRequest) request).getRequestURI());
        ParameterRequestWrapper requestWrap = new ParameterRequestWrapper((HttpServletRequest) request);
        String uuid= UUID.randomUUID().toString();
        requestWrap.addParameter(Globals.CORRELATIONID, uuid);
        MDC.put(Globals.CORRELATIONID, uuid);
        filterChain.doFilter(requestWrap, response);
    }

    @Override
    public void destroy() {

    }
}
