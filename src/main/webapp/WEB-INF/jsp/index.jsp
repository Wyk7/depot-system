<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="${APP_PATH }/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script src="${APP_PATH }/bootstrap-3.3.5-dist/js/jquery-3.0.0.min.js"></script>
<script src="${APP_PATH }/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<style type="text/css">
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}

.nav .open>a, .nav .open>a:focus, .nav .open>a:hover {
	background-color: #579ec8;
}

.nav>li>a:focus, .nav>li>a:hover {
	background-color: #579ec8;
}

.topscan {
	width: 100%;
	min-height: 50px;
	background-color: #438eb9;
	position: relative;
}

.top-left {
	color: white;
	line-height: 20px;
	padding: 15px 10px;
	float: left;
}

.user-click {
	float: right;
	padding-right: 20px;
}

.leftscan a:hover {
	color: #1963aa;
	background-color: white;
	display: block;
	background-color: white;
}

.leftscan a {
	color: #585858;
	display: block;
	height: 38px;
	line-height: 36px;
	display: block;
}

.leftscan li {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-left: 1px solid #ccc;
	border-right: hidden;
}

body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	background-color: #e4e6e9;
}

ul, li {
	margin: 0;
	padding: 0;
	text-align: center;
}

td {
	text-align: center;
}

tr {
	text-align: center;
}

th {
	text-align: center;
}
</style>
</head>
<body>
	<div class="topscan">
		<div class="top-left">停车场管理系统</div>
		<div class="user-click">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="color: white;"> welcome,
						${sessionScope.user.name } <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">停车管理</a></li>
						<li><a href="#">停车位管理</a></li>
						<li><a href="#">停车卡管理</a></li>
						<li><a href="#">用户管理</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<div>
		<div class="leftscan"
			style="width: 20%; min-height: 100%; float: left; background-color: #eee;">
			<ul style="list-style: none; color: #1963aa;">
				<li id="parkspaceMan" onclick="parkspaceManSpan()"><a>停车位管理</a>
					<ul id="parkspaceMan_span" style="font-size: 12px;">
						<li style="background-color: #cdcdcf;"><a id="simplePark" href="${APP_PATH }/index/toindex">
								< 正常车位</a></li>
						<li style="background-color: #cdcdcf;"><a> < 临时车位 </a></li>
						<li style="background-color: #cdcdcf;"><a> < 紧急车位</a></li>
					</ul></li>
				<li><a href="${APP_PATH }/index/findAllDepotcard" target="main"
					onclick="$('div#main').load(this.href);return false;">停车卡管理</a></li>
				<li><a href="${APP_PATH }/index/findAllDepot" target="main"
					onclick="$('div#main').load(this.href);return false;">停车管理</a></li>
				<li><a href="${APP_PATH }/index/findAllUser" target="main"
					onclick="$('div#main').load(this.href);return false;">用户管理</a></li>
			</ul>
		</div>
		<div id="main"
			style="float: left; width: 80%; min-height: 100%; margin-right: 0; border: 1px solid #ccc; background-color: white;">
			<table class="table">
				<caption>
					<div style="float: left; line-height: 10px; padding: 10px 10px;">车位状况</div>
					<div class="col-lg-6" style="width: 30%; float: left;">
						<div class="input-group">
							<input placeholder="请输入卡号" type="text" class="form-control">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">出库</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
				</caption>
				<tr>
					<th>车位号</th>
					<th>状态</th>
					<th>类型</th>
					<th>操作</th>
					<th>查看</th>
				</tr>
				<c:forEach items="${parkspaces }" var="item">
					<tr>
						<td>${item.parkid }</td>
						<td>${item.status==0?"空":"已停" }</td>
						<td>${item.tag==1?"正常车位":item.tag==2?"临时车位":"紧急车位" }</td>
						<td><c:if test="${item.status==0 }">
								<input class="btn btn-default" type="button"
									onclick="checkIn(${item.parkid},${item.id })" value="入库">
							</c:if> <c:if test="${item.status!=0 }">
								<input onclick="checkOut(${item.parkid})" class="btn btn-default" type="button" value="出库">
							</c:if></td>
						<td><input class="btn btn-default" type="button" value="查看"></td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<form id="checkForm">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button id="checkSubmit" type="button" class="btn btn-primary">提交更改</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</form>
	<!-- /.modal -->
</body>
<script type="text/javascript">
	$("#simplePark").css("background-color","white");
	$('#myModal').on('hidden.bs.modal', function () {
		$(".modal-body").empty();
	})
	function parkspaceManSpan(){
		if(!$("#parkspaceMan_span").is(':visible'))
			{
				$("#parkspaceMan_span").show();
			}
		else{
			$("#parkspaceMan_span").hide();
		}
	}
	/* 入库模态框显示*/
	function checkIn(parknum,id) {
		var html = "<input id=\"id\" name=\"id\" value=\""+id+"\" hidden=\"hidden\"/>"
				+"<input id=\"parkNum\" name=\"parkNum\" value=\""+parknum+"\" hidden=\"hidden\"/><label>入库卡号：</label><div style=\"width: 30%;\">"
				+ "<div class=\"input-group\">"
				+ "<input id=\"cardNum\" name=\"cardNum\" placeholder=\"请输入卡号\" type=\"text\" class=\"form-control\">"
				+ "</div>"
				+ "</div>"
				+ "<label>车牌号：</label><div style=\"width: 30%;\">"
				+ "<div class=\"input-group\">"
				+ "<input id=\"carNum\" name=\"carNum\" placeholder=\"请输入车牌号\" type=\"text\" class=\"form-control\">"
				+ "</div></div>"
				+ "<label>是否临时停车：</label>"
				+"<select id=\"parkTem\" name=\"parkTem\" style=\"width:100px\" class=\"form-control\"> "
				+"<option value=\"0\">否</option><option value=\"1\">是</option> </select>";
		$("#myModalLabel").html("车辆入库");
		$("#checkSubmit").attr("onclick","checkInSubmit()");
		$(".modal-body").append(html);
		$("#myModal").modal('show');
	}
	/* 入库提交 */
	function checkInSubmit(){
		$.ajax({
			type:'post',
			url:'/depot-system/index/check/checkIn',
			datatype:'text',
			data:$("#checkForm").serializeArray(),
			contentType:'application/x-www-form-urlencoded',
			success:function(data){
				$("#myModal").modal('hide');
				document.getElementById("simplePark").click();
				document.getElementById("parkspaceMan").click();
				$("#simplePark").css("background-color","white");
			}
		})
	}
	/* 出库模态框显示 */
	function checkOut(parknum) {
		 $.ajax({
			type:'get',
			url:'/depot-system/index/check/findParkinfoByParknum',
			datatype:'json',
			data:{parkNum:parknum},
			success:function(data){
				debugger;
				if(data.code==100)
					{
				var parkTem="否";
				if(data.extend.parkInfo.parktem==1)
					{
					parkTem="是";
					}
				var html = "<input id=\"parkNum\" name=\"parkNum\" value=\""+parknum+"\" hidden=\"hidden\"/><label>出库卡号：</label><div style=\"width: 30%;\">"
				+ "<div class=\"input-group\">"
				+ "<input id=\"cardNum\" name=\"cardNum\" value=\""+data.extend.parkInfo.cardnum+"\" type=\"text\" class=\"form-control\">"
				+ "</div>"
				+ "</div>"
				+ "<label>车牌号：</label><div style=\"width: 30%;\">"
				+ "<div class=\"input-group\">"
				+ "<input id=\"carNum\" name=\"carNum\" value=\""+data.extend.parkInfo.carnum+"\" type=\"text\" class=\"form-control\">"
				+ "</div></div>"
				+ "<label>是否临时停车：</label><br>"
				+parkTem
				$("#myModalLabel").html("车辆出库");
				$("#checkSubmit").html("出库");
				$("#checkSubmit").attr("onclick","checkOutSubmit()");
				$(".modal-body").append(html);
				$("#myModal").modal('show');
					}
			}
		}) 
	}
	/* 出库提交 */
	function checkInSubmit(){
		$.ajax({
			type:'post',
			url:'/depot-system/index/check/checkOut',
			datatype:'text',
			data:$("#checkForm").serializeArray(),
			contentType:'application/x-www-form-urlencoded',
			success:function(data){
				$("#myModal").modal('hide');
				document.getElementById("simplePark").click();
				document.getElementById("parkspaceMan").click();
				$("#simplePark").css("background-color","white");
			}
		})
	}
</script>
</html>