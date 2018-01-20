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
		<h2>录入出售信息</h2>
		
		<form action="addHouse.do" method="post">
			<div class="nav">基本信息</div>
			<ul class="list">
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;小&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区&nbsp;&nbsp;</span>
					<input type="text" class="text" >
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;具体地址&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;号楼&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;单元&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;门牌号&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;室&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;厅&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;卫&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;阳&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;厨&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;层&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;层，共&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;层&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" style="width:80px;">
					<span class="title" >&nbsp;万元&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;建筑面积&nbsp;&nbsp;</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;平&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;套内面积</span>
					<input type="text" class="textLittle" >
					<span class="title">&nbsp;平&nbsp;</span>
				</li>
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;房屋情况&nbsp;&nbsp;</span>
					<select class="select">
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
					<select class="select">
						<option>豪华装修</option>
						<option>精装修</option>
						<option>普通装修</option>
						<option>毛坯 </option>
					</select>
					&nbsp;
					<select class="select">
						<option>南北通透</option>
						<option>东西向</option>
						<option>北</option>
						<option>南</option>
						<option>西</option>
						<option>东</option>
					</select>
					&nbsp;
					<select class="select">
						<option>市政供暖</option>
						<option>无供暖</option>
					</select>
				</li>
			</ul>
			
			
			<div class="nav">详细信息</div>
			<ul class="list">
				<li>
					<span class="title"><i style="color:red;">*&nbsp;</i>&nbsp;房源标题&nbsp;&nbsp;</span>
					<input type="text" class="text" style="width:250px;">
				</li>
				<li>
					<span class="title" style="vertical-align: top;"><i style="color:red;vertical-align: top;">*&nbsp;</i>&nbsp;房源描述&nbsp;&nbsp;</span>
					<textarea rows="15" cols="100"></textarea>
				</li>
			</ul>
			
			<div class="nav">房源属性<a href="javascript:show1()" class="show1" style="text-decoration: none;font-size: 12px;margin-right: 0px;">&nbsp;&nbsp;&nbsp;隐藏房源属性</a></div>
			<div class="nav1" style="display: black;">
				<ul class="list1">
					<li>
						<span class="title" style="vertical-align: top;">建筑类型&nbsp;&nbsp;</span>
						<select class="select1">
							<option>板楼</option>
							<option>塔楼</option>
							<option>板塔结合</option>
							<option>独栋</option>
							<option>联排</option>
							<option>叠拼</option>
							<option>平板</option>
						</select>
					</li>
					<li>
						<span class="title" style="vertical-align: top;">建筑结构&nbsp;&nbsp;</span>
						<select class="select1">
							<option>钢混结构</option>
							<option>砖混结构</option>
							<option>砖木结构</option>
							<option>钢结构</option>
						</select>
					</li>
					<li>
						<span class="title" style="vertical-align: top;">梯户比例&nbsp;&nbsp;</span>
						<input type="text" class="textLittle" style="weight:30px;border-left:1px solid #F2F2F2;">
						<span class="title">&nbsp;梯&nbsp;</span>
						<input type="text" class="textLittle" style="weight:30px;border-left:1px solid #F2F2F2;">
						<span class="title">&nbsp;户&nbsp;</span>
						<select class="select1">
							<option>无电梯</option>
							<option>有电梯</option>
						</select>
					</li>
					<li>
						<span class="title" style="vertical-align: top;">产权性质&nbsp;&nbsp;</span>
						<select class="select1">
							<option>房改房</option>
							<option>使用权房</option>
							<option>经济适用房</option>
							<option>期房</option>
							<option>商品房</option>
							<option>公产</option>
							<option>私产</option>
						</select>
					</li>
					<li>
						<span class="title" style="vertical-align: top;">产权年限&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
						<span class="title">&nbsp;年&nbsp;</span>
					</li>
					<li>
						<span class="title" style="vertical-align: top;">交易权属&nbsp;&nbsp;</span>
						<select class="select1">
							<option>商品房</option>
							<option>房改房</option>
							<option>存量房</option>
							<option>经济适用住房</option>
						</select>
					</li>
					<li>
						<span class="title" style="vertical-align: top;">建造年份&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
						
					</li>
					<li>
						<span class="title" style="vertical-align: top;">房本年限&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">		
					</li>
					<li>
						<span class="title" style="vertical-align: top;">抵押信息&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">		
					</li>
					
				</ul>
			</div>
			
			<div class="nav">业主属性<a href="javascript:show2()" class="show2" style="text-decoration: none;font-size: 12px;">&nbsp;&nbsp;&nbsp;隐藏房源属性</a></div>
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
						<span class="title" style="vertical-align: top;">接受价格&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
					</li>
					<li>
						<span class="title" style="vertical-align: top;">业主微信&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
					</li>
					<li>
						<span class="title" style="vertical-align: top;">身份证号&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
						
					</li>
					<li></li>
					<li>
						<span class="title" style="vertical-align: top;">备注信息&nbsp;&nbsp;</span>
						<textarea rows="10" cols="50"></textarea>
					</li>
					
					
				</ul>
			</div>
			
			
			<div class="nav">房源图片<a href="javascript:show3()" class="show3" style="text-decoration: none;font-size: 12px;">&nbsp;&nbsp;&nbsp;   隐藏房源属性</a></div>
			<div class="nav3" style="display: black;">
				<ul class="list1">
					<li>
						<span class="title" style="vertical-align: top;">业主姓名&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
					</li>
					<li>
						<span class="title" style="vertical-align: top;">联系电话&nbsp;&nbsp;</span>
						<input type="text" class="text" style="weight:60px;border-left:1px solid #F2F2F2;">
					</li>
				</ul>
			</div>
			
			<input type="submit" value="保存">
		
		
		</form>
	</div>

</body>

<script>
	function show1(){
		var asd = $(".nav1").css("display");
		if(asd=="block"){
			$(".nav1").css({"display":"none"});
			$(".show1").text("显示房源信息");
		}
		else{
			$(".nav1").css({"display":"block"});
			$(".show1").text("隐藏房源信息");
		}
	}
	function show2(){
		var asd = $(".nav2").css("display");
		if(asd=="block"){
			$(".nav2").css({"display":"none"});
			$(".show2").text("显示业主信息");
		}
		else{
			$(".nav2").css({"display":"block"});
			$(".show2").text("隐藏业主信息");
		}
	}
	function show3(){
		var asd = $(".nav3").css("display");
		if(asd=="block"){
			$(".nav3").css({"display":"none"});
			$(".show3").text("显示房源图片");
		}
		else{
			$(".nav3").css({"display":"block"});
			$(".show3").text("隐藏房源图片");
		}
	}
</script>

</html>