<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<script src="./js/jquery-1.8.0.js"></script>
<table  class=" table table-hover" id="searchInfoTab" style="width:1115px;">
				<tr>
					<th>序号</th>
					<th>跟进类型</th>
					<th>客户姓名</th>
					<th>跟进内容</th>
					<th>跟进时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${clientTrailList }" var="clientTrail" varStatus="staus">
					<tr id="${clientTrail.clientTrail_ID }">
						<td>${staus.index + 1 }</td>
						<c:choose>
							<c:when test="${clientTrail.clientTrail_type == 1 }">
								<td>去电</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 2 }">
								<td>勘察</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 3 }">
								<td>面谈</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 4 }">
								<td>短信</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 5 }">
								<td>邮件</td>
							</c:when>
							<c:when test="${clientTrail.clientTrail_type == 6 }">
								<td>其他</td>
							</c:when>
						</c:choose>
						<td>${clientTrail.client_name }</td>
						<td>${clientTrail.clientTrail_content }</td>
						<td><fmt:formatDate value="${clientTrail.clientTrail_Time }" pattern="yyyy-MM-dd  HH:mm" /></td>
						<td>
							<a style="text-decoration: none; color:#0B73DF;" class="optBtn">操作▼</a>
							<div class="optDiv">
								<ul class="optUl">
									<li style="border-bottom: 0px;"><a href="javascript:deleteSingleClientTrail(${clientTrail.clientTrail_ID });">删除</a></li>
								</ul>							
							</div>
						</td>
					</tr>
				</c:forEach>
		</table>
	<div class="btnToolBar" >
		<c:if test="${currentPage == 1 }">	
		<button title="首页" disabled="disabled">&lt;&lt;</button>
		</c:if>
		<c:if test="${currentPage != 1 }">	
		<button title="首页" onclick="splitPage(1)">&lt;&lt;</button>
		</c:if>
		<c:if test="${currentPage <= 1 }">
		<button title="上一页" disabled="disabled">&lt;</button>
		</c:if>	
		<c:if test="${currentPage > 1}">
		<button title="上一页" onclick="splitPage(${currentPage-1})">&lt;</button>
		</c:if>
		<button id="selectBtn" disabled="disabled">第 ${currentPage } 页/共 ${totalPage } 页</button>
		<c:if test="${currentPage == totalPage }">		
			<button title="下一页" disabled="disabled">&gt;</button>
		</c:if>
		<c:if test="${currentPage != totalPage }">
			<button title="下一页" onclick="splitPage(${currentPage+1})">&gt;</button>
		</c:if>		
		<c:if test="${currentPage == totalPage }">	
		<button title="末页" disabled="disabled">&gt;&gt;</button>
		</c:if>
		<c:if test="${currentPage != totalPage }">	
		<button title="末页" onclick="splitPage(${totalPage})">&gt;&gt;</button>
		</c:if>	
	</div>
<script type="text/javascript">

//为操作按钮绑定事件
$(".optBtn").click(function(){
	//var sourcePosition = $(this).offset();
	if($(this).next().css("display") == "none"){
		$(this).next().show("slow");
	}else if($(this).next().css("display") == "block"){
		$(this).next().hide("slow");
	}
	
	//$(".optDiv").offset({top:sourcePosition.top+10,left:sourcePosition.left})
	//$(".optDiv").show("slow");
	
})
//鼠标移入会变色操作选项框
$(".optUl>li").mouseenter(function(){
	$(this).css("background-color","white");
}).mouseleave(function(){
	$(this).css("background-color","wheat");		
})

//ajax 是否删除客户跟进记录 
function deleteSingleClientTrail(clientTrailId){
	console.log($("#"+clientTrailId));
	var confirmAct = confirm("是否确认删除？");
	if(confirmAct){
		$.ajax({
			type:"post",
			url:"deleteClientTrail.do",
			data:{"clientTrail_id":clientTrailId},
			success:function(data){
					$("#"+clientTrailId).remove();
				}
			})
	}
}

//ajax 上一页 下一页 
function splitPage(currentPage){
	$.ajax({
		type:"post",
		url:"main_clientTrailList_ajax.do",
		data:{
				"staff_id":staff_id,
				"page":currentPage,
				"totalPage":totalPage,
			},
		success:function(data){
			$("#tableContent").html(data);
		}
		
	})
}
</script>