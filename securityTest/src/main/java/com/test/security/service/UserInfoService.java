package com.test.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.security.dto.UserInfo;
import com.test.security.mapper.UserInfoMapper;

@Service
public class UserInfoService {
	
	@Autowired
	UserInfoMapper mapper;
	
	public UserInfo getUserByUsername(String userId) {
		return mapper.getUserByUserInfo(userId);
	}

	public int insertUserInfo(UserInfo userInfo) throws Exception {
		return mapper.insertUserInfo(userInfo);
	}
}
