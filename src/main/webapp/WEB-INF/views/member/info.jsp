<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member/info.jsp</h1>
	
	
	<fieldset>
		<legend>회원정보</legend>
		
		<form action="">
			아이디 : <input type="text" name="userid" value="${userVO.userid }" readonly="readonly"><br>
			비밀번호 : <input type="password" name="userpw"><br>
			이메일 : <input type="text" name="useremail" value="${userVO.useremail }"><br>
			회원가입일 : ${userVO.regdate }<br>
		
		</form>
		
		<a href="/member/main">메인 페이지</a>
	</fieldset>
	
	
	
	
	
</body>
</html>