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
	
	//private static int TIME = 60 * 60; // 1�ð�
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
    	
    	System.out.println("�α��μ��� �ڵ鷯!!!!!!!!!!!!!!!!!!!!!!!");
    	//request.getSession().setMaxInactiveInterval(TIME);
    	clearAuthenticationAttributes(request, response, authentication); // ���� ������ ����� �޼��带 �����Ѵ�.

    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response,
    		Authentication authentication) throws IOException, ServletException {
    	
    	System.out.println("�α��μ��� �ڵ鷯!!!!!!!!!!!!!!!!!!!!!!!");
    	
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
        HttpSession session = request.getSession(false); // ������ �޾ƿ´�.
        if(session==null) return; // ������ null ��, ���ǿ� ������ ���ٸ� �׳� return �ȴ�.
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION); // WebAttributes.AUTHENTICATION_EXCEPTION �̸� ������ ���ǵ� ������ �����.
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
