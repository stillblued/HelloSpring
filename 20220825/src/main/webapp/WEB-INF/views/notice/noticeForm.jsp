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
			<h1>공지사항 등록</h1>
		</div>
		<div>
			<form id="frm" action="noticeInsert.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<td width="200"><input type="text" id="noticeWriter"
								name="noticeWriter"></td>

						</tr>
						<tr>
							<th>제목</th>
							<td colspan="2"><input type="text" id="noticeTitle"
								name="noticeTitle" size="80"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="2"><textarea rows="10" cols="80"
									id="noticeSubject" name="noticeSubject"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="2"><input type="file" id="file" name="file">
							</td>
						</tr>

					</table>
				</div>
				<br> <input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="취소">
			</form>
		</div>

	</div>




</body>
</html>