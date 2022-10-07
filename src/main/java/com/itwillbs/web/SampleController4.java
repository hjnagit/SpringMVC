package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController4 {
	

	private static final Logger log = 
			LoggerFactory.getLogger(SampleController4.class);
	
	
	
	@RequestMapping("/doE")
	public String doE() {
		log.info("/doE 호출 -> doE() 호출");
		
		
		//return "/doF";
		//return "redirect:/doF";
		//=>sendRedirect 동작 수행가능( 주소, 화면 모두 변경)
		return "forward:/doF";
		//=> forward 동작 수행가능(주소 병경x, 화면 변경0)
	}
	
	
	@RequestMapping("/doF")
	public void doF() {
		log.info("/doF 호출");
	}
	
	
	
	
	
}
