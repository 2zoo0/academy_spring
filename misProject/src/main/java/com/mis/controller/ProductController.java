package com.mis.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.ProductVO;
import com.mis.domain.PageMaker;
import com.mis.domain.SearchCriteria;
import com.mis.service.ProductService;

@Controller
@RequestMapping("/shop/")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private ProductService service;

	/**
	 * 제품 목록
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());

		model.addAttribute("list", service.searchListCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri)); // pageMaker를 이용하여 페이지 목록의 수를 계산

		model.addAttribute("pageMaker", pageMaker); // 뷰에서 pageMaker를 사용하기 위해서
	}

	/**
	 * 제품 상세
	 * @param prodcod
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("prodcod") int prodcod, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(service.read(prodcod));
	}

	/**
	 * 제품 삭제
	 * @param prodcod
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("prodcod") int prodcod, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(prodcod);

		// 보던 곳으로 가기위해서
		rttr.addAttribute("page", cri.getPage());//페이지번호
		rttr.addAttribute("perPageNum", cri.getPerPageNum());//페이지 데이터 수
		rttr.addAttribute("searchType", cri.getSearchType());// 검색타입
		rttr.addAttribute("keyword", cri.getKeyword());// 키워드

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/shop/list";
	}

	
	/**
	 * 제품 수정
	 * @param prodcod
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPagingGET(int prodcod, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute(service.read(prodcod));
	}

	/**
	 * 제품 수정
	 * @param Product
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagingPOST(ProductVO Product, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(cri.toString());
		service.modify(Product);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/shop/list";
	}

	/**
	 * 제품 등록
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.info("register get..............");
	}

	/**
	 * 제품 등록
	 * @param Product
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ProductVO Product, RedirectAttributes rttr) throws Exception {
		logger.info("register post.............");
		logger.info(Product.toString());

		service.regist(Product);// db에 등록

		rttr.addFlashAttribute("msg", "SUCCESS"); // 창 뜨게함
		return "redirect:/shop/list";
	}
}
