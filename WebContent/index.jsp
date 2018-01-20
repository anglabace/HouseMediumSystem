<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/animate.min.css">
 <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!--可选的 Bootstrap 主题文件（一般不用引入）-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!--最新的 Bootstrap 核心 JavaScript 文件-->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>login</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>

<script type="text/javascript" src="js/jquery-3.0.0.js"></script>

<style>
	*{
padding:0;
margin:0;
}
.lbOverlay{
    display: none;
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    zoom: 1;
    background: rgba(0,0,0,0.75);
    z-index: 999;
    width:100%;
    height:100%;
}
.hidden_pro_au {
    display:none;
    background: #fff;
    padding: 6px;
    text-align: left;
    width: 400px;
    height: 500px;
    background: #ccc;
    overflow: auto;
    position: absolute;
    top: 0;
    left: 0;
  
    background-color:rgba(255,255,255,0.9);
    z-index: 9999999;
}
.flash{
	height:30px;
	line-height: 30px;
	font-size: 18px;
	color:red;
}	 
</style>

<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />

<title>Insert title here</title>

</head>
<body>
		<div class="container demo-1" style="width:100%" >
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>天玄房产中介管理系统</h3>	
						<form action="staff_login.do"  method="post" onsubmit="return login()">
							<div class="input_outer">
								<span id="u_user1" class="u_user" ></span>
								<input id="stafftelephone" name="telephone" class="text" style="color: #ffffff !important" type="text" placeholder="请输入手机号·">
							</div>
							<div class="input_outer">
								<span id="u_user2" class="us_uer"></span>
								<input id="staffpwd" name="pwd" class="text" style="color: #ffffff !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码 ">
							</div>
							<div >
								<input type="checkbox" name="radio" checked>记住密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:show()" style="color:rgba(255,255,255,1);">找回密码?</a>
							</div>
							<div style="width:330px;"><input type="submit" class="act-but submit "   style="color: #FFFFFF;width:330px;background-color: rgba(0,0,0,0.5);border: 0px;" value="登陆"></div>
							<div class="animated flash">${error }</div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<div style="text-align:center">
	</div>
<div class="lbOverlay"  onclick="closeDiv()"></div>
<div class="hidden_pro_au" style="display:none;">	
	<div class="logo_box">
		<h4 style="color:black;text-align:center;;font-size:15;font-weight:bold;">密码找回</h4>
			<div class="input_outer">
				<span class="u_user"></span>
				<input id="telephone" name="telephone" class="text" style="color: black !important" type="text" placeholder="请输入手机号·" disabled >
				<button id="sendCodeBtn"  class="btn btn-primary btn-xs" onclick="javascript:sendCode()">免费获取手机验证码</button>
			</div>
			<div class="input_outer">
				<span class="us_uer"></span>
				<input id="code" name="logpass" class="text" style="color: black !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入验证码 "  >
			</div>
			
			<button type="button" class="btn btn-primary btn btn-primary btn-xs" style="width:330px;" onclick="checkCode()">验证</button>	
			<div id="showMessage" style="padding:20px;display:block;color:red;"></div>	
	</div>	
</div>
	</body>
	<script>
	function login(){
		var staff=$("#stafftelephone").val();
		var pwd=$("#staffpwd").val();
		if(staff==""){
			alert("请填写手机号码!");
			return false;
		}
		if(pwd==""){
			alert("请填写密码!");
			return false;
		}
		return true;	
	}
		function show(){
		    $(".lbOverlay").css({"height":window.screen.availHeight});
		    $(".lbOverlay").show();
		    var st=$(document).scrollTop(); //页面滑动高度
		    var objH=$(".hidden_pro_au").height();//浮动对象的高度
		    var ch=$(window).height();//屏幕的高度  
		    var objT=Number(st)+(Number(ch)-Number(objH))/2;   //思路  浮动高度+（（屏幕高度-对象高度））/2
		    $(".hidden_pro_au").css("top",objT);    
		    var sl=$(document).scrollLeft(); //页面滑动左移宽度
		    var objW=$(".hidden_pro_au").width();//浮动对象的宽度
		    var cw=$(window).width();//屏幕的宽度  
		    var objL=Number(sl)+(Number(cw)-Number(objW))/2; //思路  左移浮动宽度+（（屏幕宽度-对象宽度））/2
		    $(".hidden_pro_au").css("left",objL);
		    $(".hidden_pro_au").slideDown("20000");//这里显示方式多种效果
		    $("#telephone").val($("#stafftelephone").val());
		}
		function closeDiv(){
		    $(".lbOverlay").hide();
		    $(".hidden_pro_au").hide();
		}
		var checkcode="";
		//倒计时开始
		var countdown=30; 
		//发送验证码
		function sendCode(){
			//当发送验证码的时候,进行倒计时,设置时间为60s失效[有一个倒计时的显示],并且按钮在60s内不可点击
			var staff=$("#stafftelephone").val();
				$.ajax({
					 type:"post",   //请求方式
					 url:"sendCode.do",
					 data:{"telephone":staff},
					 dataType:"json",
					 success:function(data){
						 alert("1");
						 alert(data);
					     //请求成功时处理
					    var data = eval('('+data+')');
					     alert(data.code); 
						 checkcode=data.code;
						// alert(eval(data));
						 //console.log(eval(data));
					    }
				});
			var telephone=$("#telephone").val(); 
			 var obj = $("#sendCodeBtn");
		   	 settime(obj);
			//$("#button_id").attr('disabled',true);  
		}
		//对输入的验证码进行验证,然后根据输入的结果,显示对应的结果
		function checkCode(){
			alert(checkcode);
			//如果输入的验证码和服务器产生的验证码一致的话	
			if($("#code").val()==checkcode&&checkcode!=""+countdown){
				alert("sdsad");
				var staff=$("#stafftelephone").val();
				$.ajax({
					 type:"post",   //请求方式
					 url:"getPwd.do",
					 data:{"telephone":staff},
					 dataType:"json",
					 success:function(data){
					        //请求成功时处理
					        var data = eval('('+data+')');
					        $("#showMessage").html("您的密码:"+data.pwd); 
					    }
				});		
			}else{
				alert("验证失败");
				$("#showMessage").html("验证码无效!");
			}
			
		}
		function settime(obj) { //发送验证码倒计时
		    if (countdown == 0) { 
		        obj.attr('disabled',false); 
		        //obj.removeattr("disabled"); 
		        obj.html("免费获取验证码");
		        countdown = 30; 
		        return;
		    } else { 
		        obj.attr('disabled',true);
		        obj.html("重新发送(" + countdown + ")");
		        countdown--; 
		    } 
		setTimeout(function() { 
		    settime(obj) }
		    ,1000) 
		}
		////倒计时结束
	</script>	

</body>

</html>