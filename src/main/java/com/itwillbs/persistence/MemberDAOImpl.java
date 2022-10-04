package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

//@Repository : 스프링(root-context.xml)에서 파일을 DAO 파일로 인식하도록 설정

@Repository
public class MemberDAOImpl implements MemberDAO{
	//DAO에 관련된 동작을 수행

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	//디비연결 정보 필요 => 의존관계
	//mybatis를 사용할 거니까 sqlSessionFactory 객체 필요함(주입)
	//이미 생성된 객체 [root-context.xml - sqlSessionFactory객체(빈)] 를 사용
	@Inject
	private SqlSessionFactory factory;
	
	
	//alt shift s -> v 
	@Override
	public String getDbTime() {
		
		//1.2. 디비연결
		//3. sql 작성
		//4. sql 실행
		//5. 데이터 처리
		SqlSession sqlSession = factory.openSession();
		//selectOne -> 실행해서 데이터 1개만 리턴해 와라 라는 뜻 -> T타입
		//namespace 복사해주기
		//xml까지 찾아가게 해주는 주소
		//id .getTime로 적어주기
		//자동으로 String으로 받아와진다
		String now = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		log.info("#####now : " + now);
		
		return now;
	}
	
	
	
	
}
