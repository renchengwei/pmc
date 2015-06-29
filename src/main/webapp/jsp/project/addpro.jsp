<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/commontaglib.jsp" %>
<script type="text/javascript">
	
	$(document).ready(function(){
		
	});
	
	function saveuser() {
		var isValid = $('#form1').form('validate');
		if (!isValid){
			return;
		}
		postcommit('UserController.do?method=saveUser',$('#form1').serialize(),'',function(result){
			var user = result.data;
			$('#form1').form('load', user);
			$('#loginname').textbox('disable');
			alertInfo('保存成功',function() {back();});
		});
	}
	
	function back() {
		history.back();
	}
	
</script>
</head>
<body class="easyui-layout" style="width:100%;padding: 0px;margin: 0px;border:0px">
	<div region="north" class="headSkin" style="height:30px;padding:5px;border-left: 0px;border-top: 0px;border-right: 0px;">
   		<div style="padding:0px;margin: 0px;font-size: 16px;">
   			<a style="text-decoration: none;" href="<%=basePath%>main.jsp">首页</a>-><a style="text-decoration: none;" href="<%=basePath%>jsp/project/prolist.jsp">项目管理</a>
   			-><a style="text-decoration: none;" href="<%=basePath%>jsp/project/addpro.jsp">项目立项</a>
   		</div>
	</div>
	<div region="center" border="false">
	
	<div class="easyui-panel" nohead="true" border="false">
		
		<div id="paneltitle" title="项目信息" class="easyui-panel" style="padding:10px 10px 10px 0px">
			<form id="form1">
            <table style="width:100%;">
				<tr>
					<td style="text-align:right;width:15%">项目名称:</td>
					<td style="width:85%; text-align:left">
						<input id="loginname" name="loginname" class="easyui-textbox" style="width:60%" 
							data-options="required:true,validType:'length[0,50]'"></input>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">项目经理:</td>
					<td style="text-align:left">
						<input id="roleid" class="easyui-combobox" name="roleid" style="width:60%" editable="false" panelHeight="auto"
    						data-options="required:true,valueField:'id',textField:'name',url:'UserController.do?method=getRoles',loadFilter:errorFilter">
					</td>
				</tr>
			</table>
            <input type="hidden" id="id" name="id">
            <input type="hidden" id="pid" name="pid">
            <input type="hidden" id="mark" name="mark">
            <input type="hidden" id="isdel" name="isdel">
            <input type="hidden" id="deltime" name="deltime">
            <input type="hidden" id="deluser" name="deluser">
            </form>
		</div>

		<div style="text-align:center;padding:5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-saveBtn'" onclick="saveuser()">保存</a>
 			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-backBtn'" onclick="back()">返回</a>
		</div>
	</div>
	</div>
</body>
</html>