<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.tab{
		width: 1000px;
		text-align: center;
		line-height: 30px;
	}
</style>
</head>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<body>
	<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
		<tr>
			<td>合同编号</td>
			<td>物业地址</td>
			<td>业主姓名</td>			
			<td>租金</td>
			<td>出租开始</td>
			<td>租期</td>
			<td>客户姓名</td>
			<td>签约人</td>
			<td>签约时间</td>			
			<td>操作</td>
		</tr>
		<c:forEach var="rent" items="${rentList}">
			<tr>
				<td>${rent.contract_id}</td>
				<td>${rent.house.neighborHood.neighborHood_Name}</td>
				<td>${rent.house.owner.owner_name}</td>
				<td>${rent.contract_price}</td>
				<td><fmt:formatDate value="${rent.start_day}" pattern="yyyy-MM-dd"/></td>
				<td>${rent.lease}</td>
				<td>${rent.client.client_name}</td>
				<td>${loginStaff.staff_name}</td>
				<td><fmt:formatDate value="${rent.contract_Time}" pattern="yyyy-MM-dd"/></td>
				<td><a href="showRentContract.do?client_id=${rent.client.client_id}&house_id=${rent.house.houseResource_id}&owner_id=${rent.house.owner.owner_id}&staff_id=${loginStaff.staff_id}&contract_id=${rent.contract_id}">查看具体信息</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>