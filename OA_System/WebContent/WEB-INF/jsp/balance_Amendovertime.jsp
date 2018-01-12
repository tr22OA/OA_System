<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加班结余——修改加班</title>
<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css" />
<script src="../plugs/layui/layui.js"></script> 
<style>
	body{background-color:#F1F6FF;}
	#xgjb-bigdiv{border:0px solid red;padding: 10px;}
	#xgjb-table{border:1px solid #009688;}
	td{border:1px solid #ccc;}
	.td1,#td3{width:150px;height:35px;text-align:right;color:#666666;font-weight:bold;}
	.td2{width:500px;height:28px;color:#666;}
	#td3,#td4{height:80px;}
	#td4{width:500px;}
	#td4 input{height:50px;width:400px;}
	#tian{height:25px;}
	#bottom-div{margin-top:20px;text-align:center;}
	
</style>
</head>
<body>
	<div id="xgjb-bigdiv">
		<div >
			<form class="layui-form" action="to_form" >
				<table id="xgjb-table">
					<tbody>
						<tr>
							<td class="td1">姓名:</td>
							<td class="td2">&nbsp;&nbsp;${to_balancevo.empName}</td>
						</tr>
						<tr>
							<td class="td1">年份:</td>
							<td class="td2">&nbsp;&nbsp;${to_balancevo.year}</td>
						</tr>
						<tr>
							<td class="td1">加班结余:</td>
							<td class="td2">&nbsp;&nbsp;<input id="tian" type="text" value="${to_balancevo.number}"/></td>
						</tr>
						<tr>
							<td id="td3">变更原因:</td>
							<td id="td4">&nbsp;&nbsp;<input  type="text" />*</td>
						</tr>
					</tbody>
				</table>
				<div id="bottom-div">
					<a class=" layui-btn layui-bg-green" lay-event="edit">保存</a>
	 				<a class=" layui-btn layui-bg-green" lay-event="edit">取消</a>
				</div>
			</form>
		</div>
	</div>
<script>
	layui.use('form', function(){
		var form = layui.form;
	});
</script>
</body>
</html>