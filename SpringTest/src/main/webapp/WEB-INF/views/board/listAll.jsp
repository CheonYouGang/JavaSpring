<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	response.setCharacterEncoding("utf-8");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board List All</title>
</head>

<%@ include file="../include/header.jsp"%>
<div class="box-title with-border">
	<h3 class="box-title">List Paging</h3>
</div>
<div class="box-body">
	<table class="table table-bordered">
		<tr>
			<center><th style="width: 10px;">Bno</th></center>
			<center><th style="width: 40px;">Title</th></center>
			<center><th style="width: 40px;">Writer</th></center>
			<center><th style="width: 40px;">Regdate</th></center>
			<center><th style="width: 40px;">Viewcnt</th></center>
		</tr>


		<c:forEach items="${list}" var="boardVO" varStatus="">
			<tr>
				<center><td>${boardVO.bno}</td></center>
				<center><td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td></center>
				<center><td>${boardVO.writer}</td></center>
				<center><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${boardVO.regdate}" /></td></center>
				<center><td><span class="badge bg-red"> ${boardVO.viewcnt}</span></td></center>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../include/footer.jsp"%>
