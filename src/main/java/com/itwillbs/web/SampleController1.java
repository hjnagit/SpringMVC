package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//컨트롤러를 만들때 상속해서 메서드를 구현하지 않고
//@Controller를 쓰는 것으로 끝

//@Controller : 해당 클래스를 컨트롤러로 처리하겠다는 것 - 스프링에 등록

@Controller
public class SampleController1 {
	
	

	private static final Logger log = 
			LoggerFactory.getLogger(SampleController1.class);
	
	
	//doA라는 주소가 호출되면 doA를 실행해라는 뜻
	//@RequestMapping("/doA")
	//@GetMapping("/doA")
	//=> 특정 주소에 특정방식으로 호출 될 때 실행하는 메서드 연결
	@RequestMapping(value="/doA", method = RequestMethod.GET)
	public void doA() {
		
		log.info("/doA 주소 호출, doA() 실행");
		
	}
	
	
	
	//@RequestMapping("/doB")
	@RequestMapping("/doB1")
	public void doB() {
		log.info("/doB 주소 호출 -> doB.jsp 페이지 호출");
		
	}
	
	//=> 메서드의 리턴타입이 void일 때,
	// 호출되는 주소를 사용해서 뷰를 연결
	// /views/주소.jsp 페이지 연결 자동 호출
	
	
	
	
}
