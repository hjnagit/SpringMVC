package com.itwillbs.web;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;
import com.itwillbs.service.MemberService;

//@RequestMapping("/member/*") -> 컨트롤러를 구분하는 것

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
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPOST(/*@ModelAttribute("userid") String userid*/
									MemberVO vo, HttpSession session) {
		//대부분의 POST방식은 페이지에 머물러 있지 않는다
		//-> 그래서 String을 대부분 사용한다
		log.info("loginPOST() 실행");
		
		// 한글처리 => 필터사용 - 생략
		// 전달정보 저장(userid, userpw) => 
		// -> 1. @ModelAttribute("userid") String userid
		// -> 2. MemberVO vo
		//log.info("userid : " + userid);
		log.info("vo : " + vo);
		
		// DB에서 확인(컨트롤러 -> 서비스 -> DAO)
		// -> 컨트롤러에서는 서비스만 부르면 된다
		MemberVO loginVO = service.memberLogin(vo);
		log.info(loginVO+ "");
		
		// 로그인 여부 확인
		if(loginVO != null) {
			// 성공 -> 메인페이지 이동, 로그인정보 저장(세션)
			// 로그인 정보 저장하기
			// jsp(view)에서 session정보를 가져와서 사용
			session.setAttribute("loginVO", loginVO);
			// redirect할 때 session의 정보는 당연히 유지된다
			return "redirect:/member/main";
		}else {
			// 실패 -> 로그인페이지 이동 -> 로그인 페이지로 redirect해라
			
			// 화면도 바꾸면서 주소도 바뀌는
			// 실패하면 로그인 페이지로 돌아가라
			// POST에서 GET으로 다시 호출하는
			return "redirect:/member/login";
		}
	}
	
	
	
	//메인 페이지 GET ( 그냥 정보 조회, 출력이니까)
	//void String 둘 다 상관없음
	// http://localhost:8088/member/main
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
		log.info(" mainGET() 호출");
		log.info("void 리턴 : /member/main.jsp 뷰 호출");
	}
	
	
	// 로그아웃 GET/POST
	// 버튼을 눌렀을 때 POST 방식으로 보낼 수 없다 - POST로 보내려면 ajax로 써야함
	// 그래서 GET방식으로 처리한다
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		log.info(" logout() 호출");
		// 로그아웃 -> 세션 초기화
		// 매개변수에 HttpSession session를 쓰면 뷰에서 세션 정보를 받아올 수 있다!!
		session.invalidate();
		log.info(" 세션 초기화 완료 -> 로그아웃");
		
		// 페이지 이동
		log.info(" /member/main 으로 이동");
		return "redirect:/member/main";
	}
	
	
	
	//회원정보 조회 GET - 조회니까 당연히 GET
	@RequestMapping(value="/info", method = RequestMethod.GET)
	public void infoGET(HttpSession session, Model model) {
		log.info("infoGET() 호출");
		//ID 정보 필요
		// main페이지(session) -> ID 정보 -> info페이지
		MemberVO vo = (MemberVO)session.getAttribute("loginVO");
		//vo.getUserid(); 이것이 id정보
		log.info("id : " + vo.getUserid());
		
		// 서비스사용 -> DB정보를 가져오기
		MemberVO userVO = service.memberGet(vo.getUserid());
		log.info("userVO : " + userVO);
		
		//DB 정보를 가져와서 -> view에 출력
		// 전달 정보를 Model객체에 저장
		model.addAttribute("userVO", userVO);
	}
	
	
	
	
	
	
	
} //class
