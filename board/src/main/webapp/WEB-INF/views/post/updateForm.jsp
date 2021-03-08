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


    <form id="writeForm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="postidx" value=${board.postidx}>
        <input type="hidden" name="exFileName" value=${board.postFileName}>
        <table>
            <tr>
                <td>글쓴이</td>
                <td>
                    <input type="Text" class="postWriter" id="postWriter" name="postWriter" required value=${board.postWriter}></td>
                <td>비밀번호</td>
                <td>
                    <input type="password" class="postPassword" id="postPassword" name="postPassword" required value=></td>
            </tr>
            <tr>
                <td>제목</td>
                <td colspan="3"><input type="Text" class="postTitle" id="postTitle" name="postTitle" required value=${board.postTitle}></td>
            </tr>
            <tr>
                <td colspan="4">
                    <textarea class="postText" id="postText" name="postText">${board.postText}</textarea>
                </textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <input type="file" id="postFile" name="postFile"></td>
        </tr>
    </td>
    <tr>
        <td></td>
        <td>
            <button class="cancel" onclick="location.href='<c:url value="/"/>'">취소</button>
        </td>
        <td>
            <input type="submit" value="수정"></td>
        <td></td>

    </tr>
</table>
</form>
  
</body>

</html>