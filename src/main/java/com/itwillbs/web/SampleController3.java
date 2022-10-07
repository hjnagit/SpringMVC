package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {
	

	private static final Logger log = LoggerFactory.getLogger(SampleController3.class);
	
	
	//http://localhost:8088/web/doD
	//http://localhost:8088/web/doD?id=admin
	
	@RequestMapping(value="/doD")
	public void doD(@ModelAttribute("id") String id) {
		log.info("/doD 호출 -> doD() 호출 -> views/doD.jsp 호출");
		
		log.info("id : " + id);
	}
	
	// [/doD1]주소 호출 -> test.jsp 페이지에 정보 출력
	// /doD1?email=test@test.com
	@RequestMapping("/doD1")
	public String doD1(@ModelAttribute("email") String email) {
		log.info("/doD1 호출 -> doD1() 호출 -> views/test.jsp 호출");
		log.info("email : " + email);
		
		return "test";
	}
	
	
	// http://localhost:8088/web/doBean?userid=admin&userpw=1234
	// 주소줄에 파라미터를 vo 객체로 사용하면 자동으로 저장한다
	// => MemberVO객체에 포함되는 정보는 자동으로 저장!!!
	
	// pw는 안되고, 이름을 맞춰주면 들어간다
	// /doBean -> test.jsp (MemberVO 객체 전달)
	@RequestMapping("/doBean")
	public String doBeanTest(MemberVO vo, Model model) { //메서드명 아무거나 써도 노상관
		// (MemberVO vo)는 @ModelAttribute 생략형태
		//=> 뷰페이지에서 호출할 이름 x
		//=> 전달하는 객체이름의 첫글자 소문자로 변경해서 이름으로 사용!!!!
		
		
		
		log.info("/doBean 호출 -> doBeanTest() 호출 -> views/test.jsp 호출");
		log.info("vo : " + vo);
		
		
		// /doBean 호출 했을 때
		// 디비 sql 결과로 만들어진 값(가정)
		MemberVO DBVO = new MemberVO();
		DBVO.setUserid("user01");
		DBVO.setUserpw("1234");
		DBVO.setUsername("aaaaa");
		DBVO.setUseremail("aaa@aaa");
		
		//(MemberVO vo, Model model) 이거는 객체를 생성하는 것과 같다
		// 모델 객체를 하나 생성해서 - 디비 정보를 보낸다
		//request.setAttridute(이름, 값); 과 유사한 형태의 동작
		//뷰에서 el표현식으로 출력한다
		model.addAttribute("DBVO", DBVO);
		// => key, value 쌍으로 정보를 저장해서 사용
		model.addAttribute(DBVO);
		// 하나는 객체만 넣게 되어있다 -> 호출할 이름이 없는 상태
		// => 전달하는 객체이름의 첫글자 소문자로 변경해서 이름으로 사용!!!!
		
		
		return "test";
	}
	
	
	
}
