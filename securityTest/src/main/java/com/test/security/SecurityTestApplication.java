package com.test.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SecurityTestApplication  extends SpringBootServletInitializer { 
	//SpringBootServletInitializer를 상속받으셔야 톰캣 기동 시 정상적으로 스프링 모듈이 동작합니다
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityTestApplication.class, args);
	}
    
	// configure를 오버라이드 해주셔야 서블릿 컨테이너 기동 시 스프링 설정을 적용시켜줍니다.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SecurityTestApplication.class);
	}
	
	

}
