<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<html>
	<style>
		.file-box{ position:relative;width:340px} 
		.txt{ height:22px; border:1px solid #cdcdcd; width:180px;} 
		.btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:70px;} 
		.file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px } 
		.myStaffHead{width:200px;height:200px;overflow: cover;}
	</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户上传图片页面</title>
 <base href="<%=basePath%>"> 
</head>
<body>
		<center class="file-box">  
        <form action="upLoadPic.do"  
            method="post" enctype="multipart/form-data">  
            <input type='text' name='textfield' id='textfield' class='txt' />
            <input type='button' class='btn' value='浏览...' /> 
            <input type="file" name="file" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value"/>   
            <input type="submit" class="btn" value="上传" />  
        </form>  
        <h5>上传结果：</h5>  
        <img id="img" class="myStaffHead" alt="暂无图片" src="${fileUrl}" />  
    </center>  
</body>
<script type="text/javascript">
</script>
</html>