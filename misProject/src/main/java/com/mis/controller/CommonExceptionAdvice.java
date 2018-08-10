package com.mis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // Exception�� ���������� ó���ϴ� Ŭ������� ���� ���
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
//	/**
//	 * Exception Ÿ������ ó���Ǵ� ��� ���ܸ� ó���ϴ� �޼ҵ�
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
	 * ����������  ModelAndView �� ��ü�� �����ϰ� ��ȯȭ�� �޼ҵ�
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
