<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

				<!-- bno만 있으면 LIST버튼을 누르면 제일 최신 페이지로 이동할 수 밖에 없게 된다. -->
				<form role="form" method="post">
					<input type='hidden' name='bno' value="${boardVO.bno}">
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
	$("#modifyBtn").on("click", function() {		//수정버튼 클릭시
		formObj.attr("action", "/board/modify");	//controller @requestMapping(var, 
		formObj.attr("method", "get");				//method - requestMethod.get)
		formObj.submit();							//<input type='hidden' name-'btn'
	});
	
	$("#removeBtn").on("click", function() {		
		formObj.attr("action", "/board/remove");	
		formObj.submit();							
	});
	
	$("#goListBtn").on("click", function() {
		formObj.attr("method", "get");
		formObj.attr("action", "/board/listAll");	
		formObj.submit();							
	});
	
});
</script>

<%@include file="../include/footer.jsp"%>