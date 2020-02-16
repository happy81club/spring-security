package com.test.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.security.dto.UserInfo;
import com.test.security.service.UserInfoService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	@Autowired
	UserInfoService userService;
	
	@RequestMapping(value="/join")
	public String join(@ModelAttribute UserInfo userInfo, Model model) {
		

		
		return "member_join";
	}

	@RequestMapping(value="/memberJoinProc")
	public String memberJoinProc(@ModelAttribute UserInfo userInfo, Model model) throws Exception {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

		userService.insertUserInfo(userInfo);
		
		return "login";
	}
}
