<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="css/animate.min.css">
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<body>
	
	
			<input type="text" name="neighborHood_Name" id="neighborHood_Name" class="form-control" style="width:100px;display:inline" type="text" placeholder="小区名称">
			<button class="btn btn-primary" id="search">搜索</button>
			<button class="btn btn-default" id="clear">重置</button>
	
	<hr>	
	<div id="show"></div>	
</body>
	<script type="text/javascript">
		//加载
		$(document).ready(function(){
			$.ajax({
				type:"post",
				url:"showAllNeighborList.do",
				success:function(data){
					$("#show").html(data);
				}
			});
		})
		//search
		$("#search").click(function(){
			var neighborHood_Name=$("#neighborHood_Name").val();
			$.ajax({
				type:"post",
				url:"showAllNeighborList.do",
				data:{"neighborHood_Name":neighborHood_Name},
				success:function(data){
					$("#show").html(data);
				}
			});
		})
		//clear
		$("#clear").click(function(){
			$.ajax({
				type:"post",
				url:"showAllNeighborList.do",
				success:function(data){
					$("#show").html(data);
				}
			});
		})
	</script>
</html>