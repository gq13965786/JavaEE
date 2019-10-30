<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome page</title>
</head>
<body>
	<h4>welcome page</h4>
	
	<form action="${pageContext.request.contextPath }/login" method="GET" >
		用户名：<input type="text" name="username"/><br>
		个人兴趣：<input type="text" name="hobby"/><br>
		座右铭：<input type="text" name="frame"/><br>
		<input type="submit" value="登入"/>
	</form>
</body>
</html>