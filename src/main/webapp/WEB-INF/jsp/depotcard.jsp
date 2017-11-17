<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
	<table class="table">
				<caption>
					<div style="float: left; line-height: 10px; padding: 10px 10px;">车位状况</div>
					<div class="col-lg-6" style="width: 30%; float: left;">
						<div class="input-group">
							<input placeholder="请输入卡号" type="text" class="form-control" > <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">查询</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
					<button style="float: left;" class="btn btn-default" type="button">添加停车卡</button>
				</caption>
				<tr>
					<th>卡号</th>
					<th>卡类型</th>
					<th>余额</th>
					<th>持卡人</th>
					<th>发卡时间</th>
					<th>挂失</th>
					<th>查看</th>
				</tr>
					<tr>
						<td><input class="btn btn-default" type="button" value="查看"></td>
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
