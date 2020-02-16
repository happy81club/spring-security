package com.test.security.dto;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUserInfo extends User {

	private static final long serialVersionUID = -3411289937326709838L;

	public SecurityUserInfo(UserInfo userInfo) {
		super(userInfo.getUserId(), userInfo.getPassword(), AuthorityUtils.createAuthorityList(userInfo.getRole().toString()));
		// TODO Auto-generated constructor stub
	}
	

}
