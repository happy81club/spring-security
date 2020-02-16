package com.test.security.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.test.security.dto.UserInfo;

@MapperScan
public interface UserInfoMapper {
	public UserInfo getUserByUserInfo(String userId);
	public int insertUserInfo(UserInfo userInfo) throws Exception;
}
