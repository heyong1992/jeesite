<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/hey/eHey/">单表列表</a></li>
		<shiro:hasPermission name="hey:eHey:edit"><li><a href="${ctx}/hey/eHey/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="eHey" action="${ctx}/hey/eHey/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>name：</label>
				<input class="form-control" type="text" id="name" name="name" max="60"  >
			</li>
			<li><label>address：</label>
				<input class="form-control" type="text" id="address" name="address" max="60"  >
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>name</th>
				<th>address</th>
				<shiro:hasPermission name="hey:eHey:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="eHey">
			<tr>
				<td><a href="${ctx}/hey/eHey/form?id=${eHey.id}">
					${eHey.name}
				</a></td>
				<td>
					${eHey.address}
				</td>
				<shiro:hasPermission name="hey:eHey:edit"><td>
    				<a href="${ctx}/hey/eHey/form?id=${eHey.id}">修改</a>
					<a href="${ctx}/hey/eHey/delete?id=${eHey.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>