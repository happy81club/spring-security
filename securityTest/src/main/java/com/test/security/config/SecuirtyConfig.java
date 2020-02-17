package com.test.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.security.service.CustomUserDetailsService;

@Configuration 
public class SecuirtyConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;;
	
	/* 요청 가로채기
	 * 다른 URL 패스들에 대해 선택적으로 보안을 적용하기 위한
	 *  configure(HttpSecurity)의 오버라이딩
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
			http.authorizeRequests()
				.antMatchers("/user/**")
				.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
				.antMatchers("/super/**").access("hasRole('ROLE_SUPER')")
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/loginProcess")
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/user/loginProc") 				
				.and()
				.logout() /* 로그아웃 */
				.logoutUrl("/logout").permitAll()
				.logoutSuccessUrl("/login");  /* 로그아웃 성공시 이동 URL */
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		  return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		//auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(customUserDetailsService);
				
		//auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("USER");
		/* 여기서, noop는 Spring Security에서 텍스트 그대로 비밀번호를 인식하게 해준다.
			noop을 붙이지 않으면 다른 인코딩으로 암호화를 해 주어야 한다.*/
	}
	
	

}

/*
 * https://m.blog.naver.com/kimnx9006/220638156019
 * 
 * authenticated() 메소드는 애플리케이션에 로그인된 사용자가 요청을 수행할 떄 필요하다. 
 * 만약 사용자가 인증되지 않았다면, 스프링 시큐리티 필터는 요청을 잡아내고 사용자를 로그인 페이지로 리다이렉션 해준다.
 * permitAll() 메소드는 어떠한 보안 요구 없이 요청을 허용해준다.
 * 
 *   access(String)
 	 - 주어진 SpEL 표현식의 평가 결과가 true이면 접근을 허용
     anonymous()
     - 익명의 사용자의 접근을 허용
     authenticated()
     - 인증된 사용자의 접근을 허용
 	 denyAll()
 	 - 무조건 접근을 허용하지 않음
	 fullyAuthenticated()
	 - 사용자가 완전히 인증되면 접근을 허용(기억되지 않음)
	 hasAnyAuthority(String...)
	 - 사용자가 주어진 권한 중 어떤 것이라도 있다면 접근을 허용
	 hasAnyRole(String...)
	 - 사용자가 주어진 역할 중 어떤 것이라도 있다면 접근을 허용
	 hasAuthority(String)
	 - 사용자가 주어진 권한이 있다면 접근을 허용
	 hasIpAddress(String)
	 - 주어진 IP로부터 요청이 왔다면 접근을 허용
	 hasRole(String)
	 - 사용자가 주어진 역할이 있다면 접근을 허용
	 not()
	 - 다른 접근 방식의 효과를 무효화
	 permitAll()
	 - 무조건 접근을 허용
	 rememberMe()
	 - 기억하기를 통해 인증된 사용자의 접근을 허용
 * */
