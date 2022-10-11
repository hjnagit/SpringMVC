package com.itwillbs.web;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger log 
		= LoggerFactory.getLogger(MemberController.class);
	
	//서비스 객체 주입(DI)
//	@Inject
	@Autowired
	private MemberService service;
	
	//http://localhost:8088/web/member/test
	
	//서버당 프로젝트 한개를 실행할 때 사용하는 방법 /로 바꿔준다
	//http://localhost:8088/member/test
	
//	@RequestMapping("/test")
//	public void TestMember() {
//		log.info("MemberController 실행!!!");
//		
//		
//	}
	
	
	//http://localhost:8088/member/insert
	//회원가입 GET (조회, 입력) - /member/insert
	@RequestMapping(value = "/insert", method=RequestMethod.GET)
	public void insertGET() {
		log.info("insertGET() 호출");
		log.info("연결된 view페이지 출력");
	}
	
	
	//회원가입 POST (처리)
	//@PostMapping("주소") -> 이렇게 사용해도 된다
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPOST(MemberVO vo, HttpServletRequest request) throws Exception {
		log.info("insertPOST() 호출"); 
		
		//한글처리
		//request.setCharacterEncoding("UTF-8");
		
		//전달된 정보 저장(userid, userpw, username, useremail)
		//MemberVO 객체에 저장
		//MemberVO vo = new MemberVO();
		//vo.setUserid(request.getParameter("userid"));
		//vo.setUserpw(request.getParameter("userpw"));
		//vo.setUsername(request.getParameter("username"));
		//vo.setUseremail(request.getParameter("useremail"));
		
		log.info(vo + "");
		
		//회원가입 -> 서비스 -> 디비저장 -> DAO객체 생성
		//MemberDAO dao = new MemberDAOImpl(); xxxx
		//이제 서비스가 디비호출해서 구현할거다
		service.memberJoin(vo);
		
		log.info("회원가입 성공!!");
		
		//페이지 이동(로그인 페이지로)
		
		
		
		
		//return "/member/login";
		return "redirect:/member/login";
	}
	
	
	//로그인GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() {
		log.info("loginGET() 실행");
		
		//전달하는 데이터가 없음
		log.info("연결된 뷰 페이지로 이동");
		
		return "/member/memberLogin";
	}
	
	
	
	
	//로그인POST
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
