package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/itwill/*") /itwill/* 주소가 왔을 때 SampleController2으로 연결한다는 의미
//@RequestMapping("/itwill/*") -> 각각의 컨트롤러 구분 가능


@Controller
//@RequestMapping("/itwill/*")
public class SampleController2 {
	

	private static final Logger log = 
			LoggerFactory.getLogger(SampleController2.class);
	
	
	//저렇게 설정하고
	//http://localhost:8088/web/doC 라고 부르면 에러
	//http://localhost:8088/web/itwill/doC 로 실행해야 한다
	
	//http://localhost:8088/web/doC?msg=busan ->이렇게 정보 전달
	
	//@ModelAttribute("파라메타이름")
	//=> 페이지 요청시 전달되는 파라미터 이름의 정보를 사용해서 문자열 변수에 저장
	
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		
		log.info("doC() 실행");
		log.info("msg : " + msg);
		
		return "itwill";
	}
	//=> 메서드의 리턴타입이 String 일 때,
	// 리턴되는 문자열.jsp 페이즈를 호출(자동 연결)
	
	
//	@RequestMapping("/doC1")
//	public int doC1() {
//		
//		log.info("doC() 실행");
//		
//		return 1;
//	}
	
	
	
	// /doC1 주소를 호출해서 doA.jsp페이지에 정보 출력
	// 호출 /doC1?name=itwill&tel=0518030909
	@RequestMapping("/doC1")
	public String doC1(@ModelAttribute("name") String name, 
			@ModelAttribute("tel") String tel) {
		log.info("doC1() 실행");
		
		return "doA";
	}
	
	
	
	
}
