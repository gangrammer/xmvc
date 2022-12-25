<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="row" style="margin-top: 40px">
			<div class="col-md-8 col-md-offset-2 ">
				<div class="panel panel-primary">
					<div class="panel-heading">用户列表</div>

					<table class="table table-bordered table-hover text-center">
						<thead>
							<tr class="info">
								<td>用户名称</td>
								<td>用户密码</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="u" items="${userList}">
								<tr>
									<td>${u.userName }</td>
									<td>${u.password }</td>
									<td><a href='${pageContext.request.contextPath}/users/delete?id=${u.id}'>删除</a>
										<a href='${pageContext.request.contextPath}/users/findById?id=${u.id}'>修改</a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>

		</div>
		<div class="row" style="width: 200px">
			<form action="${pageContext.request.contextPath}/users/save" method="post">
				<div class="form-group">
					<label for="id">用户ID</label> <input type="text"
														class="form-control" name="id" placeholder="请输入用户Id">
				</div>
				<div class="form-group">
					<label for="userName">用户名</label> <input type="text"
															 class="form-control" name="userName" placeholder="请输入用户名">
				</div>
				<div class="form-group">
					<label for="password">密码</label> <input type="text"
															class="form-control" name="password" placeholder="请输入密码">
				</div>
				<div class="form-inline text-right">
					<button type="submit" class="btn btn-primary">保存</button>
					<button type="reset" class="btn btn-default" focus>重置</button>
				</div>
			</form>
		</div>
		<div class="row" style="width: 200px" style="margin-top: 40px">
			<form action="${pageContext.request.contextPath}/users/update" method="post">
				<div class="form-group">
					<label for="id">用户Id</label> <input type="text"
														class="form-control" name="id" placeholder="请输入用户名"
														value="${editUser.id}">
				</div>
				<div class="form-group">
					<label for="userName">用户名</label> <input type="text"
															 class="form-control" name="userName" placeholder="请输入用户名"
															 value="${editUser.userName}">
				</div>
				<div class="form-group">
					<label for="password">密码</label> <input type="text"
															class="form-control" name="password" placeholder="请输入密码"
															value="${editUser.password}">
				</div>
				<div class="form-inline text-right">
					<button type="submit" class="btn btn-primary">更新</button>
					<button type="reset" class="btn btn-default" focus>重置</button>
				</div>
			</form>

			<form action="${pageContext.request.contextPath}/users/search" method="post">
				<div class="row">
					<div class="col-sm-2"><label for="userName">用户名</label></div>
					<div class="col-sm-4"><input type="text" class="form-control" name="userName" placeholder="请输入用户名"></div>
					<div class="col-sm-6"><button type="submit" class="btn btn-primary">查询</button></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>