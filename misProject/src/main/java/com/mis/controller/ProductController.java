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
	 * ��ǰ ���
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
		pageMaker.setTotalCount(service.listSearchCount(cri)); // pageMaker�� �̿��Ͽ� ������ ����� ���� ���

		model.addAttribute("pageMaker", pageMaker); // �信�� pageMaker�� ����ϱ� ���ؼ�
	}

	/**
	 * ��ǰ ��
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
	 * ��ǰ ����
	 * @param prodcod
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("prodcod") int prodcod, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(prodcod);

		// ���� ������ �������ؼ�
		rttr.addAttribute("page", cri.getPage());//��������ȣ
		rttr.addAttribute("perPageNum", cri.getPerPageNum());//������ ������ ��
		rttr.addAttribute("searchType", cri.getSearchType());// �˻�Ÿ��
		rttr.addAttribute("keyword", cri.getKeyword());// Ű����

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/shop/list";
	}

	
	/**
	 * ��ǰ ����
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
	 * ��ǰ ����
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
	 * ��ǰ ���
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.info("register get..............");
	}

	/**
	 * ��ǰ ���
	 * @param Product
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ProductVO Product, RedirectAttributes rttr) throws Exception {
		logger.info("register post.............");
		logger.info(Product.toString());

		service.regist(Product);// db�� ���

		rttr.addFlashAttribute("msg", "SUCCESS"); // â �߰���
		return "redirect:/shop/list";
	}
}
