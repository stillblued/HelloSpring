<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding: 1.5em;
	background: #f5f5f5
}

table {
	border: 1px #a39485 solid;
	font-size: .9em;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	width: 80%;
	border-collapse: collapse;
	border-radius: 5px;
	overflow: hidden;
}

th {
	text-align: left;
}

thead {
	font-weight: bold;
	color: #fff;
	background: #A9D0F5;
}

td, th {
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	border-bottom: 1px solid rgba(0, 0, 0, .1);
	background: #fff;
}

a {
	color: #73685d;
}

@media all and (max-width: 768px) {
	table, thead, tbody, th, td, tr {
		display: block;
	}
	th {
		text-align: right;
	}
	table {
		position: relative;
		padding-bottom: 0;
		border: none;
		box-shadow: 0 0 10px rgba(0, 0, 0, .2);
	}
	thead {
		float: left;
		white-space: nowrap;
	}
	tbody {
		overflow-x: auto;
		overflow-y: hidden;
		position: relative;
		white-space: nowrap;
	}
	tr {
		display: inline-block;
		vertical-align: top;
	}
	th {
		border-bottom: 1px solid #a39485;
	}
	td {
		border-bottom: 1px solid #e5e5e5;
	}
}
</style>

</head>
<body>


	<br>
	<br>
	<div align="center">

		<table id="tb" style="width: 800px; text-align: center;">
			<tr>
				<th>Title</th>
				<td colspan="3">${n.noticeTitle}</td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${n.noticeWriter}</td>
				<th>Date</th>
				<td>${n.noticeDate}</td>
				<th>No</th>
				<td>${n.noticeId}</td>
			</tr>
			<tr>
				<td colspan="6">
					<%-- 				<c:if test="${not empty n.noticeAttachDir }"> --%> <%-- 				<img src="${n.noticeAttachDir}"><br> --%>
					<%-- 				</c:if> --%> ${n.noticeSubject}
				</td>
			</tr>
		</table>

		<br>


		<form name="Frm" action="noticeUpForm.do" method="post"
			enctype="application/x-www-form-urlencoded">
			<input type="hidden" id="noticeId" name="noticeId"
				value="${n.noticeId}" />
			<button type="submit">update</button>
			<button type="button" onclick="noticeDelete(${n.noticeId})">delete</button>
			<button type="button" onclick="location.href='noticeList.do'">List</button>
		</form>




	</div>


	<br>

	<script type="text/javascript">
function noticeDelete(data) {
	
	let noticeId = data;
	
	if(confirm('게시글을 삭제하시겠습니까?')){  
		
		$.ajax({
			url : "ajaxNoticeDelete.do",
			type : "post",
			data : { noticeId : noticeId },
			dataType : "Json",
			success : function(result) {
				if (result != null) {
					location.replace('noticeList.do');
				} else {
					alert("공지글 삭제 실패.");
				}},
			error : function() {
				console.log("error");
			}
		});
	
	};
}
	

</script>


</body>
</html>