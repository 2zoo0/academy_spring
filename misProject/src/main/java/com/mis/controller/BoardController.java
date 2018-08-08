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

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.PageMaker;
import com.mis.service.BoardService;

@Controller
@RequestMapping("/board/*") // 공통 경로 설정
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject // BoardService 객체를 갖다 쓸 수 있음 
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET) // method 는 전송방식
	public void registerGET(BoardVO board, Model model) throws Exception {
		
		logger.info("register 겟!!!!");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST) 
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		
		logger.info("register 포스트!!!!");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "SUCCESS"); // result라는 값으로 success를 처리
		
		/*return "/board/success";*/
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		
		logger.info("모든 목록 보여라!");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		
		logger.info("상세보기 보여라!");
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST) 
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		
		service.remove(bno); // 삭
		
		rttr.addFlashAttribute("msg", "SUCCESS"); // result라는 값으로 success를 처리
		
		//return "/board/success";
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST) 
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		
		logger.info("modify 포스트!!!!");
		
		service.modify(board);// 수
		
		rttr.addFlashAttribute("msg", "SUCCESS"); // result라는 값으로 success를 처리
		
		//return "/board/success";
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		
		logger.info("모든 목록 보여라!");
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	
	
	@RequestMapping(value = "/removePage", method = RequestMethod.POST) 
	public String remove(@RequestParam("bno") int bno, @ModelAttribute("cri")Criteria cri, RedirectAttributes rttr) throws Exception {
		
		service.remove(bno); // 삭
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS"); // result라는 값으로 success를 처리
		
		//return "/board/success";
		return "redirect:/board/listPage";
		
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int bno, @ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(BoardVO board, /*@ModelAttribute("cri")*/Criteria cri, RedirectAttributes rttr) throws Exception {
		
		service.modify(board); // 삭
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
	
}
