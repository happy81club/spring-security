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
	

	/* ��û ����ä��
	 * �ٸ� URL �н��鿡 ���� ���������� ������ �����ϱ� ����
	 *  configure(HttpSecurity)�� �������̵�
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
				.logout() /* �α׾ƿ� */
				.logoutUrl("/logout")
				.invalidateHttpSession(true) /* �α׾ƿ� ���� ���� */
				.deleteCookies("JSESSIONID") /* ��Ű ����*/
				.clearAuthentication(true)   /* �������� ����*/
				.logoutSuccessUrl("/login")  /* �α׾ƿ� ������ �̵� URL */
     			//.permitAll()
				.and().sessionManagement()
				.maximumSessions(1)   /* session ��밹�� */
				.expiredUrl("/login") /* session ����� �̵� ������*/
				.maxSessionsPreventsLogin(false); /* true ������ ����� �α��� �� �ȵ�, false �� ��� ��������� �������� */
			
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
		/* ���⼭, noop�� Spring Security���� �ؽ�Ʈ �״�� ��й�ȣ�� �ν��ϰ� ���ش�.
			noop�� ������ ������ �ٸ� ���ڵ����� ��ȣȭ�� �� �־�� �Ѵ�.*/
	}
	
	

}

