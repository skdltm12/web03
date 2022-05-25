<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="csspt" value="${pageContext.request.contextPath }/css" /> 
<link rel="stylesheet" href="${csspt }/common.css" />
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<link rel="stylesheet" href="datatables.min.css">
<script src="datatables.min.js"></script>
<script>
$(document).ready( function () {
    $('#lst_tb').DataTable();
});
</script>
<style>
#lst_tb, .frm_fr { max-width:1280px; min-width:800px; margin:0 auto; }
.navbar-link:not(.is-arrowless)::after { display:none; }
.con_wrap { width:1280px; margin:0 auto; } 
.frm_fr { width:800px; }
#logo img { display:block; width:180px; height:30px; min-height:30px; max-height:30px; }
#gnb .navbar-link { font-size:18px; }
</style>