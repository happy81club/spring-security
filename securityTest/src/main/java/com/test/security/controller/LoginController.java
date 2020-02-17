package com.test.security.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import com.test.security.dto.UserInfo;
import com.test.security.interceptor.SessionNames;
import com.test.security.service.UserInfoService;


@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	

	
	@RequestMapping(value="/")
	public String home(Principal principal, Model model) {
		
		return "login";
	}
   
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest req) {
		
		return "login";
	}


	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, 
			SessionStatus status, HttpSession session) throws Exception {
		
		// ���ǻ���
		session.removeAttribute(SessionNames.LOGIN);
		session.invalidate();
		// ��Ű����
		Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN);
		if(loginCookie != null) {
			loginCookie.setPath("/"); // �����κ��� ����.
			loginCookie.setMaxAge(0);
			
			response.addCookie(loginCookie);
		}
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// SessionStatus�� �������� ������̼����� �����Ǵ� @SessionAttributes�� ������ �����Ų��.
		status.isComplete();
		if(status.isComplete() == true) {
			logger.info("���Ǹ���!!!!!!!!!!!!!!!!");
		}
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		} 
		
		return "redirect:login";
	}

	

}
