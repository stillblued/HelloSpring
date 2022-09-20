<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri = "http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<h1>톱 페이지입니다.</h1>
	
	<sec:authorize access="isAuthenticated()">
	부서 ${dept}
	id : <sec:authentication property="principal.Username"/>
	권한 : <sec:authentication property="principal.Authorities"/>
	<form action ="logout" method="post">
		<sec:csrfInput />
	</form>
	</sec:authorize>
	
	
	<sec:authorize access="isAnonymous()">
		<a href = "login.jsp">로그인</a>
	</sec:authorize>
	
	
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>

		<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>



	</ul>

</body>
</html>