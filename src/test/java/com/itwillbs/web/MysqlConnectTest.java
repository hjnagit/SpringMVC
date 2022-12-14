package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlConnectTest {
	//테스트 클래스 : 서버를 사용해서 테스트하는 동작을 jUnit을 사용해서 대신 테스트하는 클래스
	
	
	// @Test : 테스트 동작을 수행하는 메서드에 사용
	// @Test가 있어야지만, junit이 실행 가능
	
	
	//@Before : 테스트 작업전에 반드시 준비(실행)되어야 하는 동작을 처리하는 어노테이션
	//@After : 테스트 작업후에 반드시 처리하는 동작
	
	//@Test : 작성순서가 실행준서를 보장x(랜덤- 랜덤은 아닌데 일단 랜덤으로 실행시킴)
	//테스트에서 jUnit 실행 순서
	//@Before -> @Test -> @After
	
	
	//로거를 사용해서 출력하기
	//Before전에 적는다
	//private static final Logger mylog = LoggerFactory.getLogger(MysqlConnectTest.class);
	//private static final Logger log = LoggerFactory.getLogger(MysqlConnectTest.class);
	private static final Logger log = LoggerFactory.getLogger(MysqlConnectTest.class);
	
	
	
	
	//@Test
	@Before
	public void 테스트동작하는지테스트() throws Exception{
		System.out.println("MysqlConnectTest - test() 호출");
		System.out.println("테스트 클래스 실행!!");
	}
	
	@Test
	public void 디비연결테스트() throws Exception{
		System.out.println("디비연결테스트() 수행");
		
		//1.드라이버 로드 - 라이브러리 추가해야 가능함
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("T : 드라이버 로드 성공!");
		
		//2. 디비 연결
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/springdb", 
				"root", 
				"1234");
		System.out.println("T : 디비연결 성공!");
		System.out.println("T : con : " + con);
		
		log.info("실행 테스트");
		
		//
		
		
		
		
		
	}
	
	
	
	@Test
	public void 디비연결테스트2() throws Exception{
		System.out.println("디비연결테스트() 수행");
		
		//1.드라이버 로드 - 라이브러리 추가해야 가능함
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("T : 드라이버 로드 성공!");
		
		//2. 디비 연결
		//자원해제하려고 밖에 선언함
		//Connection con = null;
//		try {
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/springdb", 
//					"root", 
//					"1234");
//			System.out.println("T : 디비연결 성공!");
//			System.out.println("T : con : " + con);
//			
//			log.info("실행 테스트");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			con.close();
//		}
		
		//try-with 구문
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/springdb", 
				"root", 
				"1234")) {
			
			System.out.println("T : 디비연결 성공!");
			System.out.println("T : con : " + con);
			
			log.info("실행 테스트");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//
		
		
		
		
		
	}
	
}
