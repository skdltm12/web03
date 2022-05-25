<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>회원 정보 상세보기</title>
<jsp:include page="../common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<section class="con_wrap">
		<h2>글 상세보기</h2>
		<form action="${path1 }/EditMemberCtrl" method="post">
			<table class="table" id="lst_tb">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="mid" value="${member.mid }" readonly>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>
							<input type="password" name="mpw" value="${member.mpw }">
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>
							<input type="text" name="memail" value="${member.memail }">
						</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>
							<input type="tel" name="mtel" value="${member.mtel }">
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" name="addr1" value="${member.addr1 }"><br>
							<input type="text" name="addr2" value="${member.addr2 }"><br>
							<input type="text" name="postcode" value="${member.postcode }"><br>

						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>
						<c:if test="${sid!='admin' }">
						
							<a href="${path1 }/DelMemberCtrl?mid=${member.mid }" class="button is-info">탈퇴</a>
						</c:if>
							<c:if test="${sid=='admin' }">
							<a href="${path1 }/GetMemberListCtrl" class="button is-info">목록</a>
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</form>	
	</section>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>