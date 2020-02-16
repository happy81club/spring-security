package com.test.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.security.dto.SecurityUserInfo;
import com.test.security.dto.UserInfo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	UserInfoService userService;

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserInfo user = userService.getUserByUsername(userId);
		
		logger.info("******************************** :: " + user.getPassword());
		
		if (user == null){
			System.out.println(userId + " ������ ã�� �� �����ϴ�. ");
			throw new UsernameNotFoundException("������ ã�� �� �����ϴ�.");
		} 
		
		return new SecurityUserInfo(user);
	}

}
