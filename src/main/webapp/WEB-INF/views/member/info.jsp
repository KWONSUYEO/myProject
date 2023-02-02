<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
<style type="text/css">
#Tb{
margin-top: 150px;
}
body {
	font-size: 30pt;
}

</style>
</head>
<body>
<table border="1" id = "Tb">
<form action="member.update" method="post" name="updateForm" onsubmit="return memberUpdateCheck()">
<tr><th>내 정보</th></tr>
<tr><td>ID <input name="m_id" value="${sessionScope.loginMember.m_id }" readonly="readonly"></td></tr>
<tr><td>비밀번호 <input name="m_password" value="${sessionScope.loginMember.m_password }" 
		autofocus="autofocus" autocomplete="off" type="password"></td></tr>
<tr><td>비밀번호 확인 <input name="m_passwordChk" value="${sessionScope.loginMember.m_password }" 
		autocomplete="off" type="password"></td></tr>
<tr><td>이름 <input name="m_name" value="${sessionScope.loginMember.m_name }"></td></tr>
<tr><td>전화번호 <input name="m_phone" value="${sessionScope.loginMember.m_phone }"></td></tr>
<tr><td align="center" colspan="2">우편번호<input id="join_m_addr1"	value="${add[2] }" readonly="readonly" 
		name="m_addr1"	placeholder="우편번호" class="i1"><br>
					주소<input id="join_m_addr2" value="${add[0] }" readonly="readonly"
					name="m_addr2" placeholder="주소" class="i1"><br>
					상세주소<input name="m_addr3" value="${add[1] }" maxlength="50"
					placeholder="상세주소" class="i1" autocomplete="off"></td></tr>

<tr><td>이메일 <input name="m_email" value="${sessionScope.loginMember.m_email }"></td></tr>
<tr><td align="center" colspan="2">비밀번호 확인질문<select name="m_pwchque">
				<option>기억에 남는 선생님은?</option>
				<option>자신의 인생 좌우명은?</option>
				<option>초등학생때 별명은?</option>
				<option>가장 인상깊게 읽었던 책은?</option>
				<option>지금 생각나는 드라마는?</option>
				</select></td></tr>
<tr><td>비밀번호 확인 답변 <input name="m_pwchans" value="${sessionScope.loginMember.m_pwchans }"></td></tr>
	<tr><td><button>정보수정</button>
	</form>
	<button onclick="withdraw();">탈퇴</button></td>
	</tr>
	</table>
</body>
</html>