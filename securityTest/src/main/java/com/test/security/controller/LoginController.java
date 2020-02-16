package com.test.security.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping(value="/loginProc")
	public String loginProc(Model model, HttpServletRequest req) {
		
		return "loginProc";
	}

	

}
