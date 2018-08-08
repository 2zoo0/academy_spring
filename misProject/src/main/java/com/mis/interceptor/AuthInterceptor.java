package com.mis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 
 * @author PC38208
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute("login") == null) {
			logger.info("현재 로그인 된 상태가 아닙니다.");
			saveDest(request);
			
			response.sendRedirect("/user/login");
			return false;
		}

		return true;
	}
	
	
	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		
		String query = req.getQueryString();
		
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if (req.getMethod().equals("GET")) {
			logger.info("dest : " + (uri + query));
			req.getSession().setAttribute("dest", uri + query);
			
		} else if (req.getMethod().equals("POST")) {
			req.getSession().setAttribute("dest", "/");
		}
	}

}
