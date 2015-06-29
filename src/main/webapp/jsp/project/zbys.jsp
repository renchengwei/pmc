<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.datagrid-row { 
		height: 30px;
		cursor: pointer;
	}
</style>
<%@ include file="/commontaglib.jsp" %>
<script type="text/javascript">

	var depid = '${param.id}';
	
	$(document).ready(function(){
		initdg();
		//initbtnClick();
	});
	
	
	function initbtnClick() {
		$("#btn").click(function(){		
			$('#dg').datagrid('load',{
				pid:depid,
				name:$('#name').val(),
				duty:$('#duty').combobox("getValue")
			});
		});
	}
	
	function onClickRow(rowIndex, rowData) {
		window.location.href="<%=basePath%>jsp/project/prodetails.jsp";
	}
	
	var data = [{"name":"a"},{"name":"b"}];
	function initdg() {
		$('#dg').datagrid({
// 	       	url:'UserController.do?method=getUsersByPage',
			data:data,
			pagination:true,
			rownumbers:true,
			pageSize:10,
			pageList:[10,20,30],
			singleSelect:true,
			checkOnSelect:true,
			onClickRow:onClickRow,
			queryParams: {
				pid: depid,
			},
			columns:[[
				{field:'name',title:'项目名称',width:'50%'},
				{field:'name',title:'项目经理',width:'50%	'},
// 				{field:'pid',title:'所属部门',width:150,
// 					 formatter: function(value,row,index){ 
// 				            if(row.dep){return row.dep.name;}
// 				      }
// 				},
// 				{field:'mobile',title:'移动电话',width:150},
// 				{field:'workphone',title:'办公电话',width:150},
// 				{field:' ',title:'操作',width:100,align:'center',
// 					formatter: function(value,row,index){
// 				      return "<a  href='javaScript:deleteUser(\""+row.id+"\")'>删除</a>&nbsp;&nbsp;&nbsp;" + 
// 					  "<a  href='javaScript:updateUser(\""+row.id+"\")'>修改</a>";//html 元素	
// 					}	   
// 				}
			]],
			loadFilter:errorFilter
		});
	}
	//新建用户
	function adduser() {
		window.location.href="<%=basePath%>jsp/project/addpro.jsp";
	}
	//更新用户
	function updateUser(id) {
		window.location.href="<%=basePath%>jsp/user/adduser.jsp?id=" + id;
	}
	//删除用户
	function deleteUser(id) {
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	postcommit('UserController.do?method=deleteUser',{id:id},'',function(result){
					$('#btn').trigger("click");
				});  
		    }    
		}); 
	}
</script>
</head>
<body class="easyui-layout" style="width:100%;padding: 0px;margin: 0px;border:0px">
    <div region="center" border="false">
	  <table id="dg"  fit="true"  border="false">
      </table>
	</div>
</body>
</html>