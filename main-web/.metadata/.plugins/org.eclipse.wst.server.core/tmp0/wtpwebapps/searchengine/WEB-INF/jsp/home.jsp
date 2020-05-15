<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);
%>
<html>
<head>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/search.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/home.css" />
<style type="text/css">
</style>
<meta charset="UTF-8" http-equiv="Content-Type"
	content="text/html;charset=utf-8">
<title>冲浪搜索</title>
</head>
<body>
	<div id="body">
	<form action="searchurl" method="POST">
		<div class="inbody">
		   <div class="header">
		   	<img alt='加载失败' src="<%=basePath%>img/sea.png"/>
		   </div>
		   	<div class="from-op">
			<input type="text" name="searchkey" id="searchkey" value="" placeholder="输入搜索内容" class="inputtext"/>
			<input type="submit" name="" id="button-click" value="搜搜" class="button-sub"/>
		   </div>
		</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>