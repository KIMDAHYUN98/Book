<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteAlert() {
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action="bookDelete.do";
			frm.submit();
		}
	}
	function editAlert() {
		frm.action="bookEditForm.do";
		frm.submit();
	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<h1>도서 상세보기</h1>
	</div>
	<div align="center">
	<form id="frm" name="frm" method="post">
	<table border="1">
		<tr>
			<th width="100">도서 코드</th>
			<th width="250">도 서 명</th>
			<th width="150">기본 수량</th>
			<th width="150">현재 수량</th>
		</tr>
		<tr align="center">
			<td>
				<input type="text" id="bookcode" name="bookcode" value="${vo.bookcode }" readonly="readonly">
			</td>
			<td>${vo.bookname }</td>
			<td>${vo.quantity }</td>
			<td>${vo.bcount }</td>
		</tr>
	</table><br/>
		<div>
			<button type="button" onclick="editAlert()">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="deleteAlert()">삭제</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='bookList.do'">목록</button>
		</div>
		</form>
	</div>
</body>
</html>