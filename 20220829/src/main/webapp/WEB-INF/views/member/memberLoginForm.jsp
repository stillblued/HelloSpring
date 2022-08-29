<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<div>
			<h1>로그인</h1>
		</div>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table border="1">
						<tr>
						<th>아이디</th>
						<td>
						<input type = "text" id = "memberId" name="memberId">
						</td>
						</tr>
						<tr>
						<th>비밀번호</th>
						<td>
							<input type = "password" id = "memberPwd" name="memberPwd">
						</td>
						</tr>
					</table>
				</div><br>
				<input type="submit" value="로그인">&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>


	</div>


</body>
</html>