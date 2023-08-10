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
	<h1>HIGHT＆LOW</h1>
	<h2>【ルール】</h2>
	<p>山札からカードを１枚出します。次に出すカードが最初のカードよりも
		大きい（HIGH）か小さい(LOW)かを当てます。<br>
		大きい場合は「HIGHT」ボタンを、小さい場合は「LOW」ボタンを押してください。<br>
		このゲームでは「1」が最も小さい数で「13」が最も大きい数です</p>

	<h2>【ゲーム】</h2>
	<form action ="/highAndLow/GameServlet" method="post">
	<p> 次のカードは<br>
	「<c:out value="${card_0.suit}"/>の<c:out value="${card_0.num}"/>」<br>
	よりも大きい(HIGHT)か小さい(LOW)か？<br>
	</p>
	<button name="state" value="hight">HIGHT</button><br>
	<button name="state" value="low">LOW</button>
	</form>

</body>
</html>