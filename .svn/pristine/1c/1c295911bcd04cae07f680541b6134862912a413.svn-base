<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered table-hover">
	<tr>
		<td>序号</td>
		<td>跟进类型</td>
		<td>交易类型</td>
		<td>跟进人</td>
		<td>跟进时间</td>
		<td>跟进内容</td>
	</tr>
	<c:forEach var="house" items="${houseList}" varStatus="index">
			<tr >
				<td>${index.count}</td>
				<c:if test="${house.houseTrail_type==1}">
				<td>去电</td>
				</c:if>
				<c:if test="${house.houseTrail_type==2}">
				<td>来电</td>
				</c:if>
				<c:if test="${house.houseTrail_type==3}">
				<td>勘察</td>
				</c:if>
				<c:if test="${house.houseTrail_type==4}">
				<td>其他</td>
				</c:if>
				<c:if test="${house.houseResource.status==3}">
				<td>出售中</td>
				</c:if>
				<c:if test="${house.houseResource.status==4}">
				<td>已成交</td>
				</c:if>
				<td>${house.staff.staff_name}</td>				
				<td><fmt:formatDate value="${house.houseTrail_time}" pattern="yyyy-MM-dd"/> </td>
				<td>${house.houseTrail_content}</td>			
			</tr>
			
		</c:forEach>
</table>
<c:forEach begin="${start}" end="${end}" step="1" var="i">
				<c:if test="${i == pageNum}">
					<a class="btn btn-default  btn-lg active" role="button" href="main_SellHouseTrailList.do?pageNum=${i}">${i}</a>
				</c:if>
				<c:if test="${i != pageNum}">
					<a class="btn btn-default btn-lg active" role="button" href="main_SellHouseTrailList.do?pageNum=${i}">${i}</a>
				</c:if>
	</c:forEach><br>
	当前页为第${pageNum}页，共${totalPage}页，总计${count}条记录
</body>
</html>