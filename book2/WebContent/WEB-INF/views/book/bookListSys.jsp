
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
tr.row:hover {
	background-color: lightyellow
}
</style>
<jsp:include page="../common/menu.jsp" />
<!-- 글 상세보기 시 post 방법으로 전달 -->
<!-- 스크립트 작업 영역 -->
<script type="text/javascript">
function formSubmit(str) {
	frm.bookcode.value=str;
	frm.submit();
}

</script>

<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px"
	align="center">
	<h1>도서 리스트</h1>
	
	<div>
		<form id="frm" name="frm" action="bookView.do" method="post">
				<input type="hidden" id="bookcode" name="bookcode">
		</form>
	</div>

	<table border="1">

		<c:if test="${membermauth == 'SYS' }">
			<tr>
				<th width="100">도서 코드</th>
				<th width="250">도 서 명</th>
				<th width="150">기본 수량</th>
				<th width="150">현재 수량</th>
			</tr>
		</c:if>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td align="center" colspan="5">대여할 수 있는 목록이 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${not empty list && membermauth == 'SYS'}">
				<c:forEach var="vo" items="${list }">
					<tr class="row" onclick="formSubmit(${vo.bookcode })">
						<td align="center">${vo.bookcode }</td>
						<td>&nbsp;${vo.bookname }</td>
						<td align="center">${vo.quantity }</td>
						<td align="center">${vo.bcount }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table><br/>
	<button type="button" onclick="location.href='bookInsertForm.do'">등록</button><br/>
</div>
</head>
</body>
</html>
</body>
</html>