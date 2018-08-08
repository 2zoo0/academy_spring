package com.mis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");

		if (userVO != null) {

			logger.info("새로운 로그인 성공");
			session.setAttribute(LOGIN, userVO); // 세션에 userVO 형태로 담겨진 로그인정보를 세션에 저장
			// response.sendRedirect("/");
			
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String)dest:"/");

		}
	}
	
	/**
	 * HttpSession에 정보가 남아있는경우 정보를 삭제함
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public boolean preHandle(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN); // 세션 에서 remove
			
		}
		
		return true;
	}
}
