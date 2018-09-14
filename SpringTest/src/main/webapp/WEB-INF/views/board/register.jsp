<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	response.setCharacterEncoding("utf-8");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 
<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-title">Register Board</div>
			</div>
			
			<form role="form" method="post" id="registForm">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" name="title" class="form-control" placeholder="Enter Title">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Content</label>
						<textarea name="content" class="form-control" rows="3" placeholder="Enter..."></textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label>
						<input type="text" name="writer" class="form-control" placeholder="Enter Writer">
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
		<!-- /.box -->
	</div>
	<!-- /.col(left) -->
</section>
<%@ include file="../include/footer.jsp"%>
