<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${notices}" var="N">

${N.NOTICE_ID} : ${N.NOTICE_WRITER} : ${N.NOTICE_TITLE} : ${N.NOTICE_DATE} 
 <br>


</c:forEach>





</body>
</html>