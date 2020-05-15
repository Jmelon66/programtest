	$(function() {
		$('.from-input-pan').hide();
		var da = {
				type : 2
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
	});
	function addban(){
		$('.from-input-pan').show();
		$('.from-input-pan').children('.from-input-mpan').hide();
		$('.from-input-pan').children('.from-input-mpan').eq(1).show();
	}
	function refreshpa(){
		$.ajax({
			url : "hotrefresh",
			cache : false,
			type : "post",
			success : function(data) {
				$(".wrank").html(data.f);
				$(".hotmana").html(data.s);
			},
			 error:function(data,type, err){
		         console.log("ajax错误类型："+type);
		         console.log(err);
		    }

		});
	}
	function Switchpan(e) {
		var at = $(".form-nav nav").children("a");
		var pcon = $(".from-content");
		at.removeClass('nav-click');
		at.removeClass('nav-clicked');
		at.addClass('nav-click');
		at.eq(e).removeClass('nav-click');
		at.eq(e).toggleClass('nav-clicked');
		pcon.hide();
		pcon.eq(e).show();
		if(e=2){
			refreshpa();
		}
	}

	function spiderstart() {
		var SleepTime = 10;
		var RetryTimes = 2;
		var CycleRetryTimes = 10;
		var url = $("input[name='HURL']").val();
		
		var Page =1;
		var maxcount = Number($("input[name='caughnum']").val())
		var da = {
			SleepTime : SleepTime,
			RetryTimes : RetryTimes,
			CycleRetryTimes : CycleRetryTimes,
			url : url,
			Page : Page,
			maxcount : maxcount
		}
		$(".retip").html("start");
		$.ajax({
			url : "runstart",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				$(".retip").html(data);
			},
		});
	}
	function refreshban(e){
		var url = null;
		var reason = 0;
		var da = {
			url : url,
			reason : reason,
		}
		$.ajax({
			url : "addban",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				$(".banhurl").html(data);
			},
		});
	}
	function addbanf(e) {
		var url = $("input[name='banurl']").val();
		var reason = $("#banreason").val()
		var da = {
			url : url,
			reason : reason,
		}
		
		$.ajax({
			url : "addban",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				$(".banhurl").html(data);
				$('.from-input-pan').hide();
			},
		});
	}
	function searban(e) {
		var url = null;
		var reason ="123";
		var da = {
			url : url,
			reason : reason,
		}
		$.ajax({
			url : "addban",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				$(".banhurl").html(data);
			},
		});
	}
	function spidertretry() {
		var RetryTimes = $("input[name='delayTime']").val();
		var maxcount = Number($("input[name='carrynum']").val())
		var da = {
			RetryTimes : RetryTimes,
			maxcount : maxcount
		}
		$.ajax({
			url : "spretry",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				$(".retip").html(data);
			},
		});
	}
	function opskey(e) {
		var okey = $("input[name='skey']").val();
		var type=0;
		if(e==2){
			okey=null;
			type=1;
		}
		var da = {
		    skey : okey,
			type : type
		}
		$.ajax({
			url : "wordop",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				console.log(data);
				$(".opkey").html(data);
			},
		});
	}
	function opdeletekey(e) {
		var t=e;
		$(t).parents('tr').remove();
	}
	function oprekey(){
		var newhot=window.prompt("热点配置","新的热点");
		$('.hotmana').children('tr').each(function(){
			var t=$(this).children('td').eq(1).html();
			if(t==newhot){
				newhot=oprekey();
				return false;
			}
		});
		return newhot;
	}
	function closeinp(){
		$('.from-input-pan').hide();
	}
	function oprehot(e) {
		var t=e;
		var newhot=oprekey();
		var t1=$(t).parents('tr').children('td');
		var old=t1.eq(1).html();
		$(t).parents('tr').children('td').eq(1).html(newhot);
		var da = {
				oldhot : old,
				newhot : newhot
			}
		$.ajax({
			url : "switchhot",
			cache : false,
			data : da,
			type : "post",
			success : function(data) {
				console.log(data);
			},
		});
	}
	function delbanh(e) {
		var t=e;
		var f= confirm("确定删除吗？");
		if(f==true){
			var t1=$(t).parents('tr');
			var url=$(t1).children('td').eq(0).html();
			var reason=$(t1).children('td').eq(1).html();
			var da = {
					url : url,
					reason : reason
				}
			$(t1).remove();
			$.ajax({
				url : "delbh",
				cache : false,
				data : da,
				type : "post",
				success : function(data) {
				}
			});
		}
		
	}