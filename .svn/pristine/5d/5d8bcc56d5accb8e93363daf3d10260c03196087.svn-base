<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户跟进列表</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="./css/clientList.css" type="text/css" rel="stylesheet" />
</head>
<!-- 导入jquery文件 -->
<script src="./js/jquery-1.8.0.js"></script>
<body>
<div class="main">
	<form action="searchByClientTrail.do" method="post" id="searchForm">
		<input type="hidden" value="${sessionScope.loginStaff.staff_id }" name="staff_id" >
		<div class="searchBar" style="margin-top: 30px;">
				&nbsp;&nbsp;跟进时间&nbsp;&nbsp;
				<input type="date" class="timeText ii" placeholder="开始时间" name="startTime" style="width:150px;">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="date" class="timeText ii" placeholder="结束时间" name="endTime"  style="width:150px;">&nbsp;&nbsp;
				<select class="select ii" name="clientTrail_type">
					<option value="0">跟进类型</option>
					<option value="1">去电</option>
					<option value="2">勘察</option>
					<option value="3">面谈</option>
					<option value="4">短信</option>
					<option value="5">邮件</option>
					<option value="6">其他</option>
				</select>
				<div class="btn" id="searchBtn" style="margin-left:300px;">搜索</div>  
				<div class="btn" id="resetBtn" style="color: black;background-color: #DDDDDD; margin-left: 10px;">重置</div>
			</div>
			<input type="hidden" name="page" value="1">
	</form>
	<div id="tableContent">
		<table  class=" table table-hover" id="searchInfoTab" style="width:1115px;">
				<tr>
					<th>序号</th>
					<th>跟进类型</th>
					<th>客户姓名</th>
					<th>跟进内容</th>
					<th>跟进时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${clientTrailList }" var="clientTrail" varStatus="staus">
					<tr id="${clientTrail.clientTrail_ID }">
						<td>${staus.index + 1 }</td>
						<c:choose>
							<c:when test="${clientTrail.clientTrail_type == 1 }">
								<td>去电</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 2 }">
								<td>勘察</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 3 }">
								<td>面谈</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 4 }">
								<td>短信</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 5 }">
								<td>邮件</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 6 }">
								<td>其他</td>
							</c:when>
						</c:choose>
						<td>${clientTrail.client_name }</td>
						<td>${clientTrail.clientTrail_content }</td>
						<td><fmt:formatDate value="${clientTrail.clientTrail_Time }" pattern="yyyy-MM-dd  HH:mm" /></td>
						<td>
							<a style="text-decoration: none; color:#0B73DF;" class="optBtn">操作▼</a>
							<div class="optDiv">
								<ul class="optUl">
									<li style="border-bottom: 0px;"><a href="javascript:deleteSingleClientTrail(${clientTrail.clientTrail_ID });">删除</a></li>
								</ul>							
							</div>
						</td>
					</tr>
				</c:forEach>
		</table>
		
	<div class="btnToolBar" >
		<c:if test="${currentPage == 1 }">	
		<button title="首页" disabled="disabled">&lt;&lt;</button>
		</c:if>
		<c:if test="${currentPage != 1 }">	
		<button title="首页" onclick="splitPage(1)">&lt;&lt;</button>
		</c:if>
		<c:if test="${currentPage-1 <= 0 }">
		<button title="上一页" disabled="disabled">&lt;</button>
		</c:if>	
		<c:if test="${currentPage-1 > 0 }">
		<button title="上一页" onclick="splitPage(${currentPage-1})">&lt;</button>
		</c:if>
		<button id="selectBtn" disabled="disabled">第 ${currentPage } 页/共 ${totalPage } 页</button>
		<c:if test="${currentPage == totalPage }">		
			<button title="下一页" disabled="disabled">&gt;</button>
		</c:if>
		<c:if test="${currentPage != totalPage }">
			<button title="下一页" onclick="splitPage(${currentPage+1})">&gt;</button>
		</c:if>		
		<c:if test="${currentPage == totalPage }">	
		<button title="末页" disabled="disabled">&gt;&gt;</button>
		</c:if>
		<c:if test="${currentPage != totalPage }">	
		<button title="末页" onclick="splitPage(${totalPage})">&gt;&gt;</button>
		</c:if>
		
	</div>
	<center><div style="color:red; font-size:20px;font-weight: 600; display: none;" id="errorSerach">未找到任何数据 请重新搜索!!!</div></center>	
</div>
</div>
</body>
<script type="text/javascript">

	//给搜索div按钮绑定事件
	$("#searchBtn").click(function(){
		//获取表单对象
		var searchform = $("#searchForm");
		$("#searchForm .ii").each(function(){
			//如果表单对象的值为空 则移除name 即不上传表单
			if(this.value == ""||this.value == 0){
				$(this).removeAttr("name");
			}
		})
		$("#searchForm").submit();	
	})
	
	//给重置div按钮绑定事件
	$("#resetBtn").click(function(){
		document.getElementById("searchForm").reset();	
	})
	
	//页面加载时判断数据是否为空  是否出现错误提示信息 
	$(document).ready(function(){
		if(totalPage ==	0){
			$(".btnToolBar").css("display","none");
			$("#errorSerach").css("display","block");
		}
	})
	
	//为操作按钮绑定事件
	$(".optBtn").click(function(){
		//var sourcePosition = $(this).offset();
		if($(this).next().css("display") == "none"){
			$(this).next().show("slow");
		}else if($(this).next().css("display") == "block"){
			$(this).next().hide("slow");
		}
		
		//$(".optDiv").offset({top:sourcePosition.top+10,left:sourcePosition.left})
		//$(".optDiv").show("slow");
		
	})
	
	//鼠标移入会变色操作选项框
	$(".optUl>li").mouseenter(function(){
		$(this).css("background-color","white");
	}).mouseleave(function(){
		$(this).css("background-color","wheat");		
	})
	
	//ajax 是否删除客户跟进记录 
	function deleteSingleClientTrail(clientTrailId){
		console.log($("#"+clientTrailId));
		var confirmAct = confirm("是否确认删除？");
		if(confirmAct){
			$.ajax({
				type:"post",
				url:"deleteClientTrail.do",
				data:{"clientTrail_id":clientTrailId},
				success:function(data){
						$("#"+clientTrailId).remove();
					}
				})
		}
	}
	
	var staff_id = "${sessionScope.loginStaff.staff_id }";
	var totalPage = "${totalPage }";
	
	//ajax 上一页 下一页 
	function splitPage(currentPage){
		$.ajax({
			type:"post",
			url:"main_clientTrailList_ajax.do",
			data:{
					"staff_id":staff_id,
					"page":currentPage,
					"totalPage":totalPage,
				},
			success:function(data){
				$("#tableContent").html(data);
			}
			
		})
	}
</script>
</html>