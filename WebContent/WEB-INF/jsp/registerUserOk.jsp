<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HIGHT＆LOW</title>
</head>
<body>
<h1>登録完了</h1>
<p><c:out value="${registerUserId.getUserId()}" /> さんの登録が完了しました。</p><br>
<a href="/highAndLow/WelcomeServlet">トップへ</a>


</body>
</html>