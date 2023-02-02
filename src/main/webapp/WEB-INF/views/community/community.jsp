<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>community.jsp</title>
</head>
<body>

<c:if test="${sessionScope.loginMember != null }">
		<table id="snsWriteArea"><tr><td>
			<form action="community.search" name="communitySearchForm" onsubmit="return snsSearchCheck();">
				<table id="snsSearchTable">
					<tr><td id="sstTd1"><input name="search" maxlength="10" autocomplete="off" placeholder="찾기"><button>검색</button></td></tr>
				</table>
			</form></td>
				<td id="snsWriteAreaSummoner" align="center" rowspan="2" style="background-color: #F44336; border-radius: 0px 20px 20px 0px; cursor: pointer;">
			</tr>
			<tr><td align="center">
				<form action="community.write" name="communityWriteForm" 
					onsubmit="return communityWriteCheck();">
					<input name="token" value="${token }" type="hidden">
					
						<table id="snsWriteTable">
							<tr><td id="swtTd1"><textarea name="c_txt" placeholder="글을 쓰세요" autofocus="autofocus" autocomplete="off" maxlength="250"></textarea></td></tr>
							<tr><td><button>게시</button></td></tr>
						</table>
					</form></td></tr>
		</table>
	</c:if>




<c:if test="${curPage != 1 }">
		<table id="snsL" border="1">
			<tr>
				<td align="center"><a href="snsPageChange(${curPage - 1 })">&lt;</a></td>
			</tr>
		</table>
	</c:if>

<c:if test="${curPage != allPageCount }">
		<table id="snsR" border="1">
			<tr><td align="center"><a href="snsPageChange(${curPage + 1 })">&gt;</a></td></tr>
		</table>
	</c:if>



<c:forEach var = "community" items="${msgs }">
<table class="communityTb1" border="1">
	<tr>
		<td class="communityowner">-ID- ${community.m_id }</td>
		
		<td><fmt:formatDate value="${community.c_when }" type="both" 
			dateStyle="long" timeStyle="short"/> 
		</td>
		
	</tr>
	
		<tr><td class="communitytxt" colspan="2">-게시글- ${community.c_txt }</td></tr>
	<tr><td id="smReplyArea">
			<c:forEach var="Community_comment" items="${community.c_c }">
						<c:choose>
							<c:when test="${Community_comment.cc_owner == sessionScope.loginMember.m_id }">
								<span ondblclick="Community_commentDelete('${Community_comment.cc_no}');"
									class="smReplyID">${Community_comment.cc_owner }</span>
							</c:when>
							<c:otherwise>
								<span class="smReplyID">-ID- ${Community_comment.cc_owner }</span>
							</c:otherwise>
						</c:choose>
						<td>(<fmt:formatDate value="${Community_comment.cc_when }" type="both"
							dateStyle="short" timeStyle="short" />)<br></td>
						<tr><td colspan="2">- 댓글 -${Community_comment.cc_txt }</td></tr>
					</c:forEach> <c:if test="${sessionScope.loginMember != null }">
						
						<form action="community.comment.write" 
							onsubmit="return Community_commentWriteCheck(this);">
							<input name="token" value="${token }" type="hidden"> <input
								name="cc_c_no" value="${community.c_no }" type="hidden"> 
								<span class="smReplyID">${sessionScope.loginMember.m_id }</span>
							<input name="cc_txt" maxlength="100" placeholder="댓글을 쓰세요" autocomplete="off">
							<button>입력</button>
						</form>
					</c:if></td>
			</tr>
			
	<c:if test="${community.m_id ==sessionScope.loginMember.m_id }">
	<tr>
		<td colspan="2" align="right" class="communityBtn">
		<button onclick="communityUpdate(${community.c_no}, '${community.c_txt }')">수정</button>
		<button onclick="communityDelect(${community.c_no})">삭제</button>
		</td>
	</tr>
	</c:if>
	
	
</table>
</c:forEach>
</body>
</html>