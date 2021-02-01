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
				
				
				<c:when test="${list.memberid eq 'U' }">
					<tr>
					</tr>
				</c:when>
		</table>
	</div>
</body>
</html>