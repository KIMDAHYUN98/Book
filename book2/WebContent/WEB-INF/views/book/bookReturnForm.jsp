<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>책번호</th>
				<th>회원번호</th>
				<th>대여일자</th>
				<th>반납일자</th>
				<th>반납</th>
			</tr>		
			<tr>
				<td>${vo.bookcode }</td>
				<td>${vo.memberid }</td>
				<td>${vo.rentaldate }</td>
				<td>${vo.returndate }</td>
				<td>
					<button type="button" onclick="location.href='bookReturn.do'">반납</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>