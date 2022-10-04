package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//=>해당파일을 스프링(Junit)을 사용해서 테스트 하도록 설정

//@ContextConfiguration(
//locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//)
//=>스프링 테스트할 때 필요한 설정을 위 경로에서 가져다가 사용하겠다

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	//DAO의 동작이 정상적으로 실행되는지 테스트하는 파일
	
	//DAO 객체 생성(x) -> 객체 주입
	//원래는 MemberDAO dao = new MemberDAO(); -> 이거 안됨 인터페이스라
	
	//MemberDAOImpl daoImpl = new MemberDAOImpl(); // 이렇게는 사용해도 됨
	//=>근데 이거는 강한 결합이라 사용하지 않음
	
	//MemberDAO dao = new MemberDAOImpl(); // 이렇게도 사용 가능 - 업캐스팅
	//=> 이거는 중간정도의 결합(중간결합) -> 사용안함 -> 주입해야한다
	
	@Inject
	private MemberDAO dao; //-> 이것이 주입하는 것
	
	

	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Test
	public void daoTest() {
		log.info("#####dao : " + dao);
	}
	
	@Test
	public void 디비시간정보_조회() {
		
		log.info("#####디비시간정보_조회 : " + dao.getDbTime());
		
	}
	
}
