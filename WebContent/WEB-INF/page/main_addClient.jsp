<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户界面</title>
<link href="./css/client.css" type="text/css" rel="stylesheet" />
<!-- 导入jquery文件 -->
<script src="./js/jquery-1.8.0.js"></script>
</head>
<body>
<div class="main">
	<h2>发布客源</h2>
	<div class="nav">基本信息<span style="color: red;font-size: 12px;">(打*号为必填项)</span>
							<span id="nameerror" style="color:red; font-size:10px; display: none; float: right;">姓名为必填项</span>
							<span id="telerror" style="color:red; font-size:10px; display: none; float: right; margin-right: 50px;">电话为必填项</span>
							<span id="telformaterror" style="color:red; font-size:10px; display: none; float: right; margin-right: 50px;">电话号码格式不正确</span>
	</div>
	<form action="addClientInfo.do" method="post" id="form">
		<ul class="list">
			<li>
				<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</span>
				<input type="text" class="intext" name="client_name" onblur="nameNotNull();" id="client_name">
			</li>			
			<li>
				<label>
					<i class="red">*</i>
					客户状态
				</label>
				<select class="select" name="client_status">
					<option value="2">未处理</option>
					<option value="3">求购中</option>
					<option value="5">求租中</option>
					<option value="1">已成交</option>
					<option value="4">已搁置</option>
				</select>
			</li>						
			<li>
				<label>
					<i class="red">*</i>
					客户类型
				</label>
				<select class="select" name="client_type">
					<option value="1">求购</option>
					<option value="2">求租</option>			
				</select>
			</li>	
			<li>
				<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;</span>
				<input type="radio" name="sex" value="男" checked="checked">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="sex" value="女">女
			</li>			
			<li>
				<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话&nbsp;&nbsp;</span>
				<input type="text" class="intext" name="telephone" onblur="telNotNull();" id="telephone">
			</li>
			
			<li>
				<span class="title">&nbsp;&nbsp;微&nbsp;&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;</span>
				<input type="text" class="intext" name="wechat">
			</li>				
						
			<li>
				<span class="title">&nbsp;&nbsp;QQ号码&nbsp;</span>
				<input type="text" class="intext" name="QQ">
			</li>
			
			<li>
				<span class="title">&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;箱&nbsp;&nbsp;&nbsp;</span>
				<input type="text" class="intext" name="email">
			</li>
			<li>
				<span class="title">&nbsp;&nbsp;联系地址</span>
				<input type="text" class="intext" name="address">
			</li>				
		</ul>
		
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
	 
	 
	 
	<div class="nav">房源需求<span style="color: red;font-size: 12px;">(打*号为必填项)</span>
							<span id="streeterror" style="color:red; font-size:10px; display: none; float: right;">城市要求为必填项</span>
	</div>
		<ul>
			<li style="width:680px;">
				<span class="title"><i style="color:red;">*&nbsp;</i>城市要求&nbsp;</span>
				<select class="select" id="areaSel"  onchange="getStreetByArea();">
					<option>不限区域</option>
				</select>
				&nbsp;&nbsp;
				<select class="select" name="siteRequirement" id="streetSel">
				<option value="0">地段要求</option>
				</select>
			</li>
			<br>
			<li>
				<label>
					<i class="red">*</i>
					房源类型
				</label>
				<!-- 动态加载 -->
				<select class="select" name="application_Id">
					<c:forEach items="${houseAppSelection }" var="application"> 
						<option value="${application.application_id }">${application.application_type }</option>
					</c:forEach>
				</select>
			</li>
			
			<li>
				<span class="title">&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;型&nbsp;&nbsp;</span>
				<input type="number" class="shorttext ii" name="room">&nbsp;&nbsp;室&nbsp;&nbsp;<input type="number" class="shorttext ii" name="hall">&nbsp;&nbsp;厅&nbsp;&nbsp;<input type="number" class="shorttext ii" name="toilet">&nbsp;&nbsp;卫
			</li>
			<br>
			<li>
				<span class="title">&nbsp;&nbsp;&nbsp;&nbsp;楼层区间&nbsp;</span>
				<input type="number" class="shorttext ii" name="min_Tier">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="number" class="shorttext ii" name="max_tier">楼
			</li>
			<li>
				<span class="title">&nbsp;&nbsp;&nbsp;&nbsp;价格区间&nbsp;</span>
				<input type="number" class="shorttext ii" name="min_price">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="number" class="shorttext ii" name="max_price">万
			</li>
			<li>
				<span class="title">&nbsp;&nbsp;&nbsp;&nbsp;面积区间&nbsp;</span>
				<input type="number" class="shorttext ii" name="min_area">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="number" class="shorttext ii" name="max_area">平
			</li>	
			<li>
				<label>
					&nbsp;&nbsp;&nbsp;&nbsp;装&nbsp;&nbsp;&nbsp;&nbsp;修&nbsp;&nbsp;
				</label>
				<!-- 动态加载 -->
				<select class="select ii" name="adornment_Id">
					<c:forEach items="${houseAdorSelection }" var="adornment"> 
						<option value="${adornment.adornment_Id }">${adornment.adornment_type }</option>
					</c:forEach>
				</select>
			</li>
			<li>
				<label>
					&nbsp;&nbsp;&nbsp;&nbsp;朝&nbsp;&nbsp;&nbsp;&nbsp;向&nbsp;&nbsp;
				</label>
				<!-- 动态加载 -->
				<select class="select ii" name="direction_Id">
					<c:forEach items="${houseDireSelection }" var="direction"> 
						<option value="${direction.direction_Id }">${direction.direction_type }</option>
					</c:forEach>
				</select>
			</li>
			<li>
				<label>
					付款方式
				</label>
				<select class="select ii" name="clientPay_Type">
					<option value="1">商贷</option>
					<option value="2">补按揭</option>
					<option value="3">抵押贷</option>
					<option value="4">公积金</option>
					<option value="5">其他</option>
				</select>
			</li>
			<li>
				<span class="title" style="vertical-align: top">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;</span>
				<textarea rows="10" cols="30" name="remark" style="outline: none;"></textarea>
			</li>					
		</ul>
		<ul>
				<div class="saveBtn">
				保存
				</div>
		</ul>
		<input type="hidden" name="staff_id" value="${sessionScope.loginStaff.staff_id }">
	</form>
</div>	
</body>
<script type="text/javascript">
	//给div提交按钮绑定事件
	$(".saveBtn").click(function(){
		//获取表单对象
		var form = $("#form");
		//如果表单对象的值为空 则移除name 即不上传表单
		$("#form .ii").each(function(){
			if(this.value == ""){
				$(this).removeAttr("name");
			}
		})
		if(!validate()){
			return false;
		}
		$("#form").submit();	
	})
	
	//姓名不可为空
	function nameNotNull(){
		var clientName =$("#client_name").val();
		if(clientName == ""){
			$("#nameerror").show();
			return false;
		}else{
			$("#nameerror").hide();
		}
		return true;
	} 
	//电话不可为空 
	function telNotNull(){
		var telephone = $("#telephone").val();
		if(telephone == ""){
			$("#telerror").show();
			return false;
		}else{
			$("#telerror").hide();
		}
		//电话号码正则表达式 
		var rule =/^1[34578]\d{9}$/;
		if(!rule.test(telephone)){
			$("#telformaterror").show();
			return false;
		}else{
			$("#telformaterror").hide();
		}
		return true;
	}
	 
	//街道要求不可为空
	function streetNotNull(){
		var street = $("#streetSel").val();
		if(street == 0){
			$("#streeterror").show();
			return false;
		}else{
			$("#streeterror").hide();
		}	
		return true;
	}
	
	
	
	function validate(){
		if(!nameNotNull()||!telNotNull()||!streetNotNull()){
			return false;
		}
			return true;
			
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