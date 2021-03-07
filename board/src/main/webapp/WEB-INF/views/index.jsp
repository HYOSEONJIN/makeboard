<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

<c:if test="${result eq 0}">
    alert('알수없는 에러발생');
</c:if>

<c:if test="${result eq 2}">
    alert('내용이 없습니다');
</c:if>

<c:if test="${result eq 3}">
    alert('사진파일만 첨부해주세요');
</c:if>
</script>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <script src="<c:url value='lib/jquery/jquery-3.6.0.min.js'/>" crossorigin="anonymous"></script>

    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
  
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>

    <script src="<c:url value='js/index.js'/>" crossorigin="anonymous"></script>

</head>

<style>
.dataTables_paginate{
    float: none !important;
    text-align: center !important;
}
button {
    margin: 10px;
    float: right;
    overflow: hidden;
}

</style>

<body>
    <button onclick="location.href='/post/write'">글쓰기</button>
    <!-- <table id="postList"></table> -->
    <table class="table table-bordered" id="postList" width="100%" cellspacing="0"></table>
</body>

</html>