<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="/commontaglib.jsp" %>
<script type="text/javascript">

	$(document).ready(function() {
	});


</script>

</head>

<body class="easyui-layout" style="width: 100%; height: 100%">
	<div region="north" class="headSkin" style="height:30px;padding:5px;border-left: 0px;border-top: 0px;border-right: 0px;">
   		<div style="padding:0px;margin: 0px;font-size: 16px;">
   			<a style="text-decoration: none;" href="<%=basePath%>main.jsp">首页</a>-><a style="text-decoration: none;" href="<%=basePath%>jsp/project/prolist.jsp">项目管理</a>
   			-><a style="text-decoration: none;" href="<%=basePath%>jsp/project/prodetails.jsp">项目信息</a>
   		</div>
   	</div>
	<div region="center" style="width: 100%; border: 0px" noheader="true">
		<div class="easyui-tabs" fit="true">
			<div title="项目概要" style="padding:10px">
	            <table style="width:100%;">
	            	<tr>
					<td style="text-align:right;width:15%">项目名称:</td>
					<td style="width:85%; text-align:left">
						<input id="loginname" name="loginname" class="easyui-textbox" style="width:60%" 
							data-options="required:false,validType:'length[0,50]'"></input>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">项目经理:</td>
					<td style="text-align:left">
						<input id="loginname" name="loginname" class="easyui-textbox" style="width:60%" 
							data-options="required:false,validType:'length[0,50]'"></input>
					</td>
				</tr>
	            </table>
	        </div>	
			<div title="招标预算" style="padding:10px">
	            <iframe style="height: 100%;width: 100%;border: 0px;" src="<%=basePath%>jsp/project/zbys.jsp"></iframe>
	        </div>	
			<div title="施工测算" style="padding:10px">
	            
	        </div>	
			<div title="采购计划" style="padding:10px">
	            
	        </div>	
			<div title="物料换购" style="padding:10px">
	            
	        </div>	
			<div title="物料采购" style="padding:10px">
	            
	        </div>	
			<div title="物料入库" style="padding:10px">
	            
	        </div>	
			<div title="采购批款" style="padding:10px">
	            
	        </div>	
			<div title="物料领取" style="padding:10px">
	            
	        </div>	
		</div>
	</div>
	</body>
</HTML>