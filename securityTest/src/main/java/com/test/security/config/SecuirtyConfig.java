package com.test.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.test.security.handler.LoginSuccessHandler;
import com.test.security.service.CustomUserDetailsService;

@Configuration 
public class SecuirtyConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	

	/* 요청 가로채기
	 * 다른 URL 패스들에 대해 선택적으로 보안을 적용하기 위한
	 *  configure(HttpSecurity)의 오버라이딩
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
			http.authorizeRequests()
			    .antMatchers("/**").permitAll()
				.antMatchers("/user/**")
				.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
				.antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
				.antMatchers("/super/**")
				.access("hasRole('ROLE_SUPER')")
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/loginProcess")
				//.successHandler(authenticationSuccessHandler())
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/user/loginProc") 
				.and()
				.logout() /* 로그아웃 */
				.logoutUrl("/logout")
				.invalidateHttpSession(true) /* 로그아웃 세션 제거 */
				.deleteCookies("JSESSIONID") /* 쿠키 제거*/
				.clearAuthentication(true)   /* 권한정보 제거*/
				.logoutSuccessUrl("/login")  /* 로그아웃 성공시 이동 URL */
     			//.permitAll()
				.and().sessionManagement()
				.maximumSessions(1)   /* session 허용갯수 */
				.expiredUrl("/login") /* session 만료시 이동 페이지*/
				.maxSessionsPreventsLogin(false); /* true 동일한 사용자 로그인 시 안됨, false 일 경우 기존사용자 세션종료 */
			
	}
	
	@Bean
	AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new LoginSuccessHandler("/login");
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

