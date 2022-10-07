<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

h1{
	color: red;
	font-size: xx-large;
}

span{
	color: orange;
	font-size: 10em;
}

#div{
	color: sky;
	
}

</style>
</head>       
<body>

<h1>doA.jsp</h1>

<span>하이루</span>

<hr>
<div id="div">
name : ${param.name }<br>
tel : ${param.tel }<br>
name : ${name }<br>
tel : ${tel }<br>
</div>



</body>
</html>