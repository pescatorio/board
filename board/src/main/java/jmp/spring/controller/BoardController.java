package jmp.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {

	@Autowired
	BoardService service;
	
	@GetMapping("/board/register")
	public void insert() {
		log.info("==========insert() ");
	}
	
	//등록(모델로 보내기)
	@PostMapping("/board/register")
	public String insertExe(BoardVo vo, RedirectAttributes rttr) {
		log.info("========================================================="+vo);
		int res = service.insertBoard(vo);
		log.info("========================================================"+vo);
		
		rttr.addFlashAttribute("resMsg", vo.getBno()+"번 게시글이 등록 되었습니다.");
		return "redirect:/board/list";
	}
	
	//리스트 
	@GetMapping("/board/list")
	public void getList(Model model) {
		model.addAttribute("list",service.getList());
		log.info("getList()================");
	}
	//정보 확인
	@GetMapping({"/board/get" , "/board/update"})
	public void get(BoardVo vo, RedirectAttributes rttr) {
		//상세정보 조회
		vo=service.get(vo.getBno());
		log.info("getList()================");
	}
	
	@PostMapping("/board/update")
	public String postUpdate(BoardVo vo, Model model) {
		vo = service.get(vo.getBno());
		model.addAttribute("vo",vo);
		log.info(vo);
		return "redirect:/board/get";
	}
	
	
	/*
	 * @GetMapping("/board/titleboard") public void titleMapping(Model model) {
	 * model.addAttribute("list",service.getList());
	 * redirectedUrl("/board/titleboard"); } //서비스로부터 받아온 데이터를 화면으로 보내줄때
	 * 
	 * @GetMapping("/board/titleregister") public void titleregister(Model model) {
	 * model.addAttribute("list",service.getList()); }
	 * 
	 * //화면으로부터 전달받은 파라미터를 vo로 전달
	 * 
	 * @PostMapping("/board/titleregister") public String titleregisterExe(BoardVo
	 * vo) { return "redirect:/board/list"; }
	 */
}
