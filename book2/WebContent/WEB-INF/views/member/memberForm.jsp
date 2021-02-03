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
			<h1>멤버 등록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberInsert.do" method="post">
				<table border="1">
					<tr>
						<th width="100">회원아이디</th>
						<td align="center" width="60">
						<input type="text" id="memberid" name="memberid" size="20" required="required">
						</td>
						</tr>
						<tr>
						<th width="100">회원명</th>
						<td align="center" width="60">
						<input type="text" id="membername" name="membername" size="20" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">패스워드</th>
						<td colspan="3">
						<input type="password" id="memberpassword" name="memberpassword" size="20" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">전화번호</th>
						<td colspan="3">
						<input type="text" id="membertel" name="membertel" size="20" required="required">
					</tr>
					<tr>
						<th width="100">권한</th>
						<td colspan="3">
						<input type="text" id="membermauth" name="membermauth" size="20" required="required">
					</tr>
				</table><br/>		
				<div>
			<button type="submit">등록</button> &nbsp;&nbsp;
			<button type="reset">취소</button> &nbsp;&nbsp;
			<button type="button" onclick="location.href='memberSetForm.do'">목록</button> &nbsp;&nbsp;
		</div>
			</form>
		</div><br />
		
	</div>
</body>
</html>