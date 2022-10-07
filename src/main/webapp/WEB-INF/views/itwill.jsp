<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>WEB-INF/views/itwill.jsp</h1>

JSP : <%=request.getParameter("msg") %> <br>
el : ${param.msg } <br>
el : ${msg } <br>


</body>
</html>