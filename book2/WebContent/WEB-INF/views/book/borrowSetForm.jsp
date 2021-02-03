<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px"align="center">
	<h1>대여 기록</h1>
			<table border="1">
				<tr>
					<th>책번호</th>
					<th>회원번호</th>
					<th>대여일자</th>
					<th>반납일자</th>
				</tr>
				<c:forEach var="vo" items="${list }">
						<tr>
							<td><input type="text" id="bookcode" name="bookcode"
								value="${vo.bookcode }" readonly="readonly" size="5"></td>
							<td>${vo.memberid }</td>
							<td>${vo.rentaldate }</td>
							<td>${vo.returndate }</td>
						</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>