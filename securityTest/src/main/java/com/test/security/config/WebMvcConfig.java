package com.test.security.config;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.test.security.interceptor.HttpInterceptor;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
//	@Autowired 
//	@Qualifier(value = "httpInterceptor") 
//	private HandlerInterceptor interceptor; 
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		logger.info("addInterceptors ****************");
		
	    List<String> URL_PATTERNS = Arrays.asList("/user/**", "/admin/**");
		
//		registry.addInterceptor(interceptor)
		registry.addInterceptor(new HttpInterceptor()) //������� ���ͼ���
		        .addPathPatterns(URL_PATTERNS)    // �̷������� �迭�� ����
		        .excludePathPatterns("/css/**")   // 1���� �߰��� ����
		        .excludePathPatterns("/fonts/**")
		        .excludePathPatterns("/js/**")
		        .excludePathPatterns("/login")
		        .excludePathPatterns("/member/**")
		        ;
	}

}
