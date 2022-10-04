package com.itwillbs.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MyBatisTest {
	
	// 디비연결 / MyBatis 설정 => 각각 필요함 => 의존관계
	
	

	private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);
	
	// 의존관계(DI)
	//@둘 중 아무거나 사용가능
	//@Inject
	private DataSource ds; //디비 연결정보
	
	@Autowired
	private SqlSessionFactory sqlFactory; //디비 연결정보 + MyBatis설정

	
	@Test
	public void 객체주입여부_확인() {
		log.info("#####ds : " + ds);
		log.info("#####sqlFactory : " + sqlFactory);
	}
	
	@Test
	public void 디비연결테스트() {
		
		SqlSession sqlSession = sqlFactory.openSession();//디비 연결 수행
		log.info("#####sqlSession : " + sqlSession);
		//sqlSession.insert(statement);
		//sqlSession.select(statement, handler);
		//sqlSession.update(statement);
	}
	
	
}
