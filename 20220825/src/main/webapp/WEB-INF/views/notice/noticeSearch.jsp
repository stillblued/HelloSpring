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
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
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
  border-bottom: 1px solid rgba(0,0,0,.1);
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
    box-shadow: 0 0 10px rgba(0,0,0,.2);
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


<table>
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
  
  <tbody>
    <c:forEach items="${notices}" var="n">
    <tr onclick="noticeDetail(${n.noticeId})">
      <td>${n.noticeId}</td>
      <td>${n.noticeTitle}</td>
      <td>${n.noticeDate}</td>
      <td>${n.noticeWriter}</td>
      <td>${n.noticeHit}</td>
      <c:if test="${not empty n.noticeAttach}">
      <td>@</td>
      </c:if>
      <c:if test="${empty n.noticeAttach}">
      <td></td>
      </c:if>
    </tr>
   
    </c:forEach>
    
  </tbody>
</table>



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

</script>




</body>
</html>