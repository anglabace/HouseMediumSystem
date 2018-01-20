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
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
	#work1{
		height: 500px;
		width: 100%;
	}
	#work2{
		height: 500px;
		width: 1000px;
		display: none;
	}
	input{  
	width:150px;
	height:40px; 
	line-height:30px; 
	border: 1px solid #cdcdcd; 
	background:#e6e6e6; 
	font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; 
	color:#000000; 
	float:left; 
	margin:0 10px 0 0; 
	display:inline; 
	cursor:pointer; 
	font-size:14px; 
	font-weight:bold;
	}
	#btn{
	height:40px; 
	}
</style>
</head>
<body>
<div><h2>公司近半年业务报表</h2></div>
<div id="work1"></div>

<div id="btn"><input type="button" onclick="LoadAttendance()" value="查看员工当月打卡情况"></div>
<div id="work2"></div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var myChart1 = echarts.init(document.getElementById('work1'));
	$.ajax({
		url:"loadStatement.do",
		type:"post",
		dataType:"json",
		success:function(data){
			data = eval("("+data+")");
		var option = {
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            crossStyle: {
	                color: '#999'
	            }
	        }
	    },
	    toolbox: {
	        feature: {
	            dataView: {show: true, readOnly: false},
	            magicType: {show: true, type: ['line', 'bar']},
	            restore: {show: true},
	            saveAsImage: {show: true}
	        }
	    },
	    legend: {
	        data:['新增房源数','新增客源数','订单交易额']
	    },
	    grid: {  
            y2: 140  
        }, 
	    xAxis: [
	        {
	            type: 'category',
	            data: data.name,
	            axisPointer: {
	                type: 'shadow'
	            },
	            axisLabel:{  
                    interval:0,//横轴信息全部显示  
                    rotate:-30,//-30度角倾斜显示  
               }  
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '业绩数',
	            min: 0,
	            max: 250,
	            interval: 50,
	            axisLabel: {
	                formatter: '{value}'	
	            }
	        }
	    ],
	    series: [
	        {
	            name:'新增房源数',
	            type:'bar',
	            data:data.house,
	            	//[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
	        },
	        {
	            name:'新增客源数',
	            type:'bar',
	            data:data.clien,
	            	//[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
	        },
	        {
	            name:'订单交易额',
	            type:'line',
	            yAxisIndex: 0,
	            data:data.order,
	            	//[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
	        }
	    ]
	};
	myChart1.setOption(option);
		}
	})	
})

	function LoadAttendance(){
	    var my1= document.getElementById('work2')
		var myChart2 = echarts.init(my1);
	    my1.style.display="block";
	    $.ajax({
			url:"loadAttendance.do",
			type:"post",
			dataType:"json",
			success:function(data){
				data = eval("("+data+")");
		    var option = {
		    	    tooltip: {
		    	        trigger: 'axis',
		    	        axisPointer: {
		    	            type: 'cross',
		    	            crossStyle: {
		    	                color: '#999'
		    	            }
		    	        }
		    	    },
		    	    toolbox: {
		    	        feature: {
		    	            dataView: {show: true, readOnly: false},
		    	            magicType: {show: true, type: ['line', 'bar']},
		    	            restore: {show: true},
		    	            saveAsImage: {show: true}
		    	        }
		    	    },
		    	    legend: {
		    	        data:['签到数']
		    	    },
		    	    grid: {  
		                y2: 140  
		            }, 
		    	    xAxis: [
		    	        {
		    	            type: 'category',
		    	            data: data.name,
		    	            axisPointer: {
		    	                type: 'shadow'
		    	            },
		    	            axisLabel:{  
		                        interval:0,//横轴信息全部显示  
		                        rotate:-30,//-30度角倾斜显示  
		                   }  
		    	        }
		    	    ],
		    	    yAxis: [
		    	        {
		    	            type: 'value',
		    	            name: '签到数',
		    	            min: 0,
		    	            max: 31,
		    	            interval: 5,
		    	            axisLabel: {
		    	                formatter: '{value}'	
		    	            }
		    	        }
		    	    ],
		    	    series: [
		    	        {
		    	            name:'签到数',
		    	            type:'bar',
		    	            data:data.check
		    	            	//[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
		    	        }
		    	    ]
		    	};
		    	myChart2.setOption(option);
		   }
		})
}
</script>
</html>