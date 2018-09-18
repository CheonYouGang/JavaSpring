<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.spring.domain.SearchCriteria"%>
<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary"> 
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

				<!-- read.jsp를 개선. page, perPageNum값이 있을때 LIST버튼을 누를 시 해당 page항목으로 돌아갈 수 있다. -->
				<form role="form" method="post">
					<input type='hidden' name='bno' 	   value="${boardVO.bno}">
					<input type='hidden' name='page'	   value="${criteria.page}">
					<input type='hidden' name='perPageNum' value="${criteria.perPageNum}">
					<!-- 
					게시글 번호			bno
					현재 페이지 번호		page
					보여질 데이터 갯수	perPageNum
					 -->
					<input type='hidden' name='searchType' value="${criteria.searchType}">
					<input type='hidden' name='keyword'	   value="${criteria.keyword}">
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${boardVO.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${boardVO.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->
  
				<div class="box-footer">
					<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
					<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
					<button type="submit" class="btn btn-primary" id="goListBtn">LIST
						ALL</button>
				</div>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<script type="text/javascript">
$(document).ready(function() {
	var formObj=$("form[role='form']");
	console.log(formObj);//(크롬) 브라우저 개발자 도구 콘솔창에서 로그 확인
	$("#modifyBtn").on("click", function() {			//수정버튼 클릭시
		formObj.attr("action", "/sboard/modifyPage");	//controller @requestMapping(var, 
		formObj.attr("method", "get");					//method - requestMethod.get)
		formObj.submit();								//<input type='hidden' name-'btn'
	});													// "action", "/board/modifyPage"값이 맞아야 적용
	
	$("#removeBtn").on("click", function() {		
		formObj.attr("action", "/sboard/remove");	
		formObj.submit();							
	});
	
	$("#goListBtn").on("click", function() {
		formObj.attr("method", "get");
		formObj.attr("action", "/sboard/list");	
		formObj.submit();							
	});
	
});
</script>

<%@include file="../include/footer.jsp"%>