<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出售房列表</title>
<link href="./css/clientList.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="./js/jquery-1.8.0.js"></script>
<style>
	.tab{
		width: 1050px;
		text-align: center;
		line-height: 30px;
	}
	.rows{
		height: 30px;
	}
	.title{
		font-weight: bold;
		font-size: 14px;
	}
	.folio{
		text-decoration: none;
		display:inline-block;
		height: 30px;
		width: 30px;
		border: 1px solid rgba(19,58,124,1.00);
		margin-top: 20px;
		margin-left: 50px;
		text-align: center;
		line-height: 30px;
		position: relative;
		left: 200px;
	}
	.foliostyle{
		background-color:silver;
	}
	.viewArea{
		
		width: 1050px;
		overflow: auto;
	}
</style>
</head>
<body>
<div class="main">
	<form action="searchHouse.do" method="post" onsubmit="return searchHouse()">
	<div class="searchBar">
			户型&nbsp;&nbsp;:&nbsp;&nbsp;
			<select class="select ii" name="room">
				<option value="0">户型</option>
				<option value="1">一室</option>
				<option value="2">二室</option>
				<option value="3">三室</option>
				<option value="4">四室</option>
				<option value="5">五室</option>
				<option value="6">五室以上</option>
			</select>
			&nbsp;&nbsp;
			房屋类型&nbsp;&nbsp;:&nbsp;&nbsp;
			<select class="select ii" name="application_Id">
					<option value="0">房屋类型</option>
				<c:forEach items="${houseAppSelection }" var="application"> 
					<option value="${application.application_id }">${application.application_type }</option>
				</c:forEach>
			</select>
	</div>
	<div class="searchBar" style="border-top: 0px;">
			房屋装修&nbsp;&nbsp;:&nbsp;&nbsp;
			<select class="select ii" name="adornment_Id">
					<option value="0">房屋装修</option>
				<c:forEach items="${houseAdorSelection }" var="adornment"> 
					<option value="${adornment.adornment_Id }">${adornment.adornment_type }</option>
				</c:forEach>
			</select>
			&nbsp;&nbsp;
			房屋朝向&nbsp;&nbsp;:&nbsp;&nbsp;
			<select class="select ii" name="direction_Id">
					<option value="0">房屋朝向</option>
				<c:forEach items="${houseDireSelection }" var="direction"> 
					<option value="${direction.direction_Id }">${direction.direction_type }</option>
				</c:forEach>
			</select>
			&nbsp;&nbsp;
			<input type="submit" value="搜索" class="btn" id="searchBtn"></input>  
			<input type="reset" value="重置" class="btn" id="resetBtn" style="color: black;background-color: #DDDDDD; margin-left: 20px;"></input>
		</div>
	</form>
	<div class="viewArea">
	<table class="table table-bordered table-hover">
		<tr>
			<td>序号</td>
			<td>楼盘名称</td>
			<td>户型</td>
			<td>面积</td>
			<td>楼层</td>
			<td>最低价位</td>
			<td>房源状态</td>
			<td>业主姓名</td>
			<td>发布时间</td>
			<td>操作</td>
		</tr>
		<c:forEach var="house" items="${houseList}" varStatus="index">
			<tr >
				<td>${index.count}</td>
				<td>${house.neighborHood.neighborHood_Name}</td>
				<td>${house.room}室</td>
				<td>${house.inside_areas}平米</td>				
				<td>${house.tier}楼/共${house.total_tiers}楼</td>
				<td><fmt:formatNumber value="${house.total_price}" type="currency"/>元</td>
				<c:if test="${house.status==3}">
				<td>出售中</td>
				</c:if>
				<c:if test="${house.status==4}">
				<td>已成交</td>
				</c:if>
				<td>${house.owner.owner_name}</td>
				<td><fmt:formatDate value="${house.publishTime}" pattern="yyyy-MM-dd"/> </td>
				<td>
					<a style="text-decoration: none; color:#0B73DF;" class="optBtn">操作▼</a>
					<div class="optDiv">
						<ul class="optUl">
							<!-- <li><a href="javascript:showDialog('${house.owner.owner_name }' ,'${sessionScope.loginStaff.staff_name }',${client.client_id });">+加跟进</a></li> -->
							<li style="border-bottom: 0px;"><a href="javascript:deleteSingleHouse(${house.houseResource_id });">删除</a></li>
						</ul>							
					</div>
				</td>				
			</tr>
			
		</c:forEach>
	</table>
	
	</div>
	<c:forEach begin="${start}" end="${end}" step="1" var="i">
				<c:if test="${i == pageNum}">
					<a class="folio foliostyle" href="main_viewHouseList.do?pageNum=${i}">${i}</a>
				</c:if>
				<c:if test="${i != pageNum}">
					<a class="folio" href="main_viewHouseList.do?pageNum=${i}">${i}</a>
				</c:if>
	</c:forEach><br>
	当前页为第${pageNum}页，共${totalPage}页，总计${count}条记录
</div>
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
	
	//为操作按钮绑定事件
	$(".optBtn").click(function(){
		var sourcePosition = $(this).offset();
		if($(".optDiv:visible").css("display")=="block"){
			$(".optDiv:visible").hide("slow");
		}
		else{
			$(this).next().show("slow");
		}
	})
	//鼠标移入会变色操作选项框
	$(".optUl>li").mouseenter(function(){
		$(this).css("background-color","white");
	}).mouseleave(function(){
		$(this).css("background-color","#F1F1F1");		
	})
	function deleteSingleHouse(houseId){
		//console.log($("#"+clientId));
		var confirmAct = confirm("是否确认删除？");
		if(confirmAct){
			console.log(houseId);
			window.location.href="deleteHouse.do?houseId="+houseId 
		}
		
	}
	function searchHouse(){
		if($('[name="room"]').val()==0){
			alert("请选择户型")
			return false
		}
		if($('[name="application_Id"]').val()==0){
			alert("请选择房屋类型")
			return false
		}
		if($('[name="adornment_Id"]').val()==0){
			alert("请选择房屋装修")
			return false
		}
		if($('[name="direction_Id"]').val()==0){
			alert("请选择房屋朝向")
			return false
		}
		return false
	}
</script>
</html>