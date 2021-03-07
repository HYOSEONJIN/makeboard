<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title></title>
        <link rel="stylesheet" href="<c:url value="/css/post.css"/>"></head>

    <body>

        <form id="writeForm" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>글쓴이</td>
                    <td>
                        <input type="Text" class="postWriter" id="postWriter" name="postWriter"></td>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" class="postPassword" id="postPassword" name="postPassword"></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td colspan="3"><input type="Text" class="postTitle" id="postTitle" name="postTitle"></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <textarea class="postText" id="postText" name="postText"></textarea>
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
                <button class="cancel">취소</button>
            </td>
            <td>
                <input type="submit" value="등록"></td>
            <td></td>

        </tr>
    </table>
</form>
</body>

</html>