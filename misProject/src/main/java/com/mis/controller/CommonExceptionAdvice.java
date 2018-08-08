package com.mis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // Exception을 전문적으로 처리하는 클래스라는 것을 명시
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
//	/**
//	 * Exception 타입으로 처리되는 모든 예외를 처리하는 메소드
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(Exception.class) 
//	public String common(Exception e) {
//		
//		logger.info(e.toString());
//		
//		
//		return "error_common";
//	}
	
	/**
	 * 내부적으로  ModelAndView 의 객체를 생성하고 반환화는 메소드
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class) 
	private ModelAndView errorModelAndView(Exception ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", ex);
		logger.info(ex.toString());
		
		
		return modelAndView;
	}
}
