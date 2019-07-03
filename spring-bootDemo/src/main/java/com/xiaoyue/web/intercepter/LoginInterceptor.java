package com.xiaoyue.web.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoyue.web.model.User;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    private static String [] IGNORE_URL= {"/loginPage","/login"};
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	    throws Exception {
	
	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	    ModelAndView modelAndView) throws Exception {
	
	HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
	boolean flag=false;
	System.out.println("拦截了请求");
	HttpSession session = request.getSession();
	String contextPath = request.getContextPath();
	for (String s : IGNORE_URL) {
	    if(contextPath.contains(s)) {
		flag=true;
		break;
	    }
	}
	if (!flag) {
	    User user = (User) session.getAttribute("user");
	    if(user==null) {
		request.getRequestDispatcher("loginPage").forward(request, response);
	    }else {
		flag=true;
	    }
	}
	return flag;
    }

  
    
}
