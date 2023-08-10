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
<p>アタリ</p>
<p>正解は「<c:out value="${card_1.suit}"/>の<c:out value="${card_1.num}"/>」</p>
<a href="/highAndLow/GameServlet">ゲームを続ける</a><br>
<a href="/highAndLow/LogoutServlet">ゲームをやめる</a><br>

</body>
</html>