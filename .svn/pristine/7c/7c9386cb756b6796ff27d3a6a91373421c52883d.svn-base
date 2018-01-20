<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="./css/css.css" type="text/css" rel="stylesheet" />
<link href="./css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="./images/main/favicon.ico" />
<script src="./js/jquery-1.8.0.js"></script>
<link href="./css/rentContractInfo.css" type="text/css" rel="stylesheet" />
<body>
	<div>合同信息</div>
	<hr>
	<div class="baseInfo">
		<div class="ower">
			<table>
				<tr>
					<td>房源方:</td>
					<td colspan="2"><input type="text" disabled="false" value="${owner.owner_name}" ></td>
					<td>&nbsp;&nbsp;类型：</td>
					<td colspan="2">
						<c:if test="${house.application_id == 1}">
							<input type="text" disabled="false" value="自建房">
						</c:if>
						<c:if test="${house.application_id == 2}">
							<input type="text" disabled="false" value="写字楼">
						</c:if>
						<c:if test="${house.application_id == 3}">
							<input type="text" disabled="false" value="仓库">
						</c:if>
						<c:if test="${house.application_id == 4}">
							<input type="text" disabled="false" value="商铺">
						</c:if>
						<c:if test="${house.application_id == 5}">
							<input type="text" disabled="false" value="住宅">
						</c:if>
						<c:if test="${house.application_id == 6}">
							<input type="text" disabled="false" value="别墅">
						</c:if>
					</td>
				</tr>
				<tr>
					<td>房源地址：</td>
					<td colspan="5"><input type="text" disabled="false" value="${house.neighborHood.neighborHood_Name}"></td>
				</tr>
				<tr>
					<td>租金:</td>
					<td><input type="text" disabled="false" value="${house.rent}"></td>
					<td>&nbsp;元</td>
					<td>&nbsp;&nbsp;面积：</td>
					<td><input type="text" disabled="false" value="${house.build_areas}"></td>
					<td>&nbsp;平米</td>
				</tr>
				<tr>
					<td>租期：</td>
					<td><input type="text" disabled="false" value="${contract.lease}"></td>
					<td>&nbsp;月</td>
					<td>&nbsp;&nbsp;房主手机:</td>
					<td colspan="2"><input type="text" disabled="false" value="${owner.telephone}"></td>
				</tr>
			</table>
		</div>
		<div class="client">
			<table>
				<tr>
					<td>客源方：</td>
					<td colspan="2"><input type="text" disabled="false" value="${client.client_name}"></td>
					<td>&nbsp;&nbsp;房客手机:</td>
					<td colspan="2"><input type="text" disabled="false" value="${client.telephone}"></td>
				</tr>	
				<tr>
					<td>联系地址：</td>
					<td colspan="5"><input type="text" disabled="false" value="${client.address}"></td>
				</tr>
				<tr>
					<td>代理人：</td>
					<td colspan="2"><input type="text" disabled="false" value="${loginStaff.staff_name}"></td>
					<td>&nbsp;&nbsp;代理电话：</td>
					<td colspan="2"><input type="text" disabled="false" value="${staff.telephone}"></td>
				</tr>
				<tr>
					<td>合同时间：</td>
					<td colspan="5"><input type="text" disabled="false" value="<fmt:formatDate value="${contract.contract_Time}" pattern="yyyy-MM-dd"/>"></td>
				</tr>
			</table>
			
		</div>
	</div>
</body>
<script>

</script>
</html>