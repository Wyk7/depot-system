<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

	<table class="table">
				<caption>
					<div style="float: left; line-height: 10px; padding: 10px 10px;">用户状况</div>
					<button class="btn btn-default" type="button">添加用户</button>
				</caption>
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>联系电话</th>
					<th>权限</th>
					<th>用户卡</th>
					<th>操作</th>
				</tr>
					<tr>
						<td><input class="btn btn-default" type="button" value="入库"></td>
						<td><input class="btn btn-default" type="button" value="查看"></td>
						<td><input class="btn btn-default" type="button" value="查看"></td>
						<td><input class="btn btn-default" type="button" value="查看"></td>
						<td><input class="btn btn-default" type="button" value="查看"></td>
						<td><input class="btn btn-default" type="button" value="查看"></td>
						<td><input class="btn btn-default" type="button" value="修改"><input class="btn btn-default" type="button" value="删除"></td>
					</tr>
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
