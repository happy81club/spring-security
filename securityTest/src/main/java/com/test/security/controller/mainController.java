package com.test.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@RequestMapping(value="/bootstrap")
	public String bootstrap(HttpServletRequest request, Model model) {
		return "bootstrapSample";
	}

}
