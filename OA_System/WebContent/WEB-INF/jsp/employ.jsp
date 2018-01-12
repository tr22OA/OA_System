<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员录用流程</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/themes/icon.css"/>">

<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/plugs/layui/css/layui.css"/>">
<script type="text/javascript">
		
		//提交表单验证
		function submitForm(){
			$('#ff').form('submit',{
				url:'getLeave',
				onSubmit:function(p){
					p.type=1;
					//验证
			    	return $(this).form("validate");
				},
				success:function(data){
			    	alert(data);
			    }
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		//根据时间计算天数
		function onSelect(d) { 
			  var day=0;
	          var sd = $('#startdate').datebox('getValue').replace(/-/g, '/'), ed = $('#enddate').datebox('getValue').replace(/-/g, '/');  
	          if (sd != '' && ed != '') {  
	              if (sd > ed) {  
	               $.messager.alert('警告','结束时间要 大于 开始时间','warning');    
	                  } else {  
	                   var totalMS = new Date(ed).getTime() - new Date(sd).getTime();//得到相差的毫秒数  
	                      day = Math.ceil(totalMS/1000/24/60/60);//得到相差天数，不满一天不算一天将Math.ceil改为Math.floor  
	                      $("#leaDay").numberbox("setValue", day); //所用天数 */  
	                      }  
	            }  
	          }  
</script>
<style>
#big-div {
	padding: 20px;
	width: 1100px;
	height: 600px;
}

#div1 {
	font-size: 25px;
	color: #009688;
	border: 1px solid #009688;
	border-bottom: 0px;
	width: 1107px;
	text-align: center;
	font-weight: bolder;
}

#big-table {
	width: 1110px;
	background-color: white;
}

.td1, .td2 {
	border: 1px solid #009688;
}

td {
	border: 1px solid #009688;
	border-top: 0px;
}

.tr1 {
	height: 35px;
}

.td1, .td3, .td5 {
	width: 200px;
	text-align: center;
	color: #009688;
	font-size: 15px;
	font-weight: bolder;
	background-color: #F2F2F2;
	text-align: right;
}

.td2 {
	width: 400px;
}

.td4 {
	width: 1000px;
}

.td3, .td4 {
	height: 80px;
}

.td6 {
	width: 500px;
	text-align: center;
}

input {
	font-size: 15px;
	color: black;
}

#select {
	width: 195px;
}

.input1 {
	height: 50px;
	width: 1000px;
}
</style>
</head>
<body>
	<div id="big-div">
		<div id="div1">请假申请单</div>
		<form action="test" id="ff">
			<table id="big-table">
				<tbody>
					<tr class="tr1">
						<td class="td1">请假人 :</td>
						<td class="td2"><input class="easyui-textbox" type="text"
							name="leaName" value="何老板"></input></td>
						<td class="td1">申请日期:</td>
						<td class="td2"><input class="easyui-textbox" type="text"
							name="applyDate" value="2017-11-28"></input></td>

					</tr>

					<tr class="tr1">
						<td class="td1">部门:</td>
						<td class="td2"><input class="easyui-textbox" type="text"
							name="dept" value="软件部"></input></td>
						<td class="td1">职位:</td>
						<td class="td2"><input class="easyui-textbox" type="text"
							name="position" value="部门经理"></input></td>
					</tr>

					<tr class="tr1">
						<td class="td1">开始时间:</td>
						<td class="td2"><input class="easyui-datetimebox"
							id="startdate" name="startdate" data-options="onChange:onSelect" /></input>*</td>
						<td class="td1">结束时间:</td>
						<td class="td2"><input class="easyui-datetimebox"
							id="enddate" name="enddate" data-options="onChange:onSelect" />*</td>
					</tr>

					<tr class="tr1">
						<td class="td1">请假类型:</td>
						<td class="td2"><select id="select" name="lea_type"
							class="easyui-combobox">
								<option value="事假">事假</option>
								<option value="病假">病假</option>
								<option value="调休">调休</option>
								<option value="婚假">婚假</option>
								<option value="产假">产假</option>
								<option value="年假">年假</option>
								<option value="其它">其它</option>
						</select></td>
						<td class="td1">请假天数:</td>
						<td class="td2"><input class="easyui-numberbox" id="leaDay"
							name="leaDay" data-options="onChange:onSelect" precision="0"
							min="0" readonly="readonly" /></input>*</td>
					</tr>
				</tbody>
			</table>
			<!--=================================================================================-->
			<table id="big-table">
				<tbody>
					<tr class="tr1">
						<td class="td3">请假事由:</td>
						<td class="td4"><input name="leaContent" class="input1"
							type="text" /></td>
					</tr>

					<tr class="tr1">
						<td class="td3">部门审批:</td>
						<td class="td4"><input name="deptApprove" class="input1"
							type="text" /></td>

					</tr>

					<tr class="tr1">
						<td class="td3">总经理审批:</td>
						<td class="td4"><input name="managerApprove" class="input1"
							type="text" /></td>

					</tr>

					<tr class="tr1">
						<td class="td3">人事归档:</td>
						<td class="td4"><input name="personFile" class="input1"
							type="text" /></td>

					</tr>
				</tbody>
			</table>
			<!--===================================================================-->
			<table id="big-table"
				style="margin-top: 10px; border-top: 1px solid #009688;">
				<tbody>
					<tr class="tr1">
						<td class="td5">下一步任务:</td>
						<td class="td6"><input type="radio" />部门审批</td>
						<td class="td6"><input type="radio" />总经理审批</td>

					</tr>
					<!--=============================================-->
					<tr class="tr1">
						<td class="td5">任务执行人:</td>
						<td class="td6"><input type="text" name="deptApprovePerson" /></td>
						<td class="td6"><input type="text"
							name="positionApprovePerson" /></td>

					</tr>
				</tbody>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">提交</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm()">重置</a>
		</div>
	</div>

</body>
</html>