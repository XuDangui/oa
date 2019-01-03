package com.xws.oa.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DomainFilter implements Filter{
	
	@Value("${Access-Control-Allow-Origin}")// 这里的冒号加与不加感觉没区别  
    String[] originProperties; // 这里竟然可以直接以数组接收以逗号分隔的多个属性  

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
  
        String curOrigin = httpRequest.getHeader("Origin");
        if(curOrigin!=null)
        //System.out.println("当前访问来源是："+curOrigin);  
        // 如果当前访问来源在application.properties的Access-Control-Allow-Origin配置范围内，则允许访问，否则不允许  
        if(curOrigin != null) {  
            for (int i = 0; i < originProperties.length; i++) {  
                //System.out.println("允许跨域访问的来源是："+originProperties[i]);  
                if(curOrigin.equals(originProperties[i])) {  
                    httpResponse.setHeader("Access-Control-Allow-Origin", curOrigin); 
                    httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
                    httpResponse.setHeader("Access-Control-Allow-Methods", "*");
                    httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
                    httpResponse.setHeader("Access-Control-Expose-Headers", "*");
                    httpResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
                    httpResponse.setContentType("text/html");
                    httpResponse.setCharacterEncoding("utf-8");
                }  
            }  
        } else { // 对于无来源的请求(比如在浏览器地址栏直接输入请求的)，那就只允许我们自己的机器可以吧  
            httpResponse.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1");  
        }  
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT,HEAD");  
        // 请求来自哪个域，我就允许哪个域的来源，也就是说允许所有域访问服务，这也太不安全了  
        //if(httpRequest.getHeader("Origin") != null){  
        //  httpResponse.setHeader("Access-Control-Allow-Origin", curOrigin);  
        //}  
          
        // 这句千万别忘，让Filter按默认方式处理请求和响应，如果没写，那么response里没有body  
        chain.doFilter(request, response);  
    } 

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
