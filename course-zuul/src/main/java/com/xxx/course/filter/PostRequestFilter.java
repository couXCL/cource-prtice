package com.xxx.course.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求后的过滤器，记录请求后的时间
 */
@Component
public class PostRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //路由请求后运行过滤器
        return FilterConstants.POST_TYPE;
    }
    @Override
    public int filterOrder() {
        //过滤器的顺序为响应之后，减1意味着在SEND_RESPONSE_FILTER_ORDER之前一点点运行
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //设置为true使过滤器生效
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        //通过上下文获取上面那个过滤器存储的内容
        Long startTime = (Long)currentContext.get("startTime");
        long duration = System.currentTimeMillis() - startTime;
        String requestURI = currentContext.getRequest().getRequestURI();
        System.out.println("uri为:"+requestURI+" 处理时长为："+duration+"ms");
        return null;
    }
}
