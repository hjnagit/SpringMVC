package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	

	private static final Logger log = 
			LoggerFactory.getLogger(SampleController4.class);
	
	
	
	@RequestMapping("/doE")
	public String doE(Model model, RedirectAttributes rttr) {
		log.info("/doE 호출 -> doE() 호출");
		
		
		//return "/doF";
		//return "redirect:/doF?msg=itwill";
		
		//model에 데이터 담아서 보내기
		//model.addAttribute("msg", "busan");
		
		//redirect로 옮길 때만 사용가넝한 것
		rttr.addFlashAttribute("msg", "seoul");
		
		return "redirect:/doF";
		//=>sendRedirect 동작 수행가능( 주소, 화면 모두 변경)
		//return "forward:/doF";
		//=> forward 동작 수행가능(주소 병경x, 화면 변경0)
		
		
		//model.addAttribute
		//=> 전달값이 URI표시 o, F5(새로고침)실행시 데이터 유지o (영구적)
		
		//rttr.addFlashAttribute
		//=> 전달값이 URI표시 x, F5(새로고침)실행시 데이터 유지x (일시적)
		//=> 딱 한번만 사용할 때, 데이터를 계속 보유하지 못하게
		//=> 예를들어 조회수를 계속 올라가지 못하게 하는
		//=> 일회성의 데이터를 만들 때 사용한다
		
		
		
		
		
		
	}
	
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) {
		log.info("/doF 호출");
		log.info("msg : " + msg);
		
		
		
		
		
	}
	
	
	
	
	
}
