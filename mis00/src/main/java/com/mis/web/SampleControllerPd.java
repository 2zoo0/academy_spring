package com.mis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.domein.ProductVO;

@Controller
public class SampleControllerPd {

	private static final Logger logger = LoggerFactory.getLogger(SampleControllerPd.class);
		
	@RequestMapping("doPD")
	public String doPD(Model model) {
		ProductVO vo = new ProductVO("청바지", 10000, 100, 20);
		logger.info("doPD 불렀당~~~~~~");
		
		model.addAttribute("product", vo);
		System.out.println(vo.toString());
		return "productDetail2";
	}
	
	@RequestMapping("/doPD2")
	public @ResponseBody ProductVO doPD2() {
		logger.info("doPD2 불렀당~~~~~~");
		ProductVO vo = new ProductVO("청바지", 10000, 100, 20);
		
		return vo;
	}
	
	
}
