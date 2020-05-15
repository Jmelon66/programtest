<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.print(basePath);
		%>
<html>
	<head>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/search.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css"/>
		<style type="text/css">
		</style>
		<meta charset="UTF-8" http-equiv="Content-Type" content="text/html;charset=utf-8"> 
		<title>Home</title>
	</head>
	<body>
	<div id="body">
	<form action="searching" method="POST">
		<div class="inbody">
		   <div class="header">
		   	<img alt='加载失败' src="<%=basePath%>img/booklogo.png"/>
		   </div>
		   	<div>
			<input type="text" name="username" id="username" value="" placeholder="输入搜索内容" class="inputtext"/>
			<input type="submit" name="" id="" value="搜搜看看" class="button"/>
		   </div>
		</div>
		</form>
	</div>
	</body>
	<script type="text/javascript">
	</script>
</html>