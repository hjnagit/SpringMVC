<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>views/member/insert.jsp</h1>

	<fieldset>
		<legend>회원가입</legend>
		
		<!-- 
		./이동페이지주소
		/컨트롤러주소/이동페이지주소 (권장) 
		2가지 방법으로 사용가넝
		-->
		
		
		<form action="/member/insert" method="post">
			아이디 : <input type="text" name="userid"><br>
			비밀번호 : <input type="password" name="userpw"><br>
			이름 : <input type="text" name="username"><br>
			이메일 : <input type="text" name="useremail"><br>
			<input type="submit" value="회원가입">
		</form>
	</fieldset>

</body>
</html>