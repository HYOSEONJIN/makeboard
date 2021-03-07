<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${board eq null}">
    alert("ERROR.");
    location.href = '
    <c:url value="index" />';
</c:if>

<!DOCTYPE html>
<html lang="">



<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <style>
        table tr td{
            border-bottom: 1px solid #ddd;
        }

        button{
            margin : 10px 0;
        }
    </style>
    <link rel="stylesheet" href="<c:url value="/css/post.css"/>"> </head> <body>

    <table width="500px">
        <tr>
        <td>No.</td>
        <td>${board.postidx}</td>
        <td>
        </td>
        <td></td>
        </tr>
        <tr>
            <td>글쓴이</td>
            <td>${board.postWriter}</td>
            <td>등록일</td>
            <td>${board.postDate}</td>
        </tr>
        <tr>
            <td>제목</td>
            <td colspan="3">${board.postTitle}</td>
        </tr>

        <c:if test="${board.postFileName ne null}">
            <tr>
                <td colspan="4">
                <img width="400" src="<c:url value="/fileupload/${board.postFileName}/"/>">
            </td>
            </tr>


        </c:if>
        <tr>
            <td colspan="4">
                ${board.postText}
            </td>
        </tr>

    </table>
    <button onclick="location.href='/post/update'">수정</button>
    <button>삭제</button>


    </body>

</html>