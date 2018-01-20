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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<body>
	<div id="staffoneorallc">
			<table class="table table-hover">
				<tr>
					<th class="col-md-1">楼盘编号</th>
					<th class="col-md-1">楼盘名称</th>
					<th class="col-md-1">城市</th>
					<th class="col-md-1">街道</th>
					<th class="col-md-1">区域</th>
					<th class="col-md-1">操作</th>
				</tr>
			<c:forEach items="${villegeList }" var="t">
				<tr>
					<td class="col-md-1"><div class="animated bounce">${t.neighborHood.neighborHood_Id }</div></td>
					<td class="col-md-1"><div class="animated bounce">${t.neighborHood.neighborHood_Name }</div></td>	
					<td class="col-md-1"><div class="animated bounce">${t.city.city_Name }</div></td>
					<td class="col-md-1"><div class="animated bounce">${t.street.street_Name }</div></td>	
					<td class="col-md-1"><div class="animated bounce">${t.area.area_Name }</div></td>	
				</tr>
			</c:forEach>
			</table>
			<ul class="pager">
   			 <li><a href="javascript:pagingUp()">上一页</a></li>
    		 <li><a href="javascript:pagingNe()">下一页</a></li>
  		</ul>
	</div>
</body>
<script type="text/javascript">
//分页ajax
//上一页
	//当前页
	var pageNo="${pageNo}"
	var pageNum="${pageNum}"
	var neighborHood_Name="${neighborHood_Name}"
function pagingUp(){
	pageNo--;
	//alert(pageNum);
	if(pageNo<1){
		pageNo=1;
		alert("已经是第一页了");
	}else{
		$.ajax({
			type:"post",
			url:"showAllNeighborList.do",
			data:{"pageNo":pageNo,"neighborHood_Name":neighborHood_Name},
			success :function(data){
				$("#staffoneorallc").html(data);
			}	
		})
	}	
}
//下一页
function pagingNe(){
	pageNo++;
	if(pageNo>pageNum){
		pageNo=pageNum;
		alert("已经最后一页了");
	}else{
		$.ajax({
			type:"post",
			url:"showAllNeighborList.do",
			data:{"pageNo":pageNo,"neighborHood_Name":neighborHood_Name},
			success :function(data){
				$("#staffoneorallc").html(data);
			}	
		})
	}
}
</script>
</html>