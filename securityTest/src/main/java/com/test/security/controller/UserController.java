package com.test.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.security.dto.UserInfo;
import com.test.security.service.UserInfoService;

@Secured({"ROLE_USER","ROLE_ADMIN","ROLE_SUPER"})
@SessionAttributes(value="loginVO")
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserInfoService userService;
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		
		return "/user/main";
	}
	
	@RequestMapping(value="/loginProc")
	public String loginProc(Principal principal, Model model) {
		
		String userId = principal.getName();
		
		UserInfo user = userService.getUserByUsername(userId);
		model.addAttribute("loginVO", user);
		
		return "redirect:/user/main";
	}


}
