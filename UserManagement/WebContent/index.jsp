<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户管理系统</title>
	<script type="text/javascript">
		function topage(currentpage, size) {
			var form = document.forms[0];
			form.offset.value = currentpage;
			form.size.value = size;
			form.submit();
		}
	</script>
</head>
<body>
	<%! int count = 0; %>
	<%
// 	out.println(foo.Counter.getCount());
	%>
	<%=++count %>
	<form>
		<input type="hidden" name="offset" value="0" />
		<input type="hidden" name="size" value="10" />
		数据总条数: ${requestScope.count}
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td></td>
				<td>姓名</td>
				<td>性别</td>
				<td>电话</td>
				
			</tr>
			<c:forEach var="item" items="${requestScope.result}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${item.name}</td>
					<td>${item.gender}</a></td>
					<td>${item.phoneNumber}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>