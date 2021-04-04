package com.keepcoding.zuulapigatewayservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoginFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulLoginFilter.class);
    @Override
    public String filterType() {
        return "pre"; // toda peticion pasa por aqui primero con el pre
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException { // codigo que quieres que se ejecute cada vez que se aplique este filtro sobre cada una de las peticiones
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        LOGGER.info("request -> {} request uri -> {}", request, request.getRequestURI());
        return null;
    }
}
