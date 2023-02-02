<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="resources/css/indexcss.css">
<link rel="stylesheet" href="resources/css/communitycss.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/KwonValidChecker.js"></script>
<script type="text/javascript" src="resources/js/signup.js"></script>
<link rel="stylesheet" type="text/css" href="https://s3.ap-northeast-2.amazonaws.com/materials.spartacodingclub.kr/bucketList/sparta-bucket2.css">

</head>

<body>
	<table id = "siteTitleTbl">
		<tr><td id="siteTitle" align="center"><a href="index.go">HOME</a></td>
		<td id="siteMenu" align="center"><a href="community.go">Board</a></td></tr>
	</table>
		
		<table id = "siteContentTbl">
			<tr><td id = "siteContent" align="center"><jsp:include page="${contentPage }"/></td></tr>
		</table>
		
<table id = "siteLoginTbl">
	<tr>
		<td><jsp:include page="${loginPage }"/><span id = "dbResult">${r }</span></td>
	</tr>
	</table>

</body>
</html>