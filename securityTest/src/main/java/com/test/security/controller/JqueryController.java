package com.test.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.security.dto.UserInfo;

@Controller
@RequestMapping("/jquery")
public class JqueryController {
	
	@RequestMapping(value="/chapter1")
	public String chapter1(Model model) {
		
		return "/jquery/chapter1";
	}

	@RequestMapping(value="/chapter2")
	public String chapter2(Model model) {
		
		return "/jquery/chapter2";
	}
	
	@RequestMapping(value="/chapter3")
	public String chapter3(Model model) {
		
		return "/jquery/chapter3";
	}

}
