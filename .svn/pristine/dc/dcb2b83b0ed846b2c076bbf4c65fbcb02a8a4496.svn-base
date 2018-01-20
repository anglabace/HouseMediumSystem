<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工通讯录</title>
</head>
<link href="./css/contacts.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<body>
	<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
		<tr class="rows title">
			<td></td>
			<td>员工姓名</td>
			<td>员工性别</td>
			<td>联系电话</td>
			<td>QQ</td>
		</tr>
		<c:forEach var="staff" items="${staffList}" varStatus="index">
			<tr class="rows">
				<td>${index.count}</td>
				<td>${staff.staff_name}</td>
				<td>${staff.sex}</td>
				<td>${staff.telephone}</td>				
				<td>${staff.QQ}</td>				
			</tr>
		</c:forEach>
	</table>
			<c:forEach begin="${start}" end="${end}" step="1" var="i">
				<c:if test="${i == pageNum}">
					<a class="folio foliostyle" href="contacts.do?pageNum=${i}">${i}</a>
				</c:if>
				<c:if test="${i != pageNum}">
					<a class="folio" href="contacts.do?pageNum=${i}">${i}</a>
				</c:if>
			</c:forEach><br>
			当前页为第${pageNum}页，共${totalPage}页，总计${count}条记录
</body>
<script>
	$(".rows:odd").css("backgroundColor","#F1F1F1");
	$(".rows").mouseenter(function(){
		if($(this).index() != 0){
			$(this).css("backgroundColor","#F5F5F5");
		}
	}).mouseleave(function(){
		if($(this).index()%2 == 0){
			$(this).css("backgroundColor","#FFFFFF");
		}else{
			$(this).css("backgroundColor","#F1F1F1");
		}
	})
</script>
</html>