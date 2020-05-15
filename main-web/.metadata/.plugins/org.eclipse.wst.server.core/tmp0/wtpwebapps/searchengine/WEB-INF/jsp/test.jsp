<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.print(basePath);
		%>
<!DOCTYPE html>
<html>

	<head>
		<script type="text/javascript" src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/search.js"></script>
		<style type="text/css">
		</style>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/searching.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>TEST</title>
	</head>

	<body>
	<div>
	<form action="searching" method="post">
		<div class="header">
		<img alt='加载失败' src="<%=basePath%>img/book.png" class="logoimg"/>
			<input type="text" name="username" id="username" value="${content} " placeholder="输入搜索内容" class="inputtext" />
			<input type="submit" name="" id="" value="搜搜看看" class="button" />
			<input type="text" name="page" value="1" style="display: none;"/>
		</div>
	<from>
		<hr class="hr_span" />
		<div id="body2">
		${data }
		</div>
		<hr class="hr_span" />
		<div class="bottom">请勿随意转载</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {});
		function clickpage(e){
			var url=$(e).attr("href")
			var jsonString = {"url":url};
			$.ajax({
				type:"get",
				url:"addclick?url="+url,
				async:true,
			});
		}
		function loadpage() {
			$("div").remove(".from_next_page")
			var val = $("input[name='page']").val()
			var page = Number(val)+1
			$("input[name='page']").val(page)
			$("#body2").append("<div class=\"loading\"><img alt='加载失败' src=\"http://localhost:8084/searchengine/img/load2.gif\"/></div>")
			var content = $("input[name='username']").val()
			var da = {
				content: content,
				page: page
			}
			$.ajax({
				url: "nextpage",
				cache: false,
				data: da,
				type: "post",
				success:function(data){
					$("div").remove(".loading")
					$("#body2").append(data)
				}
			});
		
		}
	</script>

</html>