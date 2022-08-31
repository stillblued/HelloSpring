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
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div align="center">
		<br>
		<div>
			<form id="frm1">
				<select id="key" name="key">
					<option value="1">제목</option>
					<option value="2">내용</option>
					<option value="3">작성자</option>
				</select> &nbsp;&nbsp; <input type="text" id="val" name="val">
				&nbsp;&nbsp;
				<button type="button" onclick="searchCall()">검색</button>
			</form>
		</div>
		<br>

		<table id="tb">
			<thead>
				<tr>
					<th>No</th>
					<th>Title</th>
					<th>Date</th>
					<th>Writer</th>
					<th>Hit</th>
					<th>Attach</th>
				</tr>
			</thead>

			<tbody id="list">
				<c:forEach items="${notices}" var="N">
					<tr onclick="noticeDetail(${N.NOTICE_ID})">
						<td>${N.NOTICE_ID}</td>
						<td>${N.NOTICE_TITLE}</td>
						<td>${N.NOTICE_DATE}</td>
						<td>${N.NOTICE_WRITER}</td>
						<td>${N.NOTICE_HIT}</td>
						<td>${N.NOTICE_ATTACH}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

		<br>

		<div>
			<button type="button" onclick="location.href='noticeForm.do'">글쓰기</button>
		</div>

	</div>

	<script type="text/javascript">
function noticeDetail(data) {
	 let f = document.createElement('form');
	    
	    let obj;
	    obj = document.createElement('input');
	    obj.setAttribute('type', 'hidden');
	    obj.setAttribute('name', 'noticeId');
	    obj.setAttribute('value', data);
	    
	    f.appendChild(obj);
	    f.setAttribute('method', 'post');
	    f.setAttribute('action', 'noticeSelect.do');
	    document.body.appendChild(f);
	    f.submit();
	
}

function searchCall() {
	let key = document.getElementById('key').value;
	let val = document.getElementById('val').value;
	let keyword = {key:key, val:val};
	
	
	fetch("ajaxSearch.do", {
		method: 'POST',
	    headers: {
	    'Content-Type': 'application/x-www-form-urlencoded',

	    },
	    body: "key="+key+"&val="+val
	    
	}).then((response) => response.json())
	  .then((data) => htmlView(data));
}

function htmlView(data){
    $("#list").remove();
    let tbody = $("<tbody id = 'list' />");
    $.each(data, function(index, item){
       let row = $("<tr />").append(
             $("<td />").text(item.noticeId),
             $("<td />").text(item.noticeTitle),
             $("<td />").text(item.noticeDate),
             $("<td />").text(item.noticeWriter),
             $("<td />").text(item.noticeHit),
             $("<td />").text(item.noticeAttach),
             
             );
       tbody.append(row);
    });
    $("#tb").append(tbody);
 }

</script>


</body>
</html>