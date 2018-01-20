<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./css/css.css" type="text/css" rel="stylesheet" />
<link href="./css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="./images/main/favicon.ico" />
<script type="text/javascript" src="./js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="./js/echarts.min.js"></script>
<style>
	body{overflow-x:hidden; background:#EEF1F5; padding:15px 0px 10px 5px;}
	.clear:after{
		clear:both;
		content: "";
		display: block;
	}
	.top1{
		width: 1140px;
		height: 130px
	}
	.top1>div{
		float: left;
		background-color: white;
		width: 260px;
		height: 110px;
		margin: 11px;
	}
	.top1>div>div{
		float: left;
	}
	.top1>div>.pic{
		width: 70px;
		height: 70px;
		margin: 20px 0px 20px 20px;
		color: white;
		font-size: 20px;
		line-height: 70px;
		text-align: center;	
	}
	.info{
		width: 70px;
		height: 70px;
		color: #808080;
		margin: 20px 0px;
		text-align: center;	
	}
	.num{
		font-size: 20px;
		margin-top:20px;
	}
	.top2{
		margin-top: 15px;
		width: 1140px;
		height: 325px;
		float: left;
	}
	.top2>div{
		height: 325px;
		background-color: white;
		float: left;
		margin: 0px 10px;
	}
	.staff{
		font-size: 15px;
		color: black;
	}
	.staff>div{
		margin: 25px 0px;
	}
	.staff>div>span{
		color: #A8B0BD	
	}
	.work{
		width: 600px;
	}
	.notice{
		width: 250px;
		background-image: url("./img/100123698_wx.jpg");
		background-size: cover
	}
	.notice>div{	
		text-align: center;
	}
	.notice1{
		color:white;
		height: 40px;
		font-weight:bolder;
		font-size: 20px;
		line-height: 40px;
	}
	.notice2{
		color:black;
		height: 30px;
		font-weight:bolder;
		font-size: 14px;
		line-height: 30px;
	}
	.work>div{
		float: right;
		height: 300px;
		width: 300px;
	}
</style>
</head>
<body>
<!--main_top-->
	<div class="top1 clear">
		<div class="clear">
			<div class="pic" style="background-color: #F66E6D">售</div>
			<div class="info">
				<div>出售总数</div>
				<div class="num" id="num1" style="color: #F66E6D"></div>
			</div>
		</div>
		<div>
			<div class="pic" style="background-color: #64CBFE">租</div>
			<div class="info">
				<div>出租总数</div>
				<div class="num" id="num2" style="color: #64CBFE"></div>
			</div>
		</div>
		<div>
			<div class="pic" style="background-color: #F9CD3C">客</div>
			<div class="info">
				<div>客户总数</div>
				<div class="num" id="num3" style="color: #F9CD3C"></div>
			</div>
		</div>
		<div>
			<div class="pic" style="background-color: #26BF8C">额</div>
			<div class="info">
				<div>业绩总数</div>
				<div class="num" id="num4" style="color: #26BF8C"></div>
			</div>
		</div>
	</div>
	<div class="top2 clear">
		<div class="staff" style="background-color:#2A566F;">
			<div>个人详情：</div>
			<div>入职时间：<span><fmt:formatDate value="${loginStaff.hireDate }" pattern="yyyy-MM-dd"/></span></div>
			<div>看房电话：<span>${loginStaff.telephone}</span></div>
			<div>联系 QQ：<span>${loginStaff.QQ}</span></div>
			<div>联系微信：<span>${loginStaff.wechat}</span></div>
			<div>负责区域：<span class="areaName"></span></div>
		</div>
		<div class="work">
		<!--本月新增出售房出租房比-->
			<div id="work1"></div>
		<!--个人为处理出售房出租房比-->
			<div id="work2"></div>
		</div>
		<div class="notice">
			<div class="notice1">公司公告栏</div>
			<hr>
			<div class="notice2">公告标题</div>
			<hr>
			<div class="notice3" style="color: black;">公告内容</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		var myChart1 = echarts.init(document.getElementById('work1'));
		var myChart2 = echarts.init(document.getElementById('work2'));
		var data1='';
		var data2='';
		var data3='';
		var data4='';
		$.ajax({
			url:"loadMain.do",
			type:"post",
			dataType:"json",
			success:function(data){
				data = eval("("+data+")");
				
				$(".areaName").html(data[0].areaName);
				$(".notice2").html(data[1].notic.notice_title);
				$(".notice3").html(data[1].notic.notice_content);
				$("#num1").html(data[3].buyOrder);
				$("#num2").html(data[4].lease);
				$("#num3").html(data[5].countClient);
				$("#num4").html(data[2].allOrder);
				data1=data[9].newHouse2;
				data2=data[8].newHouse1;
				data3=data[6].houseNumber;
				data4=data[7].clienNumber;
				var option1 = {
						color: ['#ff7d27', '#47b73d', '#fcc36e', '#57a2fd', "#228b22"],
						title: {
				            text: '新增房源类型比',
				            x:'center'
				        },
				        tooltip: {
				            trigger: 'item',
				            formatter: "{a} <br/>{b} : {c} ({d}%)"
				        },    
				        legend: {
				            orient: 'vertical',
				            x: 'left'
				        },   
				        toolbox: {
				            show: true,
				            feature: {
				                mark: { show: true },
				                dataView: { show: true, readOnly: false },
				                magicType: {
				                    show: true,
				                    type: ['pie', 'funnel'],
				                    option: {
				                        funnel: {
				                            x: '25%',
				                            width: '50%',
				                            funnelAlign: 'left',
				                            max: 1548
				                        }
				                    }
				                },
				                restore: { show: true },
				                saveAsImage: { show: true }
				            }
				        },         
				        series: [{
				            name: '发布排行',
				            type: 'pie',
				            radius: '55%',
				            center: ['50%', '60%'],            
				            data: [{name:'出租房',value:data1},{name:'出售房',value:data2}]
				        }]  
       			 };
				var option2 = {
						color: ['#57a2fd', '#fcc36e'],
						title: {
				            text: '当月跟进类型',
				            x:'center'
				        },
				        tooltip: {
				            trigger: 'item',
				            formatter: "{a} <br/>{b} : {c} ({d}%)"
				        },    
				        legend: {
				            orient: 'vertical',
				            x: 'left'
				        },   
				        toolbox: {
				            show: true,
				            feature: {
				                mark: { show: true },
				                dataView: { show: true, readOnly: false },
				                magicType: {
				                    show: true,
				                    type: ['pie', 'funnel'],
				                    option: {
				                        funnel: {
				                            x: '25%',
				                            width: '50%',
				                            funnelAlign: 'left',
				                            max: 1548
				                        }
				                    }
				                },
				                restore: { show: true },
				                saveAsImage: { show: true }
				            }
				        },         
				        series: [{
				            name: '发布排行',
				            type: 'pie',
				            radius: '55%',
				            center: ['50%', '60%'],            
				            data: [{name:'房源跟进数',value:data3},{name:'客源跟进数',value:data4}]
				        }]  
       			 };
				myChart1.setOption(option1);
				myChart2.setOption(option2);
				
			}
		})
	})
	
</script>
</html>