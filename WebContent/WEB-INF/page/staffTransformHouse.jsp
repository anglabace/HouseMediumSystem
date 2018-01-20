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
<!-- 外部样式与脚本 -->
<link href="./css/checkAttendance.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>

<body>
	<div class="bg2">
		<h2>业务员转移房源</h2>
		<div class="word3"><a href="selectStaffId.do">转移房源</a></div>
		<table border="1" cellpadding="0" cellspacing="0" class="tab" bordercolor="grey">
			<tr class="word1">
				<td>序号</td>
				<td>房源id</td>
				<td>房源描述</td>
				<td>员工id</td>
			</tr>
			<c:forEach var="houseResource" items="${houseResourceList}" varStatus="index">		
			<tr class="word2">
				<td>${index.count}</td>
				<td>${houseResource.houseResource_id}</td> 
				<td>${houseResource.houseResource_describe }</td>
				<td>${houseResource.staff_id}</td>
				
			</tr>
			</c:forEach>
		</table>
		<c:forEach begin="${start}" end="${end}" step="1" var="i">
				<c:if test="${i == pageNum}">
					<a class="folio foliostyle" href="staffTransformHouse.do?pageNum=${i}">${i}</a>
				</c:if>
				<c:if test="${i != pageNum}">
					<a class="folio" href="staffTransformHouse.do?pageNum=${i}">${i}</a>
				</c:if>
		</c:forEach><br>
		当前页为第${pageNum}页，共${totalPage}页，共${count}条记录
	</div>

</body>
<script>
	$(".word2:odd").css("backgroundColor","#F1F1F1");
</script>
</html>