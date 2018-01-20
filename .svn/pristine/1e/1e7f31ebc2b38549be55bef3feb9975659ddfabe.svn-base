<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="./css/checkAttendance.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<body>
	<div>
		<h2>我带看的出售房源</h2>
		<table border="1" cellpadding="0" cellspacing="0" class="tab" bordercolor="grey" class="tab">
			<tr class="rows title">
				<td>序号</td>
				<td>房源id</td>
				<td>总价</td>
				<td>房源标题</td>
				<td>员工id</td>
				<td>▼操作</td>
			</tr>
			
			<c:forEach var="look1" items="${myLook1List}" varStatus="index">		
			<tr class="rows">
				<td>${index.count}</td>
				<td>${look1.houseResource_id}</td>
				<td>${look1.total_price}</td>
				<td>${look1.houseResource_title}</td>
				<td>${look1.staff_id}</td>
				<td><a href="">+跟进</a></td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
<script>
$(".rows:odd").css("backgroundColor","#F1F1F1");
</script>
</html>