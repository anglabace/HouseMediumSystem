<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 自己写的外联样式 -->
<link rel="Stylesheet" type="text/css" href="css/updateMyInfo.css" />
<!-- jquery脚本 -->
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<body>
	<div class="vcon">
			<div>
				<h1>基本信息</h1>
			</div>
			<div class="manageBox">
				<div class="manage">
					<form action="updateStaffPwd.do" method="post" onsubmit="return checkPwd()">
						<ul>
							<li>
								<label>
									<i>*</i> 
									<span id="staffrealName">旧的密码&nbsp;&nbsp;&nbsp;</span>
									<input id="name"  class="inputname" type="password"  placeholder="请输入原密码">
									<i id="staffNameWarm"></i>

								</label>
							</li>
							<li>
								<label>
									<i>*</i>
									<span id="staffrealName">新的密码&nbsp;&nbsp;&nbsp;</span>
									<input id="newPwd1" class="inputname" type="password" name="staff_pwd"  placeholder="建议英文字母加数字">
									<i id="staffphoneWarm"></i>
								</label>
							</li>
							<li>
								<label>
									<i>*</i>
									<span id="staffrealName">密码确认&nbsp;&nbsp;&nbsp;</span>
									<input id="newPwd2" class="inputname" type="password"  placeholder="请再次输入新密码">
									<i id="staffareaWarm"></i>
								</label>
							</li>
							<li>	
							</li>
							<li>
								<input type="submit" class="savebtn" value="确认修改">
							</li>
						</ul>
					</form>
				</div>
			</div>	
		</div>	
</body>
<script type="text/javascript">
	function checkPwd(){
		//确认密码不一致,在右边提示确认密码不一致
			if($("#newPwd1").val()!=$("#newPwd2").val()){
				$("#staffareaWarm").html("两次密码不一致");
				return false;
			}
		//密码不正确
		var myPwd="${loginStaff.staff_pwd}";
		alert(myPwd);
			if($("#name").val()!=myPwd){
				$("#staffNameWarm").html("密码有误,请重新输入");
				return false;
			}
			alert("修改成功");
			return true;
	}
</script>
</html>