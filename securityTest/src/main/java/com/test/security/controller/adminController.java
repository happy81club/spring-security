package com.test.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.security.service.UserInfoService;

@Secured({"ROLE_ADMIN","ROLE_SUPER"})
@SessionAttributes(value="loginVO")
@Controller
@RequestMapping("/admin")
public class adminController {
	
	@Autowired
	UserInfoService userService;
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		
		return "/admin/main";
	}
	

}
