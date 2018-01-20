<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<html>
<head>
<link rel="stylesheet" href="css/animate.min.css">
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
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
				<th class="col-md-1"><div class="animated bounce">单号</div></th>
				<th class="col-md-2"><div class="animated bounce">模块</div></th>
				<th class="col-md-1"><div class="animated bounce">申请人</div></th>
				<th class="col-md-2"><div class="animated bounce">申请日期</div></th>
				<th class="col-md-2"><div class="animated bounce">审核</div></th>
			</tr>
			<c:forEach items="${contractList }" var="contract">
					<tr>
					<td class="col-md-1">${contract.getContract_id() }</td> 
						
						<c:if test="${contract.getContract_type() == 1 }">
							<td class="col-md-1"><div class="animated bounce">出租合同</div></td>
						</c:if>
						<c:if test="${contract.getContract_type() == 2 }">
							<td class="col-md-1"><div class="animated bounce">出售合同</div></td>
						</c:if>
						<c:if test="${contract.getContract_type() == 0 }">
							<td class="col-md-1"><div class="animated bounce"></div></td>
						</c:if>		
						<td class="col-md-1"><div class="animated bounce">${contract.staff.staff_name }</div></td>			
						<td class="col-md-2"><div class="animated bounce"><fmt:formatDate value="${contract.getContract_Time() }" pattern="yyyy-MM-dd"/></div></td>	
						<c:if test="${contract.contract_status==1}">
							<td class="col-md-2" class="check">
								<button class="btn btn-success"  onclick="agree(this)">同意</button>
								<button class="btn btn-danger"  onclick="refuse(this)">拒绝</button>
							</td>	
						</c:if>
						<c:if test="${contract.contract_status==2}">
							<td class="col-md-2" class="check">
								已审核
							</td>	
						</c:if>	
						<c:if test="${contract.contract_status==3}">
							<td class="col-md-2" class="check">
								未通过
							</td>	
						</c:if>	
						
					</tr>
			</c:forEach>
		</table>
		<ul class="pager">
   			 <li><a href="javascript:pagingUp()">上一页</a></li>
    		 <li><a href="javascript:pagingNe()">下一页</a></li>
  		</ul>	
	</div>
	<div style=""></div>
</body>
<script type="text/javascript">

//分页ajax
//上一页
	//当前页
	var pageNo="${pageNo}";
	var pageNum="${pageNum}";
	var select="${Contract_type}";
	var Contract_Time="${Contract_Time}";
	var Contract_id="${Contract_id}";
	//alert(pageNo);
	//alert(pageNum);
function pagingUp(){
	pageNo--;
	//alert(pageNum);
	if(pageNo<1){
		pageNo=1;
		alert("已经是第一页了");
	}else{
		$.ajax({
			type:"post",
			url:"findAllContract.do",
			data:{"select":select,"Contract_id":Contract_id,"Contract_Time":Contract_Time,"pageNo":pageNo},
			success:function(data){
				$("#staffoneorallc").html(data);
			}
		});
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
			url:"findAllContract.do",
			data:{"select":select,"Contract_id":Contract_id,"Contract_Time":Contract_Time,"pageNo":pageNo},
			success:function(data){
				$("#staffoneorallc").html(data);
			}
		});
	}
}
	//同意
	function agree(title){
		var select="${Contract_type}";
		var Contract_Time="${Contract_Time}";
		var Contract_id="${Contract_id}";
		//获取合同Id
		var Contract_id=parseInt($(title).parent("td").parent("tr").find("td:first").text());
		alert(typeof(Contract_id));
		var confirms=confirm("同意审核？");
		if(confirms){
			//改变合同表的状态【2：通过】
			//直接刷洗子界面【也就是本界面】
			window.location.href="checkContract.do?Contract_status=2&Contract_id="+Contract_id;
		}
	}
	//拒绝
	function refuse(title){ 
		//获取合同Id
		var Contract_id=parseInt($(title).parent("td").parent("tr").find("td:first").text());
		alert(typeof(Contract_id));
		var confirms=confirm("拒绝审核？");
		if(confirms){
			//改变合同表的状态【3：拒绝】
			//直接刷洗子界面【也就是本界面】
			window.location.href="checkContract.do?Contract_status=3&Contract_id="+Contract_id;
		}
	}
</script>
</html>