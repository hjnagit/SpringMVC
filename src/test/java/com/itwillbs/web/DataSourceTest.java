package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//-> 이 클래스를 스프링모드로 테스트 하겠습니다


//@ContextConfiguration(
//		locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
//		)
//=> 이 프로젝트 실행할 때 사용할 설정, 위치 : ~~~~


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
		)
public class DataSourceTest {
	//DataSource 객체 생성여부 확인
	
	private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);
	
	
	//root밑에 있는 것을 사용가능하다
	//DataSource 객체 생성(직접 생성 - 강한 결합 => 주입)
	//private DataSource ds; //이렇게만 적으면 null
	
	// @Inject라고 적어준다 - inject 주입
	//@Inject : Spring에 이쓴 객체(빈)을 가져와서 주입하겠다
	//         객체를 직접 생성x, 의존관계 주입
	//         => DI(Dependency Injection)
//	@Inject -> 자바에서 제공해주는 어노테이션
//	@Autowired
	@Inject
	private DataSource ds; // 이렇게하면 객체가 생성된다
	//@Autowired 이것도 실행됨 -> 이거는 스프링에서 제공해주는 기능
	//둘 다 같은 역할을 한다
	
	@Test
	public void DataSource있는지() {
		//DataSource 객체가 필요 => 의존하고 있다(의존관계)
		
		//log는 String만 출력가능 스트링으로 바꿔준다 .toString / +""
		log.info(ds.toString());
		
	}
	
	@Test
	public void 디비연결되는지() {
		//디비 연결 체크
		
		try {
			Connection con = ds.getConnection();
			
			if(con != null) {
				log.info("디비 연결 성공!!");
				log.info(con + "");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
