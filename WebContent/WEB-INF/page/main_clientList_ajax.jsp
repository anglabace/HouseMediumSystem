<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script src="./js/jquery-1.8.0.js"></script>
<table class=" table table-hover" id="searchInfoTab"
	style="width: 1115px;">
	<tr>
		<th>序号</th>
		<th>客户姓名</th>
		<th>地段要求</th>
		<th>客户类型</th>
		<th>客户状态</th>
		<th>面积区间</th>
		<th>价格区间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${clientList }" var="client" varStatus="status">
		<tr id="${client.client_id }">
			<td>${status.index + 1 }</td>
			<td>${client.client_name }</td>
			<c:forEach items="${client.clientReqList }" var="creq">
				<td>${creq.siteRequirement }</td>
				<c:if test="${creq.client_type == 1 }">
					<td>求购</td>
				</c:if>
				<c:if test="${creq.client_type == 2 }">
					<td>求租</td>
				</c:if>
			</c:forEach>
			<c:choose>
				<c:when test="${client.client_status == 1 }">
					<td>已成交</td>
				</c:when>
				<c:when test="${client.client_status == 2 }">
					<td>未处理</td>
				</c:when>
				<c:when test="${client.client_status == 3 }">
					<td>求购中</td>
				</c:when>
				<c:when test="${client.client_status == 4 }">
					<td>已搁置</td>
				</c:when>
				<c:when test="${client.client_status == 5 }">
					<td>求租中</td>
				</c:when>
			</c:choose>
			<c:forEach items="${client.clientReqList }" var="creq">
				<td>${creq.min_area }-- ${creq.max_area }(平)</td>
				<td>${creq.min_price }-- ${creq.max_price }(万元)</td>
			<td><a style="text-decoration: none; color: #0B73DF;"class="optBtn">操作▼</a>
				<div class="optDiv">
					<ul class="optUl">
						<c:if test="${client.client_status != 1 }">
							<li><a
								href="main_editClient.do?client_id=${client.client_id }">编辑</a></li>
							<c:if test="${creq.client_type == 1 }">
								<li><a href="findHouseRsesourceByClientReq.do?staff_id=${sessionScope.loginStaff.staff_id }&application_id=${creq.application_Id }&minPrice=${creq.min_price}&maxPrice=${creq.max_price}&siteRequirement='${creq.siteRequirement }'&flag=1">房源快速匹配</a></li>
								</c:if>
								<c:if test="${creq.client_type == 2  }">
								<li><a href="findHouseRsesourceByClientReq.do?staff_id=${sessionScope.loginStaff.staff_id }&application_id=${creq.application_Id }&minPrice=${creq.min_price}&maxPrice=${creq.max_price}&siteRequirement='${creq.siteRequirement }'&flag=2">房源快速匹配</a></li>
								</c:if>
						</c:if>

						<li><a
							href="javascript:showDialog('${client.client_name }' ,'${sessionScope.loginStaff.staff_name }',${client.client_id });">+加跟进</a></li>
						<c:if test="${client.client_status != 1 }">
							<li style="border-bottom: 0px;"><a
								href="javascript:deleteSingleClient(${client.client_id });">删除</a></li>
						</c:if>
					</ul>
				</div>
			</td>
			</c:forEach>
		</tr>
	</c:forEach>
</table>
<div class="btnToolBar" >
	
	<c:if test="${currentPage != 1 }">
		<button title="首页" onclick="splitPage(1);">&lt;&lt;</button>
	</c:if>
	<c:if test="${currentPage == 1 }">
		<button title="首页" disabled="disabled">&lt;&lt;</button>
	</c:if>
	<c:if test="${currentPage-1 <= 0 }">
	<button title="上一页" disabled="disabled">&lt;</button>
	</c:if>
	<c:if test="${currentPage-1 > 0 }">
	<button title="上一页" onclick="splitPage(${currentPage-1 });">&lt;</button>
	</c:if>
	<button id="selectBtn" disabled="disabled">第 ${currentPage } 页/共 ${totalPage } 页</button>
	<c:if test="${currentPage == totalPage }">
		<button title="下一页" disabled="disabled">&gt;</button>
	</c:if>
	<c:if test="${currentPage != totalPage }">
		<button title="下一页" onclick="splitPage(${currentPage+1 });">&gt;</button>
	</c:if>
	<c:if test="${currentPage != totalPage}">
		<button title="末页" onclick="splitPage(${totalPage})">&gt;&gt;</button>
	</c:if>
	<c:if test="${currentPage == totalPage}">
		<button title="末页" disabled="disabled">&gt;&gt;</button>
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
	
	
	//显示阴影层和浮动层
	function showDialog(clientName,staffName,clientId){
		//传值
		$("#client_name").val(clientName);
		$("#staff_name").val(staffName);
		$("#client_id").val(clientId);
		//显示
		$(".dialog").show();
		$(".shadow").show();
	}
	
	//关闭阴影层和浮动层
	function closeDiv(){
		$(".dialog").hide();
		$(".shadow").hide();
	}
	
	//ajax 上一页 下一页 异步请求 
	function splitPage(currentPage){
		//如果是当前小于等于0 即为第一页 
		//if(currentPage <= 0){
		//	currentPage = 1;	
		//}
		//如果是当前大于等于最后一页  即为最后一页  
		//if(currentPage >=totalPage){
		//	currentPage = totalPage;
		//}
		
		$.ajax({
			type:"post",
			url:"main_clientList_ajax.do",
			data:{"staff_id":staff_id, 
				  "page":currentPage,
				  "totalPage":totalPage,
				},
			success:function(data){
				$("#tableContent").html(data);
			}
		})
	}

</script>
