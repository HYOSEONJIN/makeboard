<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script>

    <c:if test="${result eq 0}">
        alert('알수없는 에러발생');
        location.href="/";

    </c:if>
    
    <c:if test="${result eq 2}">
        alert('내용이 없습니다');        
        location.href="/";
    </c:if>
    
    <c:if test="${result eq 3}">
        alert('사진파일만 첨부해주세요');
        location.href="";
    </c:if>
</script>
    