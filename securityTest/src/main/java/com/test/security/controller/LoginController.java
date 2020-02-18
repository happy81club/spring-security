package com.test.security.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import com.test.security.interceptor.SessionNames;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	

	
	@RequestMapping(value="/")
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("loginVO") != null) {
			return "redirect:/user/main";
		}
		
		return "redirect:/login";
	}
   
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		
		SecurityContextHolder.clearContext();
		if(session != null)
			session.invalidate();

/*
		if(session.getAttribute("loginVO") != null) {
			return "redirect:/logout";
		}
*/		
		
		
		return "login";
	}


	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, 
			SessionStatus status, HttpSession session) throws Exception {
		
		// 세션삭제
		session.removeAttribute(SessionNames.LOGIN);
		session.invalidate();
		// 쿠키삭제
		Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN);
		if(loginCookie != null) {
			loginCookie.setPath("/"); // 도메인별로 생김.
			loginCookie.setMaxAge(0);
			
			response.addCookie(loginCookie);
		}
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// SessionStatus는 스프링의 어노테이션으로 지원되는 @SessionAttributes의 세션을 만료시킨다.
		status.isComplete();
		if(status.isComplete() == true) {
			logger.info("세션만료!!!!!!!!!!!!!!!!");
		}
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		} 
		
		return "redirect:login";
	}

	

}
