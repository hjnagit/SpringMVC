<%@page import="com.itwillbs.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main.jsp</h1>
	<h2>메인 페이지</h2>
	
	
	<c:if test="${loginVO == null }">
		<!-- 사용자 정보없음 -->
		<c:redirect url="/member/login" />
	</c:if>
	
	
	
	
	
<%-- 	
	jsp 코드 출력문은 null일 때 오류가 생기니까 이거 안함
	jsp코드가 내부적으로 가장 먼저 실행되는 코드니까 
	사용하지 말자!!
	
	<%
	
		MemberVO vo = (MemberVO)session.getAttribute("loginVO");
	
	%>
	<%=vo.getUserid() %> 이렇게 출력가넝한. <br> 
--%>
	
	
	${loginVO.userid }님 환영합니당🙌🙌🙌🙌🙌💕🙌🙌🙌🙌🙌💕 <br>
	
	${sessionScope.loginVO.userid } -> 이렇게 가능한데 앞은 생략가넝 <br>
	
	<hr>
	
	<!-- 로그아웃 -->
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';">
	<a href="javascript:location.href='/member/logout'">로그아웃</a>
	
	
	
	<hr>
	
	<a href="/member/info">회원정보 조회</a>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>