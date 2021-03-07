<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="<c:url value='lib/jquery/jquery-3.6.0.min.js'/>" crossorigin="anonymous"></script>
    <script src="<c:url value='lib/DataTables/datatables.min.js'/>" crossorigin="anonymous"></script>

</head>

<body>
    <button onclick="location.href='/post/write'">글쓰기</button>
    <table id="postList"></table>
</body>

</html>