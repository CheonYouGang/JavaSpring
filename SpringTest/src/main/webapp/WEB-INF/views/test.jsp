<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax</title>

<style type="text/css">
	#modDiv{
		width: 300px;
		height: 100px;
		background-color: gray;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-top: -50px;
		margin-left: -150px;
		padding: 10px;
		z-index: 1000;
	}
</style>
</head>


<body>
	<h2>Ajax 테스트 페이지</h2>
	<div>
		<div>
			Replyer <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			Replyer Text <input type="text" name="replytext" id="newReplyText">
		</div>
		<button id="replyAddBtn">ADD REPLY</button>
	</div>
	
	
	<ul id="replies">
	</ul>
	
	<div id="modDiv" style="display: none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify(수정)</button>
			<button type="button" id="replyDelBtn">Delete(삭제)</button>
			<button type="button" id="CloseBtn">Close(닫기)</button>
		</div>
	</div>
	
	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	

</body>
</html>

	<script>
	$(document).ready(function() {
		
		var bno = 3153;
		var str = "";
		
		function getAllList() {
			str = "";
			//json함수
			$.getJSON("/replies/all/" + bno, function(data) {
				console.log(data.length);
				
				//each() = 반복처리함수
				$(data).each(function() {
					str += "<li data-rno='" + this.rno + "' class='replyLi'>"
						+ this.rno + " : " +  this.replytext
						+ "<button>수정</button>"
						+ "</li>";
				})
				$("#replies").html(str);
			});
		}
		
		$("#replies").on("click",".replyLi button", function() {
			var reply = $(this).parent();
			var rno = reply.attr("data-rno");
			var replytext = reply.text();
			//alert(rno + " : " + replytext);
			
			$(".modal-title").html(rno);
			$("#replytext").val(replytext);
			$("#modDiv").show("slow");
		});
		
		$("#replyDelBtn").on("click", function() {
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type : 'delete',
				url : '/replies/'+ rno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(result) {
					if(result=='success'){
						alert("삭제되었습니다.");
						//화면 새로고침 function getAllList()
						$('#modDiv').hide("slow");	//숨김
						getAllList(); 
					}
				}
			});
		});
		
		$("#replyModBtn").on("click", function() {
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type : 'put',
				url : '/replies/'+rno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "PUT"
				},
				dataType : 'text',
				data : JSON.stringify({
					replytext : replytext 
				}),
				success : function(result) {
					if(result=='success'){
						alert("수정되었습니다.");
						//화면 새로고침 function getAllList()
						$('#modDiv').hide("slow");	//숨김
						getAllList(); 
					}
				}
			});
		});
		
		$("#replyAddBtn").on("click", function() {
			var replyer   = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
			
			$.ajax({
				type : 'post',
				url : '/replies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno, 				  
					replyer : replyer, 		 
					replytext : replytext 
				}),
				success : function(result) {
					if(result=='success'){
						alert("등록되었습니다.");
						//화면 새로고침 function getAllList()
						getAllList(); 
					}
				}
			});
		});
		
		
	});
	</script>