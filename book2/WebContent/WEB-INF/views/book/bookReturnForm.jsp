<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<jsp:include page="../common/menu.jsp" /><br/>
<body>
	<div align="center">
	  <div>  	
		<table border="1">
			<tr>
				<th>책번호</th>
				<th>회원번호</th>
				<th>대여일자</th>
				<th>반납일자</th>
				<th>반납</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<c:if test="${vo.memberid eq memberid}">
					<tr>
						<td >${vo.bookcode }</td>
						<td>${vo.memberid }</td>
						<td>${vo.rentaldate }</td>
						<td>${vo.returndate }</td>
						<td width="10">
							<form action="bookReturn.do" method="post">
									<input type="hidden" id="bookcode" name="bookcode" value="${vo.bookcode }">
									<input type="hidden" id="bcount" name="bcount" value="${vo.bcount }">
									<input type="submit" value="반납">
							</form>
						</td>
						
					</tr>
				</c:if>
			</c:forEach>		
		</table>
	  </div>
	</div>
</body>
</html>