package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author yangcheng
 * @version 1.0
 * @date 2021-07-11 23:21
 * @description
 */
public class ProxyRequestFilter  implements HttpRequestFilter  {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        //获取url
        String uri = fullRequest.uri();
        System.out.println("当前请求的"+uri);
        //设置过滤规则
        //例如 只有anxing 开头的请求才能通过
        if(!uri.startsWith("anxing")){
            throw new RuntimeException("不支持的请求，请重试");
        }else{
            //解析请求并调用
            //之前做过一次通过反射调用指定的类
            //纯路由功能可以调用okhttp或者httpclient来远程调用请求
        }


    }
}
