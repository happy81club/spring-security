package com.test.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SecurityTestApplication  extends SpringBootServletInitializer { 
	//SpringBootServletInitializer�� ��ӹ����ž� ��Ĺ �⵿ �� ���������� ������ ����� �����մϴ�
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityTestApplication.class, args);
	}
    
	// configure�� �������̵� ���ּž� ���� �����̳� �⵿ �� ������ ������ ��������ݴϴ�.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SecurityTestApplication.class);
	}
	
	

}
