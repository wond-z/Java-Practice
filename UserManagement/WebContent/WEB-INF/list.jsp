<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td></td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			
		</tr>
		
		<c:forEach items="${list}" var="map">
			<tr>
				<td>${map["name"]}</td>
				<td>${map["gender"]}</a></td>
				<td>${map["phone_number"]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>