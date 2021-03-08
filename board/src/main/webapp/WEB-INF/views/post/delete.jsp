<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>


</head>

<link rel="stylesheet" href="<c:url value="/css/post.css"/>"></head>

<body>

    <form id="delForm" method="post" enctype="multipart/form-data">
    <input type="hidden" value=${postidx} name="postidx">
    비밀번호를 입력하세요<br>
    <input type="postPassword" name="postPassword">
    <input type="submit" value="확인">
    </form>
  
</body>

</html>