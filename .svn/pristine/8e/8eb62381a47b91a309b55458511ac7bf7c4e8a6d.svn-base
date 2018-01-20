<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电子考勤</title>
</head>
<!-- 外部样式与脚本 -->
<link href="./css/checkAttendance.css" type="text/css" rel="stylesheet" />
<link href="./css/fliptimer.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.fliptimer.js"></script>

<body>
	<div class="bg1">
		<div class="clear">
			<div class="float1"><h2>电子考勤</h2></div>
			<div class="dowebok float2">
				<div class="hours"></div>
				<div class="minutes"></div>
				<div class="seconds"></div>
			</div>
		</div>
		<div class="word3 "><a href="addAttendance.do?staff_id=${loginStaff.staff_id}">考勤</a></div>
		<table border="1" cellpadding="0" cellspacing="0" class="tab" bordercolor="grey">
			<tr class="word1">
				<td>序号</td>
				<td>本月考勤记录</td>
			</tr>
			<c:forEach var="attendance" items="${attendanceList}" varStatus="index">		
			<tr class="word2">
				<td>${index.count}</td>
				<td><fmt:formatDate value='${attendance.onDutyTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
			</tr>
			</c:forEach>
		</table>
		<c:forEach begin="${start}" end="${end}" step="1" var="i">
				<c:if test="${i == pageNum}">
					<a class="folio foliostyle" href="checkAttendance.do?pageNum=${i}">${i}</a>
				</c:if>
				<c:if test="${i != pageNum}">
					<a class="folio" href="checkAttendance.do?pageNum=${i}">${i}</a>
				</c:if>
		</c:forEach><br>
		当前页为第${pageNum}页，共${totalPage}页，共${count}条记录
		
	</div>
</body>
<script>
	$(".word2:odd").css("backgroundColor","#F1F1F1");
	$(function(){
		$('.dowebok').flipTimer({
			seconds: true
		});
	});
	
</script>
</html>