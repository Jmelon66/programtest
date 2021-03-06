<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html;charset=utf-8;width=device-width,initial-scale=1.0;">
<title>冲浪搜索管理</title>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mana.css" />
<script  type="text/javascript" src="<%=basePath%>js/mana.js"></script>

</head>

<body>
	<div class="from-input-pan">
		<div class="from-input-mpan">
			<div class="modal-header">
				<button type="button" class="close" onclick="closeinp()">&times;</button>
				<h4 class="modal-title" id="myModalLabel">具体消息</h4>
			</div>
			<hr />
			<textarea class="from-suginfo" readonly="true" id="concrete"></textarea>
		</div>
		<div class="from-input-mpan" style="display: none;">
			<div class="modal-header">
				<button type="button" class="close" onclick="closeinp()">&times;</button>
				<h4 class="modal-title" id="myModalLabel">违规网站添加</h4>
			</div>
			<div class="input-group">
				<span class="input-group-addon">网站:</span> <input type="text"
					class="form-control input" placeholder="www" name="banurl">
			</div>
			<div class="input-group">
				<span class="input-group-addon">原因:</span>
				<textarea class="form-control input" placeholder="如暴力，请简述"
					id="banreason"></textarea>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeinp()">关闭</button>
				<button type="button" class="btn btn-primary" onclick="addbanf(this)">提交</button>
			</div>
		</div>
	</div>
	<div class="from-main">
		<div class="form-nav">
			<nav>
				<a onclick="Switchpan(0)" class="nav-click">爬虫管理</a> <a
					onclick="Switchpan(1)" class="nav-click">词库管理</a> <a
					onclick="Switchpan(2)" class="nav-click">热点配置</a> <a
					onclick="Switchpan(3)" class="nav-click">违规处理</a> <a
					onclick="Switchpan(4)" class="nav-click">意见箱管理</a>
			</nav>
		</div>
		<div class="from-content" style="display: none;">
			<hr />
			<div class="input-group">
				<span class="input-group-addon">循环间隔:</span> <input type="number"
					class="form-control input" placeholder="${delayTime}" name="delayTime">
			</div>
			<div class="input-group">
				<span class="input-group-addon">爬取数量:</span> <input type="number"
					class="form-control input" placeholder="${carrynum}" name="carrynum">
			</div>
			<button type="button" class="btn btn-primary" data-toggle="button"
				onclick="spidertretry()">保存设置</button>
			<hr />
			<h4>定点爬取</h4>
			<div>
				<div class="input-group">
					<span class="input-group-addon">网站URL:</span> <input
						class="form-control input" placeholder="www.baidu.com" name="HURL">
				</div>
				<div class="input-group">
					<span class="input-group-addon">爬取数量:</span> <input type="number"
						class="form-control input" placeholder="50" name="caughnum">
				</div>
				<button type="button" class="btn btn-primary" data-toggle="button"
					onclick="spiderstart()">启动</button>
			</div>
			<hr />
			<div class="retip"></div>
		</div>
		<div class="from-content" style="display: none;">
			<div class="form-group ">
				<input type="text" class="form-control" id="name"
					placeholder="请输入名称" name="skey">
				<button type="button" class="btn btn-primary" data-toggle="button"
					onclick="opskey(1)">搜索</button>
				<button type="button" class="btn btn-primary" data-toggle="button"
					onclick="opskey(2)">检索</button>
			</div>
			<hr />
			<div class="from-opkey">
			<table class="table table-striped table-word">

				<caption>词表</caption>
				<thead>
					<tr>
						<th>序号</th>
						<th>词</th>
						<th>搜索量</th>
						<th>热度</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="opkey">
					<tr>
						<th>词</th>
						<th>被检索次数</th>
						<th>
							<div class="glyphicon glyphicon-remove op-del" title="删除"></div>
						</th>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
		<div class="from-content" style="display: none;">
			<div class="from-hotmana">
				<div class="form-hotmana-key">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>排名</th>
									<th>词名</th>
									<th>量</th>
									<th>热度</th>
								</tr>
							</thead>
							<tbody class="wrank">
							</tbody>
						</table>
					</div>
				</div>
				<div class="hr-horizontal"></div>
				<div class="form-hotmana-key">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>排名</th>
									<th>热点名</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody class="hotmana">
								<tr>
									<th>词</th>
									<th>被检索次数</th>
									<th>
										<div class="glyphicon glyphicon-pencil op-del" title="删除"></div>
									</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="from-content" style="display: none;">
			<div class="form-group ">
				<button type="button" class="btn btn-primary" data-toggle="button"
					onclick="addban()">添加</button>
				<button type="button" class="btn btn-primary" data-toggle="button"
					onclick="searban()">检索</button>
			</div>
			<hr />
			<table class="table table-striped">

				<caption>网页</caption>
				<thead>
					<tr>
						<th>网页</th>
						<th>违规原因</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class='banhurl'>
					<tr>
						<th>2</th>
						<th>1</th>
						<th>
							<div class="glyphicon glyphicon-remove op-del" title="删除" onclick="delbanh(this)"></div>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="from-content" style="display: none;">
			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-primary"> <input type="radio"
					name="selectmes" id="option1" value="1" checked="checked"
					onchange="sugtype(2)">全部
				</label> <label class="btn btn-primary"> <input type="radio"
					name="selectmes" value="2" id="option2" onchange="sugtype(1)">未读
				</label> <label class="btn btn-primary"> <input type="radio"
					name="selectmes" value="2" id="option2" onchange="sugtype(0)">已读
				</label>
			</div>
			<hr />
			<table class="table table-striped">

				<caption>消息</caption>
				<thead>
					<tr>
						<th>来源</th>
						<th>信息</th>
						<th>时间</th>
						<th>是否已读</th>
					</tr>
				</thead>
				<tbody id="sugcon">
					<tr>
						<th>2</th>
						<th>1</th>
						<th>2</th>
						<th>
						<span class="glyphicon glyphicon-folder-open op-del" title="具体" onclick="toiinfo(this)"></span>
							<span class="glyphicon glyphicon-remove op-del" title="删除" onclick="delmes(1)"></span>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
function sugtype(e){
	var da = {
		type : e
	}
	$.ajax({
		url : "opensug",
		cache : false,
		data : da,
		type : "post",
		success : function(data) {
			$("#sugcon").html(data);
		}
	});
}
function toiinfo(e,id){
	$('.from-input-pan').show();
	$('.from-input-pan').children('.from-input-mpan').hide();
	$('.from-input-pan').children('.from-input-mpan').eq(0).show();
	var t=$(e).parents('tr').children('td');
	var con=t.eq(1).html();
	var ori=t.eq(0).html();
	var time=t.eq(2).html();
	var info=con+"，时间："+time
	$('#concrete').val(info);
	t.eq(3).html("<span class='glyphicon glyphicon-folder-open op-del' title='具体' onclick='toiinfo(this,"+id+")'></span><span class='glyphicon glyphicon-remove op-del' title='删除' onclick='delmes(this,"+id+")'></span>");
	var da = {
		id : id
	}
	$.ajax({
		url : "sugread",
		cache : false,
		data : da,
		type : "post",
		success : function(data) {
		}
	});
}
function delmes(t,id){
	
	var da = {
			id : id
		}
	var f= confirm("确定删除吗？");
	if(f==true){
	var t1=$(t).parents('tr');
	$(t1).remove();
		$.ajax({
			url : "sugdel",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
			}
		});
	}
}

</script>

</html>