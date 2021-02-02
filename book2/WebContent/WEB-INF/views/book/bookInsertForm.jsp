<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<h1>도서 등록</h1>
	</div>
	
	<div align="center">
	<form id="frm" name="frm" action="bookInsert.do" method="post">
		<table border="1">
			<tr>
				<th width="90">도서코드</th>
				<td>
					<input type="text" id="bookcode" name="bookcode" size="5">
				</td>
				<th width="100">도서명</th>
				<td>
					<input type="text" id="bookname" name="bookname" size="15">
				</td>
			</tr>
			<tr>
				<th>기본수량</th>
				<td align="center">5</td>
				<th width="100">날짜</th>
				<td>
					<input type="date" size="15">
				</td>
			</tr>
			<tr>
				<th>비고</th>
				<td colspan="3">
					<textarea rows="10" cols="45" ></textarea>
				</td>
			</tr>
		</table><br/>
		<button type="submit">등록</button> &nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button> &nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='bookList.do'">목록</button>
		</form>
	</div>
</body>
</html>