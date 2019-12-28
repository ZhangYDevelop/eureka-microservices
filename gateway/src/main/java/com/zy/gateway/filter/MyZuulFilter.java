package com.zy.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @AUTHOR zhangy
 * 2019-12-25  21:03
 */
//@Component
public class MyZuulFilter extends ZuulFilter {

    private static final  String  loginUrl = "/api/oauth/login";
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if (loginUrl.equals(request.getRequestURI())) {
             return  false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader("Authorization", "barere" + (String) context.getRequest().getSession().getAttribute("access_token"));
        return null;
    }
}
