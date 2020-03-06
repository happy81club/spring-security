package com.test.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	//private static int TIME = 60 * 60; // 1시간
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
	private String userId;
    private String defaultUrl;
    
    public LoginSuccessHandler(String defaultUrl) {
    	
    	System.out.println("LoginSuccessHandler >>>>>>> defaultUrl : " + defaultUrl);
    	setDefaultUrl(defaultUrl);
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
    		Authentication authentication) throws IOException, ServletException {
    	// TODO Auto-generated method stub
    	
    	System.out.println("로그인성공 핸들러!!!!!!!!!!!!!!!!!!!!!!!");
    	//request.getSession().setMaxInactiveInterval(TIME);
    	clearAuthenticationAttributes(request, response, authentication); // 에러 세션을 지우는 메서드를 실헹한다.

    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response,
    		Authentication authentication) throws IOException, ServletException {
    	
    	System.out.println("로그인성공 핸들러!!!!!!!!!!!!!!!!!!!!!!!");
    	
    	HttpSession session = request.getSession();
    	if(session != null) {
    		String redirectUrl = (String) session.getAttribute("prevPage");
    		if(redirectUrl != null) {
    			session.removeAttribute("prevPage");
    			resultRedirectStrategy(request, response, authentication );
    		} 
    	} else {
    		return;
    	}
    	
    	/*
        HttpSession session = request.getSession(false); // 세션을 받아온다.
        if(session==null) return; // 세션이 null 즉, 세션에 에러가 없다면 그냥 return 된다.
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION); // WebAttributes.AUTHENTICATION_EXCEPTION 이름 값으로 정의된 세션을 지운다.
    	*/
    }

    
    protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        
        if(savedRequest!=null) {
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStratgy.sendRedirect(request, response, targetUrl);
        } else {
            redirectStratgy.sendRedirect(request, response, defaultUrl);
        }
        
    }


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getDefaultUrl() {
		return defaultUrl;
	}


	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
    
    



}
