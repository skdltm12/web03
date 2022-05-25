<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
#lsb_tb {width:700px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content" class="panel-body">
	<div>
		<h3>${name }님 &nbsp; &nbsp; <a href="../logoutCtrl">로그아웃</a></h3>
	</div>
	<h2>글 목록</h2>
	<form method="post" action="">
	<table class="table" id="lsb_tb">
		<thead>
			<tr>
				<th class="item1">번호</th>
				<th class="item2">제목</th>
				<th class="item3">작성자</th>
				<th class="item4">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list}" var="vo" varStatus="stauts">
			<tr>		
				<td>${status.count }</td>
				<td><a href="../GetBoardCtrl?num=${vo.seq }">${vo.title }</a></td>
				<td>${vo.nickname }</td>
				<td>${vo.regdate }</td>
			</tr>
			</c:forEach>
				<tr>
					<td colspan="4"><a href="addBoardForm.jsp">글 쓰기</a></td>
				</tr>
		</tbody>
	</table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>