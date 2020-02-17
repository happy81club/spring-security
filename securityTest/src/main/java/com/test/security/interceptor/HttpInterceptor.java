package com.test.security.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.test.security.dto.Role;
import com.test.security.dto.UserInfo;

@Component
public class HttpInterceptor extends HandlerInterceptorAdapter implements SessionNames{
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public boolean preHandle(HttpServletRequest request, 
			                 HttpServletResponse response, 
			                 Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		String query = request.getQueryString();

		logger.info("preHandle................................" + uri );
		
		HttpSession session = request.getSession();
		
		if("/user/loginProc".equals(uri)) {
			if(session.getAttribute(LOGIN) != null) {
				session.removeAttribute(LOGIN);
			}
			
		} else {
			if(session.getAttribute(LOGIN) == null) {
				/*
				logger.info("session Login is null...........");
				logger.info("uri>>" + uri + "?" + query );
				
				if(!StringUtils.isEmpty(query)) {
					uri += "?" + query;
					session.setAttribute(ATTEMPTED, uri);
				}
				 */
				response.sendRedirect("/login");
			}
		}
        
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("postHandle................................");
		
		HttpSession session = request.getSession();
		
		logger.info("modelAndView.getViewName() :: " + modelAndView.getViewName());
		
		Object userInfo = modelAndView.getModelMap().get("loginVO");

		logger.info("user :: " + userInfo);
		
		if(userInfo != null) {
			session.setAttribute(LOGIN, userInfo);
			
			logger.info("Cookie setting ................................" + session.getId());
			Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
			loginCookie.setPath("/"); // naver.com/도메인별로 생김.
			loginCookie.setMaxAge(7 * 24 * 60 * 60);
			
			response.addCookie(loginCookie);
		}
		
		logger.info("modelAndView.getView() >>>" + modelAndView.getView());
		logger.info("modelAndView.getViewName() >>>" + modelAndView.getViewName());
		
		
		// 권한체크
		if(null != session.getAttribute(LOGIN)) {
			UserInfo loginVO = (UserInfo)session.getAttribute(LOGIN);
			
			// 관리자
			if(modelAndView.getViewName().indexOf("/admin/") > -1 && Role.ROLE_ADMIN != loginVO.getRole()) {
                ModelAndView mav = new ModelAndView("redirect:/main");
                mav.addObject("msgCode", "권한이 없습니다.");
                //mav.addObject("returnUrl", "/index.do");
                throw new ModelAndViewDefiningException(mav);
			}
			
		}
		
		/*
		if(session.getAttribute(LOGIN) != null) {
			String attempted = (String)session.getAttribute(ATTEMPTED);
			if(!StringUtils.isEmpty(attempted)) {
				response.sendRedirect(attempted);
				session.removeAttribute(ATTEMPTED);
			}
		}
		 */
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("afterCompletion................................");
	}
	

}
