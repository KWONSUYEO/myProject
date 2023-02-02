<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccecc.jsp</title>
</head>
<body>
<table>
<tr>
<td colspan="2">${sessionScope.loginMember.m_name } 님 환영합니다</td>
</tr>

<tr>
<td colspan="2">
<button onclick="Infogo()">내정보</button>
<button onclick="logout()">로그아웃</button>
</tr>
</table>
</body>
</html>