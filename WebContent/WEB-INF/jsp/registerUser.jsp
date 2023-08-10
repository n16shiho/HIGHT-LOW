<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HIGHT＆LOW</title>
</head>
<body>
<form name="form1" action="/highAndLow/RegisterUserSevlet" method="post"
	onsubmit = "return funcConfirm();">
ユーザーID：<input type="text" name="userId" maxlength="20" ><br>
パスワード：<input type="password" name="pass" maxlength="20"><br>
メールアドレス：<input type="text" name="mail" maxlength="50"><br>
名前：<input type="text" name="name" maxlength="20"><br>
年齢：<input type="text" name="age" maxlength="10"><br>
<input type="submit" value="登録"><br>
<a href="/highAndLow/WelcomeServlet">トップへ</a>
</form>
</body>
<script type="text/javascript" >
	function funcConfirm(){
	    if (document.form1.userId.value == ""){
	    	alert("ユーザーIDが入力されていません");
	    	return false;
	    }
	    if (document.form1.pass.value == ""){
	    	alert("パスワードが入力されていません");
	    	return false;
	    }
	    if (document.form1.mail.value == ""){
	    	alert("メールアドレスが入力されていません");
	    	return false;
	    }
	    if (document.form1.name.value == ""){
	    	alert("名前が入力されていません");
	    	return false;
	    }
	    if (document.form1.age.value == ""){
	    	alert("年齢が入力されていません");
	    	return false;
	    }





}

</script>
</html>