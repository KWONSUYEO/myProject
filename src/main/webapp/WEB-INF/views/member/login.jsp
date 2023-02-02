<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<table id = "login">
<form action="member.login" method="post">
	<tr><th align="center">로그인창</th></tr>
	<tr><td align="center">아이디<input name="m_id"></td></tr>
	<tr><td align="center">비밀번호<input name="m_pw"></td></tr>
	<tr><td align="left"><button>로그인</button></td>
	
</form>
<td><button onclick="Join()">회원가입</button></td></tr>
</body>
</html>