<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productDetail.jsp</title>
</head>
<body>
<!-- 모델 값. -->
	<h1>제품은.${projectVO}</h1>
	<h1>제품이름은.${projectVO.name}</h1>
	<h1>제품가격은.${projectVO.price}</h1>
</body>
</html>