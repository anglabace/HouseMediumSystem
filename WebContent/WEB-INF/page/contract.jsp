<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<link href="./css/contract.css" type="text/css" rel="stylesheet" />
<body class="body">

	<div class="showSellHouseInfo showText">
		<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
			<tr>
				<td>房源编号</td>
				<td>楼盘名称</td>
				<td>户型</td>
				<td>售价</td>
				<td>面积</td>
				<td>楼层</td>
				<td>房源状态</td>
				<td>发布人</td>
			</tr>
			<c:forEach var="house" items="${houseSell}">
				<tr>
					<td><input type="radio" name="house1" value="${house.houseResource_id}">${house.houseResource_id}</td>
					<td>${house.neighborHood.neighborHood_Name}</td>
					<td>${house.room}&nbsp;室&nbsp;${house.hall}&nbsp;厅&nbsp;${house.toilet}&nbsp;卫</td>
					<td>${house.total_price/10000}</td>

					<td>${house.build_areas}</td>
					<td>${house.tier}&nbsp;层</td>
					<td>
						<c:if test="${house.status==1}">
							出租中
						</c:if>
						<c:if test="${house.status==2}">
							已下架
						</c:if>
						<c:if test="${house.status==3}">
							出售中
						</c:if>
						<c:if test="${house.status==4}">
							已成交
						</c:if>
					</td>
					<td>${loginStaff.staff_name}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btn2 btn">确认</div>
	</div>
	<div class="showRentHouseInfo showText">
		<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
			<tr>
				<td>房源编号</td>
				<td>楼盘名称</td>
				<td>户型</td>
				<td>租金</td>
				<td>面积</td>
				<td>楼层</td>
				<td>房源状态</td>
				<td>发布人</td>
			</tr>
			<c:forEach var="house" items="${houseRent}">
				<tr>
					<td><input type="radio" name="house2" value="${house.houseResource_id}">${house.houseResource_id}</td>
					<td>${house.neighborHood.neighborHood_Name}</td>
					<td>${house.room}&nbsp;室&nbsp;${house.hall}&nbsp;厅&nbsp;${house.toilet}&nbsp;卫</td>
					<td>${house.rent}</td>

					<td>${house.build_areas}</td>
					<td>${house.tier}&nbsp;层</td>
					<td>
						<c:if test="${house.status==1}">
							出租中
						</c:if>
						<c:if test="${house.status==2}">
							已下架
						</c:if>
						<c:if test="${house.status==3}">
							出售中
						</c:if>
						<c:if test="${house.status==4}">
							已成交
						</c:if>
					</td>
					<td>${house.owner.owner_name}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btn4 btn">确认</div>
	</div>
	<div class="showSellClientInfo showText">
		<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
				<tr>
					<td>客户编号</td>
					<td>客户姓名</td>
					<td>负责人</td>
					<td>状态</td>
					<td>客户类型</td>
					<td>需求地段</td>
					<td>价格</td>
				</tr>
			<c:forEach var="client" items="${sellList}">
				<tr>
					<td><input type="radio" name="client1" value="${client.client_id}">${client.client_id}</td>
					<td>${client.client_name}</td>
					<td>${loginStaff.staff_name}</td>
					<td>${client.client_status}</td>
					<td>
						<c:forEach var="req" items="${client.clientReqList}">
							${req.client_type}
						</c:forEach>
					</td>
					<td>
						<c:forEach var="req" items="${client.clientReqList}">
							${req.siteRequirement}
						</c:forEach>
					</td>
					<td>
						<c:forEach var="req" items="${client.clientReqList}">
							${req.min_price}&nbsp;-
							${req.max_price}
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btn1 btn">确认</div>
	</div>
	<div class="showRentClientInfo showText">
		<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
				<tr>
					<td>客户编号</td>
					<td>客户姓名</td>
					<td>负责人</td>
					<td>状态</td>
					<td>客户类型</td>
					<td>需求地段</td>
					<td>价格</td>
				</tr>
			<c:forEach var="client" items="${rentList}">
				<tr>
					<td><input type="radio" name="client2" value="${client.client_id}">${client.client_id}</td>
					<td>${client.client_name}</td>
					<td>${loginStaff.staff_name}</td>
					<td>${client.client_status}</td>
					<td>
						<c:forEach var="req" items="${client.clientReqList}">
							${req.client_type}
						</c:forEach>
					</td>
					<td>
						<c:forEach var="req" items="${client.clientReqList}">
							${req.siteRequirement}
						</c:forEach>
					</td>
					<td>
						<c:forEach var="req" items="${client.clientReqList}">
							${req.min_price}&nbsp;-
							${req.max_price}
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btn3 btn">确认</div>
	</div>
	<!-- 出售 -->
	<div class="contain">
		<div class="title">出售合同<span class="pack2">收起</span></div>
		<div class="error"></div>	
		<div class="content2">
			<form action="contract1.do" method="post" onsubmit="return validate1()">
			<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
				<tr>
					<td class="td1">签约客源：</td>
					<td>
						<div class="click1">
							<input class="textStyle" id="client" type="text" name="Client_id" placeholder="请选择客源" readonly="readonly">
						</div>
					</td>
					<td class="td1">签约房源：</td>
					<td>
						<div class="click2">
							<input class="textStyle" id="house" type="text" name="house_id" placeholder="请选择房源" readonly="readonly">
						</div>
					</td>
				</tr>
				<tr>
					<td>成交价：</td>
					<td><input class="textStyle" id="transaction" type="text" name="Bid" placeholder="/万元" onblur="transaction1()"></td>
					<td>合同价：</td>				
					<td><input class="textStyle" id="contract" type="text" name="Contract_price" placeholder="/万元" readonly="readonly"></td>
				</tr>
				<tr>
					<td>签约时间：</td>
					<td><input class="textStyle" id="sign" type="text" name="Contract_Time"></td>
					<td>房源类型:</td>
					<td><div class="type" id="type1"></div></td>
				</tr>
				<tr>
					<td>买房备注:</td>
					<td colspan="3"><input class="textStyle" type="text" name="Contract_remark"></td>
				</tr>		
			</table>
			<input type="hidden" value="2" name="Contract_type">
			<input class="btn" type="submit" value="提交">
		</form>
		</div>
	</div>
	<!-- 出租 -->
	<div class="contain">
		<div class="title">出租合同 <span class="pack1">收起</span></div>   
		<div class="content1">
			<form action="contract2.do" method="post" onsubmit="return validate2()">
				<table class="tab" border="1" bordercolor="#DDDDDD"  cellpadding="0" cellspacing="0">
				<tr>
					<td class="td1">签约客源：</td>
					<td>
						<div class="click3"><input class="textStyle" id="client1" type="text" name="Client_id" placeholder="请选择客源" readonly="readonly"></div>
					</td>
					<td class="td1">签约房源：</td>
					<td>
						<div class="click4"><input class="textStyle" id="house1" type="text" name="house_id" placeholder="请选择房源" readonly="readonly"></div>
					</td>
				</tr>
				<tr>
					<td>签约时间：</td>
					<td><input class="textStyle" id="sign1" type="text" name="Contract_Time"></td>
					<td>租金:</td>
					<td><input class="textStyle" id="rent" type="text" name="Contract_price" placeholder="元/月" readonly="readonly"></td>
				</tr>
				<tr>
					<td>出租开始:</td>
					<td><input class="textStyle" id="start" type="text" name="Start_day"></td>
					<td>租期:</td>				
					<td><input class="textStyle" id="lease" type="text" name="lease" placeholder="月"></td>		
				</tr>
				<tr>
					<td>租房备注:</td>
					<td colspan="3"><input class="textStyle" type="text" name="Contract_remark"></td>
				</tr>
			</table>
				<input type="hidden" value="1" name="Contract_type"> 
				<input class="btn" type="submit" value="提交">
			</form>
		</div>
	</div>
</body>
<script>
	function client(){
		$(".error").html("");
		if($("#client").val() == ""){
			$(".error").html("请选择客源");
			return false;
		}else{
			return true;
		}
	}
	function house(){
		$(".error").html("");
		if($("#house").val() == ""){
			$(".error").html("请选择房源");
			return false;
		}else{
			return true;
		}
	}
	function transaction(){
		$(".error").html("");
		if($("#transaction").val() == ""){
			$(".error").html("成交价不可为空");
			return false;
		}else{
			return true;
		}
	}
	function contract(){
		$(".error").html("");
		if($("#contract").val() == ""){
			return false;
		}else{
			return true;
		}
	}

	function validate1(){
		if(!(client() && house() && transaction() && contract())){
			return false;
		}else{
			return true;
		}
	}
	
	function clients(){
		$(".error").html("");
		if($("#client1").val() == ""){
			$(".error").html("请选择客源");
			return false;
		}else{
			return true;
		}
	}
	function houses(){
		$(".error").html("");
		if($("#house1").val() == ""){
			$(".error").html("请选择房源");
			return false;
		}else{
			return true;
		}
	}
	function start(){
		$(".error").html("");
		if($("#start").val() == ""){
			$(".error").html("请输入开始时间");
			return false;
		}else{
			return true;
		}
	}
	function lease(){
		if($("#lease").val() == ""){
			$(".error").html("请输入租期");
			return false;
		}else{
			return true;
		}
	}
	function validate2(){
		if(clients() && houses() && start() && lease()){
			return true;
		}else{
			return false;
		}
	}
	
	var client1 = document.getElementsByName("client1");
	var client2 = document.getElementsByName("client2");
	var house1 = document.getElementsByName("house1");
	var house2 = document.getElementsByName("house2");
	var ind;
	var $c;
	var $h;
	$(".click1").click(function(){
		$(".showSellClientInfo").css("display","block");
		$c = $(".click1");
	})
	$(".click2").click(function(){
		$(".showSellHouseInfo").css("display","block");
		$h = $(".click2");
	})
	$(".click3").click(function(){
		$(".showRentClientInfo").css("display","block");
		$c = $(".click3");
	})
	$(".click4").click(function(){
		$(".showRentHouseInfo").css("display","block");
		$h = $(".click4");
	})

	$(".btn1").click(function(){
		for(var i=0;i<client1.length;i++){
			if(client1[i].checked){
				$c.children().val(client1[i].value);
			}
		}
		$(".showSellClientInfo").css("display","none");
	})
	$(".btn3").click(function(){
		for(var i=0;i<client2.length;i++){
			if(client2[i].checked){
				$c.children().val(client2[i].value);
			}
		}
		$(".showRentClientInfo").css("display","none");
	})
	
	$(".btn2").click(function(){
			for(var i=0;i<house1.length;i++){
				if(house1[i].checked){
					$h.children().val(house1[i].value);
					alert(house1[i].value)
					$.ajax({
						url:"searchSellHouse.do",
						type:"post",
						data:{"houseId":house1[i].value},
						dataType:"JSON",
						success:function(data){
							data = eval("("+data+")");
							$("#transaction").val(data[0].price);
							$("#contract").val(data[0].price);
							$("#sign").val(data[0].sign);
							$("#type1").html(data[0].application.application_type)
						}
					})
				}
			}
			$(".showSellHouseInfo").css("display","none");
		})
	
	$(".btn4").click(function(){
		for(var i=0;i<house2.length;i++){
			if(house2[i].checked){
				$h.children().val(house2[i].value);
				$.ajax({
					url:"searchRentHouse.do",
					type:"post",
					data:{"houseId":house2[i].value},
					dataType:"JSON",
					success:function(data){
						data = eval("("+data+")");
						$("#rent").val(data[0].price);
						$("#sign1").val(data[0].sign);
					}
				})
			}
		}
		$(".showRentHouseInfo").css("display","none");
	})
		
	$(".pack1").click(function(){
		if($(".content1").css("display")=="none"){
			$(".content1").css("display","block");
			$(this).html("收起");
		}else if($(".content1")){
			$(".content1").css("display","none");
			$(this).html("展开");
		}
	})
	$(".pack2").click(function(){
		if($(".content2").css("display")=="none"){
			$(".content2").css("display","block");
			$(this).html("收起");
		}else if($(".content2")){
			$(".content2").css("display","none");
			$(this).html("展开");
		}
	})
	
	
	
</script>
</html>