package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//=>해당파일을 스프링(Junit)을 사용해서 테스트 하도록 설정

//@ContextConfiguration(
//locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//)
//=>스프링 테스트할 때 필요한 설정을 위 경로에서 가져다가 사용하겠다

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {
	// DAO의 동작이 정상적으로 실행되는지 테스트하는 파일

	// DAO 객체 생성(x) -> 객체 주입
	// 원래는 MemberDAO dao = new MemberDAO(); -> 이거 안됨 인터페이스라

	// MemberDAOImpl daoImpl = new MemberDAOImpl(); // 이렇게는 사용해도 됨
	// =>근데 이거는 강한 결합이라 사용하지 않음

	// MemberDAO dao = new MemberDAOImpl(); // 이렇게도 사용 가능 - 업캐스팅
	// => 이거는 중간정도의 결합(중간결합) -> 사용안함 -> 주입해야한다

	@Inject
	private MemberDAO dao; // -> 이것이 주입하는 것

	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);

	// @Test //테스트를 하고싶지 않을 때
	public void daoTest() {
		log.info("##### dao : " + dao);
	}

	// @Test
	public void 디비시간정보_조회() {

		log.info("##### 디비시간정보_조회 : " + dao.getDbTime());

	}

	//@Test
	public void 회원가입테스트() {

		log.info("##### 회원가입테스트() 호출");
		log.info("##### 테스트 -> DAOImpl");

		MemberVO vo = new MemberVO();
		vo.setUserid("test11");
		vo.setUserpw("1234");
		vo.setUsername("test");
		vo.setUseremail("S2@love.com");

		dao.insertMember(vo);

	}

	// 로그인 테스트
	// @Test
	public void 로그인로직_테스트() {
		log.info("로그인 체크 (입력받은 정보를 DB값과 비교)");

		MemberVO vo = new MemberVO();
		vo.setUserid("love");
		vo.setUserpw("1234");

		// MemberVO resultVO = dao.loginMember(vo);
		MemberVO resultVO = dao.loginMember(vo.getUserid(), vo.getUserpw());

		if (resultVO == null) {
			log.info("회원정보 없음, 로그인 실패!");
		} else {
			log.info("회원정보 있음, 로그인 성공!");
			log.info(resultVO + "");
		}

	}

	// 회원정보 조회(아이디만 사용)
	// @Test
	public void 회원정보_조회() {

		// dao 객체 생성(=> 객체 주입)

		// 회원정보 조회 메서드 호출
		MemberVO vo = dao.getMember("love");

		if (vo != null) {
			// 확인(출력)
			log.info("아이디 : " + vo.getUserid());
			log.info("비밀번호 : " + vo.getUserpw());
			log.info("이름 : " + vo.getUsername());
			log.info("이메일 : " + vo.getUseremail());
			log.info("가입일 : " + vo.getRegdate());
			log.info("정보수정일 : " + vo.getUpdatedate());
		}

	}

	// 회원정보 수정 - 아이디, 비밀번호 같을 때 이메일 수정(updatedate 수정)
	// @Test
	public void 회원정보_수정() {
		log.info("회원정보 수정 (테스트 -> DAOImpl)");

		MemberVO uvo = new MemberVO();
		uvo.setUserid("admin"); // 기존 아이디
		uvo.setUserpw("1234"); // 기존 비밀번호
		uvo.setUseremail("나는@관리자.com"); //// 수정할 이메일

		int result = dao.updateMember(uvo);

		if (result == 1) {
			log.info("회원정보 수정 성공!!");
		} else {
			log.info("회원정보 수정 실패!!");
		}

	}

	// 회원정보 삭제
	//@Test
	public void 회원정보_탈퇴() {
		log.info("회원 탈퇴 (테스트 -> DAOImpl)");

		MemberVO vo = new MemberVO();
		vo.setUserid("test1");
		vo.setUserpw("1234");


		int result = dao.deleteMember(vo);

		if (result == 1) {
			log.info("회원 탈퇴 성공!!");
		} else {
			log.info("회원 탈퇴 실패!!");
		}

	}

	

	
	// 회원목록(리스트) 조회
	@Test
	public void 회원목록리스트_조회() {
		log.info("회원목록 조회 (테스트 -> DAOImpl)");
		
		//DAO 회원 목록 리스트 동작 호출
		List<MemberVO> memberList = dao.getMemberList();
		
		for(MemberVO vo : memberList) {
			log.info("아이디 : " + vo.getUserid());
			log.info("이메일 : " + vo.getUseremail());
		}
		
		
	}
	
	
	

}
