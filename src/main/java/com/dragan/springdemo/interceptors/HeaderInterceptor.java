package com.dragan.springdemo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Service
public class HeaderInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
	request.setAttribute("greeting", "Pozdrav dobri covece!");
	String location = request.getParameter("locationName");
	if (location != null) {
	    request.setAttribute("locationName", location);
	}
	return true;
    }

}
