<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HIGHT＆LOW</title>
</head>
<body>
<form action="/highAndLow/LoginServlet" method="post">
ユーザーID：<input type="text" name="userId" ><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
<a href="/highAndLow/WelcomeServlet">トップへ</a>
</form>
</body>
</html>