<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
<form action="member.join" method="post" name="signup" onsubmit="return signupCheck()">
<table id="joinTbl">
			<tr>
				<td align="center" colspan="2"><input id="join_m_id" name="m_id" placeholder="ID를 입력하세요" class="i1" autocomplete="off" autofocus="autofocus" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password" name="m_password" placeholder="비밀번호를 입력하세요" class="i1" autocomplete="off" maxlength="20"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password" name="m_passwordCh" placeholder="비밀번호를 한번더 입력하세요" class="i1" autocomplete="off" maxlength="20"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="m_name" placeholder="이름을 입력하세요" class="i1" autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="m_phone" placeholder="전화번호를 입력하세요" class="i1" autocomplete="off" maxlength="13"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				<input id="join_m_addr1" name="m_addr1" placeholder="우편번호" class="i1" autocomplete="off"><br>
				<input id="join_m_addr2" name="m_addr2" placeholder="주소" class="i1" autocomplete="off"><br>
				<input name="m_addr3" maxlength="50" placeholder="상세주소" class="i1" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="m_email" placeholder="이메일을 입력하세요" class="i1" autocomplete="off" maxlength="20"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><select name="m_pwchque">
				<option>기억에 남는 선생님은?</option>
				<option>자신의 인생 좌우명은?</option>
				<option>초등학생때 별명은?</option>
				<option>가장 인상깊게 읽었던 책은?</option>
				<option>지금 생각나는 드라마는?</option>
				</select></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="m_pwchans" placeholder="비밀번호 확인 답변" class="i1" autocomplete="off" maxlength="30"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>가입하기</button></td>
			</tr>
		</table>
</form>
</body>
</html>