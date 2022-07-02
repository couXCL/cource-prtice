package com.xxx.course.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 记录请求的时间
 */
@Component
public class PreRequestFilter extends ZuulFilter {//继承ZuulFilter类，实现其中的方法

    //设置过滤器的类型
    @Override
    public String filterType() {
        //设置过滤器的类型为PRE_TYPE
        return FilterConstants.PRE_TYPE;
    }
    //设置过滤器的顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //是否用过滤器
    @Override
    public boolean shouldFilter() {
        //可添加一些信息，比如说判断url是不是自己想要过滤的url，根据自己的业务逻辑返回true或false
        return true;//返回true代表启用过滤器
    }
    //业务想要实现和添加的内容
    @Override
    public Object run() throws ZuulException {
        //com.netflix.zuul.context.RequestContext中的RequestContext上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.set("startTime",System.currentTimeMillis());
        System.out.println("过滤器已经记录时间");
        return null;
    }
}
