<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/clientList.css" type="text/css" rel="stylesheet" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="./css/clientList.css" type="text/css" rel="stylesheet" />
<title>客户列表</title>
<!-- 导入jquery文件 -->
<script src="./js/jquery-1.8.0.js"></script>
</head>
<body>
<div class="dialog" style="display:none;">
	<div class="dialog_title">加跟进</div>
	<form action="addClientTrail.do" method="post">
	<div class="dialog_body">
		<input type="hidden" value="${sessionScope.loginStaff.staff_id }" name="staff_id">
		<input type="hidden" name="client_id" id="client_id">
		<select class="select" style="margin-left: 50px;" name="clientTrail_type">
			<option value="1">去电</option>
			<option value="2">勘察</option>
			<option value="3">面谈</option>
			<option value="4">短信</option>
			<option value="5">邮件</option>
			<option value="6">其他</option>
		</select>
		<span>客&nbsp;&nbsp;户</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    <input type="text" readonly="readonly" id="client_name">
		<span style="margin-left: 252px;">联&nbsp;&nbsp;系&nbsp;&nbsp;人</span>&nbsp;&nbsp;   <input type="text" readonly="readonly" id="staff_name">
		<br>
		<textarea rows="10" cols="50" placeholder="勤跟进，多签单……" style="margin-left: 50px; margin-top: 20px; font-size: 15px;" name="clientTrail_content"></textarea>			
	</div>
	<div class="dialog_foot">
		<input type="submit" value="确定" class="dialog_btn" style="background-color: #6DBB47; margin-top: 12px; margin-left: 50px;"> 
		<input type="button" value="取消" class="dialog_btn" onclick="closeDiv()">
	</div>
	</form>
</div>
<!-- 阴影层 -->
<div class="shadow" style="display:none;"></div>

<script type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js"></script>
	  <script type="text/javascript">
	 	var i=remote_ip_info;
	 	$(document).ready(function(){
	 		$.ajax({
	 			type:"post",
	 			url:"findAreaListBycityName.do",
	 			data:{cityName:i['city']+'市'},
	 			dataType:"JSON",
	 			success:function(data){
	 				data = eval("("+data+")");
	 				for(var i=0;i<data.length;i++){
	 					console.log(data[i].area_Id);
	 					$("#areaSel").append("<option value='"+data[i].area.area_Id+"'>"+data[i].area.area_Name+"</option>");
	 				}
	 			}
	 		})
	 	});
</script>

<div class="main">
	<form action="searchByClientReq.do" method="post" id="searchForm">
		<input class="ii" type="hidden" name="staff_id" value="${sessionScope.loginStaff.staff_id }">
		<div class="searchBar" style="border-bottom: 0px; margin-top: 30px;">
			需求区域&nbsp;&nbsp;:&nbsp;&nbsp;
			<select class="select" id="areaSel"  onchange="getStreetByArea();">
					<option>不限区域</option>
				</select>
				&nbsp;&nbsp;
				<select class="select ii" name="siteRequirement" id="streetSel">
				<option value="0">地段要求</option>
			</select>
		</div>
		<div class="searchBar">
			房源需求&nbsp;&nbsp;:&nbsp;&nbsp;
			<select class="select ii" name="room">
				<option value="0">户型</option>
				<option value="1">一室</option>
				<option value="2">二室</option>
				<option value="3">三室</option>
				<option value="4">四室</option>
				<option value="5">五室</option>
				<option value="6">五室以上</option>
			</select>
			&nbsp;&nbsp;价格：&nbsp;&nbsp;
			<input type="number" class="shorttext ii" name="min_price" id="min_price">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="number" class="shorttext ii" name="max_price" id="max_price">&nbsp;&nbsp;万
			&nbsp;&nbsp;面积：&nbsp;&nbsp;
			<input type="number" class="shorttext ii" name="min_area" id="min_area">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="number" class="shorttext ii" name="max_area" id="max_area">&nbsp;&nbsp;平
			&nbsp;&nbsp;楼层：&nbsp;&nbsp;
			<input type="number" class="shorttext ii" name="min_tier" id="min_tier">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="number" class="shorttext ii" name="max_tier" id="max_tier">&nbsp;&nbsp;楼	
		</div>
		<div class="searchBar" style="border-top: 0px;">
			<select class="select ii" name="adornment_Id">
					<option value="0">房屋装修</option>
				<c:forEach items="${houseAdorSelection }" var="adornment"> 
					<option value="${adornment.adornment_Id }">${adornment.adornment_type }</option>
				</c:forEach>
			</select>
			&nbsp;&nbsp;
			<select class="select ii" name="direction_Id">
					<option value="0">房屋朝向</option>
				<c:forEach items="${houseDireSelection }" var="direction"> 
					<option value="${direction.direction_Id }">${direction.direction_type }</option>
				</c:forEach>
			</select>
			&nbsp;&nbsp;
			<select class="select ii" name="client_status">
				<option value="0">客源状态</option>
				<option value="2">未处理</option>
				<option value="3">求购中</option>
				<option value="5">求租中</option>
				<option value="1">已成交</option>
				<option value="4">已搁置</option>
			</select>
			&nbsp;&nbsp;
			<select class="select ii" name="application_Id">
					<option value="0">房屋用途</option>
				<c:forEach items="${houseAppSelection }" var="application"> 
					<option value="${application.application_id }">${application.application_type }</option>
				</c:forEach>
			</select>
			<div class="btn" id="searchBtn">搜索</div>  
			<div class="btn" id="resetBtn" style="color: black;background-color: #DDDDDD; margin-left: 20px;">重置</div>
		</div>
		<input type="hidden" name="page" value="1">
	</form>
	<div id="tableContent">
	<table  class=" table table-hover" id="searchInfoTab" style="width:1115px;">
			<tr>
				<th>序号</th>
				<th>客户姓名</th>
				<th>地段要求</th>
				<th>客户类型</th>
				<th>客户状态</th>
				<th>面积区间</th>
				<th>价格区间</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${clientList }" var="client" varStatus="status">
			<tr id="${client.client_id }">
				<td>${status.index + 1 }</td>
				<td>${client.client_name }</td>
				<c:forEach items="${client.clientReqList }" var="creq">
				<td>${creq.siteRequirement }</td>
					<c:if test="${creq.client_type == 1 }">
					<td>求购</td>
					</c:if>
					<c:if test="${creq.client_type == 2 }">
					<td>求租</td>
					</c:if>
				</c:forEach>
				<c:choose>
					<c:when test="${client.client_status == 1 }">
						<td>已成交</td>
					</c:when>
					<c:when test="${client.client_status == 2 }">
						<td>未处理</td>
					</c:when>
					<c:when test="${client.client_status == 3 }">
						<td>求购中</td>
					</c:when>
					<c:when test="${client.client_status == 4 }">
						<td>已搁置</td>
					</c:when>
					<c:when test="${client.client_status == 5 }">
						<td>求租中</td>
					</c:when>
				</c:choose>
				<c:forEach items="${client.clientReqList }" var="creq">
					<td>${creq.min_area } -- ${creq.max_area }(平)</td>
					<td>${creq.min_price } -- ${creq.max_price }(万元)</td>
				
				<td>
					<a style="text-decoration: none; color:#0B73DF;" class="optBtn">操作▼</a>
					<div class="optDiv">
						<ul class="optUl">
							<c:if test="${client.client_status != 1 }">
								<li><a href="main_editClient.do?client_id=${client.client_id }">编辑</a></li>
								<c:if test="${creq.client_type == 1 }">
								<li><a href="findHouseRsesourceByClientReq.do?staff_id=${sessionScope.loginStaff.staff_id }&application_id=${creq.application_Id }&minPrice=${creq.min_price}&maxPrice=${creq.max_price}&siteRequirement='${creq.siteRequirement }'&flag=1">房源快速匹配</a></li>
								</c:if>
								<c:if test="${creq.client_type == 2  }">
								<li><a href="findHouseRsesourceByClientReq.do?staff_id=${sessionScope.loginStaff.staff_id }&application_id=${creq.application_Id }&minPrice=${creq.min_price}&maxPrice=${creq.max_price}&siteRequirement='${creq.siteRequirement }'&flag=2">房源快速匹配</a></li>
								</c:if>
							</c:if>
							
							<li><a href="javascript:showDialog('${client.client_name }' ,'${sessionScope.loginStaff.staff_name }',${client.client_id });">+加跟进</a></li>
							<c:if test="${client.client_status != 1 }">
								<li style="border-bottom: 0px;"><a href="javascript:deleteSingleClient(${client.client_id });">删除</a></li>
							</c:if>
							
						</ul>							
					</div>
				</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
		<div class="btnToolBar">
			<c:if test="${currentPage != 1 }">
				<button title="首页" onclick="splitPage(1);">&lt;&lt;</button>
			</c:if>
			<c:if test="${currentPage == 1 }">
				<button title="首页" disabled="disabled">&lt;&lt;</button>
			</c:if>
			<c:if test="${currentPage-1 <= 0 }">
				<button title="上一页" disabled="disabled">&lt;</button>
			</c:if>
			<c:if test="${currentPage-1 > 0 }">
				<button title="上一页" onclick="splitPage(${currentPage-1 });">&lt;</button>
			</c:if>
			<button id="selectBtn" disabled="disabled">第 ${currentPage } 页/共 ${totalPage } 页</button>	
			<c:if test="${currentPage == totalPage }"><button title="下一页" disabled="disabled">&gt;</button></c:if>
			<c:if test="${currentPage != totalPage }"><button title="下一页" onclick="splitPage(${currentPage+1 });">&gt;</button></c:if>
			
			<c:if test="${currentPage != totalPage}">
				<button title="末页" onclick="splitPage(${totalPage})">&gt;&gt;</button>
			</c:if>
			<c:if test="${currentPage == totalPage}">
				<button title="末页" disabled="disabled">&gt;&gt;</button>
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
	
	//ajax 是否删除客户
	function deleteSingleClient(clientId){
		//console.log($("#"+clientId));
		var confirmAct = confirm("是否确认删除？");
		if(confirmAct){
			$.ajax({
				type:"post",
				url:"deleteClientById.do",
				data:{"client_id":clientId},
				success:function(data){
						$("#"+clientId).remove();
					}
				})
		}
	}
	
	var staff_id = "${sessionScope.loginStaff.staff_id }";
	var totalPage = "${totalPage }";
	
	//ajax 上一页 下一页 异步请求 
	function splitPage(currentPage){
		
		//如果是当前小于等于0 即为第一页 
		//if(currentPage <= 0){
		//	currentPage = 1;	
	//	}
		//如果是当前大于等于最后一页  即为最后一页  
	//	if(currentPage >=totalPage){
		//	currentPage = totalPage;
	//	}
		
		$.ajax({
			type:"post",
			url:"main_clientList_ajax.do",
			data:{"staff_id":staff_id, 
				  "page":currentPage,
				  "totalPage":totalPage,
				},
			success:function(data){
				$("#tableContent").html(data);
			}
		})
	}
	
	//页面加载时判断数据是否为空  是否出现错误提示信息 
	$(document).ready(function(){
		if(totalPage ==	0){
			$(".btnToolBar").css("display","none");
			$("#errorSerach").css("display","block");
		}
	})
	
	//显示阴影层和浮动层
	function showDialog(clientName,staffName,clientId){
		//传值
		$("#client_name").val(clientName);
		$("#staff_name").val(staffName);
		$("#client_id").val(clientId);
		//显示
		$(".dialog").show();
		$(".shadow").show();
	}
	
	//关闭阴影层和浮动层
	function closeDiv(){
		$(".dialog").hide();
		$(".shadow").hide();
	}
	
	//根据区获取街道 
	function getStreetByArea(){
		var areaId = $("#areaSel").val();
		$("#streetSel").html("");
		$("#streetSel").append("<option value='0'>"+'地段要求'+"</option>");
		$.ajax({
			type:"post",
			url:"findStreetListByAreaId.do",
			data:{"area_Id":areaId},
			dataType:"JSON",
			success:function(data){
				data = eval("("+data+")");
				for(var i= 0;i<data.length;i++){
					$("#streetSel").append("<option value='"+data[i].street.street_Name+"'>"+data[i].street.street_Name+"</option>");
				}
			}
		})
	}
	
	
</script>
</html>