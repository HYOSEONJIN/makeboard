<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script>

    <c:if test="${result eq 0}">
        alert('알수없는 에러발생');
        location.href="/";
    </c:if>
    
    <c:if test="${result eq 1}">
        alert('삭제완료');
        location.href="/";
    </c:if>
    
    <c:if test="${result eq 2}">
        alert('비밀번호가 틀립니다');        
        location.href="/";
    </c:if>

</script>
    