<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table class="table">
				<caption>
					<div style="float: left; line-height: 10px; padding: 10px 10px;">查询停车卡</div>
					<div class="col-lg-6" style="width: 30%; float: left;">
						<div class="input-group">
							<input id="cardnum2" placeholder="请输入卡号" type="text" class="form-control" > <span
								class="input-group-btn">
								<button class="btn btn-default" type="button" onclick="findDepotcardByCardnum()">查询</button>
								<a id="findDepotcard" href="" target="main"
					onclick="$('div#main').load(this.href);return false;"></a>
							</span>
						</div>
						<!-- /input-group -->
					</div>
					<button style="float: left;" class="btn btn-default" type="button" onclick="addDepotCard()">添加停车卡</button>
					<button style="float: right; margin-right: 30px" class="btn btn-default" type="button" onclick="">充值停车卡</button>
				</caption>
				<tr>
					<th>卡号</th>
					<th>卡类型</th>
					<th>余额</th>
					<th>持卡人</th>
					<th>发卡时间</th>
					<th>挂失</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${depotcardManagerDatas }" var="item">
					<tr>
						<td>${item.cardnum }</td>
						<td>${item.type }</td>
						<td>${item.money }</td>
						<td>${item.username }</td> 	
						<td>${item.time }</td>
						<td>${item.islose==0?"否":"是" }</td>
						<td><input class="btn btn-default" type="button" onclick="" value="修改"><input class="btn btn-default" type="button" value="删除"></td>
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
			
<script type="text/javascript">
/* 添加停车卡模态框显示*/
function addDepotCard() {
	$.ajax({
		type:'get',
		url:'/depot-system/index/card/findAllCardType',
		datatype:'json',
		data:'',
		success:function(data){
			debugger;
			var option="";
			if(data.code==100)
				{
				for(var i=0;i<(data.extend.cardTypes).length;i++)
					{
					option+="<option value=\""+data.extend.cardTypes[i].id+"\">"+data.extend.cardTypes[i].type+"</option>";
					}
	var html = "<label>用户手机：</label><div style=\"width: 30%;\">"
			+ "<div class=\"input-group\">"
			+ "<input id=\"username\" name=\"username\" placeholder=\"请输入用户手机\" type=\"text\" class=\"form-control\">"
			+ "</div>"
			+ "</div>"
			+ "<label>金额：</label><div style=\"width: 30%;\">"
			+ "<div class=\"input-group\">"
			+ "<input id=\"money\" name=\"money\" placeholder=\"输入金额\" type=\"text\" class=\"form-control\">"
			+ "</div></div>"
			+ "<label>类型：</label>"
			+"<select id=\"type\" name=\"type\" style=\"width:100px\" class=\"form-control\"> "
			+option;
			+"</select>";
	$("#myModalLabel").html("添加停车卡");
	$("#checkSubmit").attr("onclick","addDepotCardSubmit()");
	$(".modal-body").append(html);
	$("#myModal").modal('show');
				}
		}
	}) 
}
/* 添加停车卡提交 */
function addDepotCardSubmit(){
	$.ajax({
		type:'post',
		url:'/depot-system/index/card/addDepotCard',
		datatype:'text',
		data:$("#checkForm").serializeArray(),
		contentType:'application/x-www-form-urlencoded',
		success:function(data){
			if(data.code==100)
				{
				alert("添加成功！您的卡号为："+data.extend.depotcard.cardnum+"。<br/>账号密码为："+data.extend.username+"。");
				}else{
				}
			$("#myModal").modal('hide');
			window.location.href="/depot-system/index/toDepotcardIndex";
		}
	})
}

function findDepotcardByCardnum()
{
	var cardnum=$("#cardnum2").val();
	if(cardnum=="")
		{
		alert("输入不能为空");
		}else{
			$("#findDepotcard").attr("href","${APP_PATH }/index/toDepotcardIndex?cardnum="+cardnum);
			$("#findDepotcard").click();
		}
	
}
</script>