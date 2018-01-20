<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加房源</title>
<link href="./css/houseResource.css" type="text/css" rel="stylesheet" />
</head>
<script type="text/javascript" src="./js/jquery-1.8.0.js"></script>
<body>

	<div class="main">
		<h2>录入出租信息</h2>
		
			<div class="nav">基本信息</div>
			<ul class="list">
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;小&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区&nbsp;&nbsp;</span>
					<input type="text" class="text" id="txt1">
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;具体地址&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" id="txt2">
					<span class="title">&nbsp;号楼&nbsp;</span>
					<input type="text" class="textLittle" id="txt3">
					<span class="title">&nbsp;单元&nbsp;</span>
					<input type="text" class="textLittle" id="txt4">
					<span class="title">&nbsp;门牌号&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;租&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金&nbsp;&nbsp;</span>
					<input type="text" class="text" id="txt5">元/月
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;房屋配置&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" id="txt7">
					<span class="title">&nbsp;室&nbsp;</span>
					<input type="text" class="textLittle" id="txt8">
					<span class="title">&nbsp;厅&nbsp;</span>
					<input type="text" class="textLittle" id="txt9">
					<span class="title">&nbsp;卫&nbsp;</span>
				</li>
				
				<li>
					
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;建筑面积&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" id="txt11">
					<span class="title">&nbsp;平&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;套内面积</span>
					<input type="text" class="textLittle" id="txt12">
					<span class="title">&nbsp;平&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;房屋情况&nbsp;&nbsp;</span>
					<select class="select" id="txt13">
						<option>自建房</option>
						<option>商铺</option>
						<option>车库</option>
						<option>写字楼</option>
						<option>厂房/仓库</option>
						<option>沿街店面</option>
						<option>别墅</option>
						<option>住宅楼</option>
					</select>
					&nbsp;
					<select class="select" id="txt14">
						<option>豪华装修</option>
						<option>精装修</option>
						<option>普通装修</option>
						<option>毛坯 </option>
					</select>
					&nbsp;
					<select class="select" id="txt15">
						<option>南北通透</option>
						<option>东西向</option>
						<option>北</option>
						<option>南</option>
						<option>西</option>
						<option>东</option>
					</select>
					&nbsp;
					<select class="select" id="txt16">
						<option>市政供暖</option>
						<option>无供暖</option>
					</select>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;层&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" id="txt17">
					<span class="title">&nbsp;层，共&nbsp;</span>
					<input type="text" class="textLittle" id="txt18">
					<span class="title">&nbsp;层&nbsp;</span>
				</li>
			</ul>
			
			
			<div class="nav">详细信息</div>
			<ul class="list">
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;房源标题&nbsp;&nbsp;</span>
					<input type="text" class="text" style="width:250px;" id="txt19">
				</li>
				<li>
					<span class="title" style="vertical-align: top;"><i style="color:red;vertical-align: top;">*&nbsp;</i>&nbsp;房源描述&nbsp;&nbsp;</span>
					<textarea rows="15" cols="100" id="txt20"></textarea>
				</li>
			</ul>
			
			
			
			
			<div class="nav">业主属性</div>
			<div class="nav2" style="display: black;">
				<ul class="list1">
					<li>
						<span class="title" style="vertical-align: top;">业主姓名&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
					</li>
					<li>
						<span class="title" style="vertical-align: top;">联系电话&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
					</li>
					<li>
						<span class="title" style="vertical-align: top;">备注信息&nbsp;&nbsp;</span>
						<textarea rows="10" cols="50"></textarea>
					</li>
				</ul>
			</div>
			
			<a href="javaScript:insertRentHouse()">保存</a>
		
	</div>

</body>
<script>
	function insertRentHouse(){
		$.ajax({
			url:"addRentHouse.do",
			type:"post",
			data:{"floor_":$("#txt2").val(),"ceil_":$("#txt3").val(),"doorplate":$("#txt4"),
				"rent":$("#txt5"),"room":$("#txt7"),"hall":$("#txt8"),"toilet":$("#txt9"),
				"build_areas":$("#txt11"),"inside_areas":$("#txt12"),"tier":$("#txt17"),
				"total_tiers":$("#txt18"),"houseResource_title":$("#txt19"),
				"houseResource_describe":$("#txt20")},
			success:function(data){
				
			}
		})
	}
</script>

</html>