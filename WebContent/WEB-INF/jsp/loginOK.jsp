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
<p>ようこそ、<c:out value="${userId}" /> さん</p><br>
<a href="/highAndLow/GameServlet">ゲームスタート</a><br>
<a href="/highAndLow/LogoutServlet">ログアウト</a><br>
</body>
</html>