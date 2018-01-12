<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="../plugs/easyui/demo/demo.css">
		<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="//at.alicdn.com/t/font_526922_2mm2tte3pgj2x1or.css" />
		<script type="text/javascript" src="../plugs/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="../plugs/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
</head>
<body class="childrenBody">
	<form class="layui-form">
		<div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label">部门：</label>
		      <div class="layui-input-inline">
		       	<select name="dept">
		        <option value=""></option>
		       <c:forEach var = "x" items = "${dept}">
		       		<option value = "${x.deptId }">${x.deptName}</option>
		       </c:forEach>
		      </select>
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">姓名:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="name"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">类型:</label>
		      <div class="layui-input-inline">
			       <select name="type">
			        <option value=""></option>
			        <option value="0">临时工</option>
			        <option value="1">合同工</option>
			        <option value="2">正式工</option>
			      </select>
		      </div>
		    </div>
		    <div class="layui-inline">
		    	<label class="layui-form-label">状态:</label>
		    	 <div class="layui-input-inline">
			       <select name="state">
			        <option value=""></option>
			        <option value="1">在职</option>
			        <option value="0">离职</option>
			      </select>
		      </div>
		    </div>
		    <div class="layui-inline">
			    <label class="layui-form-label">入职日期:</label>
			    <div class="layui-input-inline" style="width: 80px;">
			      <input type="text" name="begindate" id="begindate" autocomplete="off" class="layui-input">
			    </div>
			    <div class="layui-form-mid">~</div>
			    <div class="layui-input-inline" style="width: 80px;">
			      <input type="text" name="enddate" id="enddate" autocomplete="off" class="layui-input" lay-verify="entryd">
			    </div>
			  </div>
			  
			  <div class="layui-inline">
     			 <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
      		</div>
		  </div>

		 
    		

		 </form>

		 <table id="table_emp" lay-filter="emp"></table>
		<script type="text/html" id="bar">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</script>
		
		<script>
		layui.use(['table','form','jquery','laydate'],function(){
			var table = layui.table;
			var $ = layui.$;
			var layer = layui.layer;
			var form=layui.form;
			var laydate = layui.laydate;

			laydate.render({
    			elem: '#begindate' //指定元素
  			});

  			laydate.render({
    			elem: '#enddate' //指定元素
  			});
			
  			// 初始化表头结构
			var tableIns = table.render({
				elem: '#table_emp',
				url: '/queryEmp',
				cols: [
					[{
						field: 'deptName',
						title: '部门',
						
					}, {
						field: 'empName',
						title: '姓名',
						
					}, {
						field: 'empId',
						title: '工号',
						
					}, {
						field: 'empSex',
						title: '性别',
						
					}, {
						field: 'empBirth',
						title: '出生日期',
						
					}, {
						field: 'empType',
						title: '类型',
						
					}, {
						field:'empWorkstate',
						title: "在职状态",
						
					},{
						field: 'jobName',
						title: "职位",
						
					},{
						field: 'jobLevel',
						title: "职位级别",
						
					},{
						field: 'empEntrydate',
						title: "入职日期",
						
					},{
						fixed: 'right', 
						title: "操作",
						width:150, 
						align:'center', 
						toolbar: '#bar'
					}

					]
				],
				id: 'testReload',
				page: true,
				limits:[5,10,15,20],
				height: "full"
			});
			
			form.verify({
				entryd:function(value,item){
					if($("#begindate").val() != null && value < $("#begindate").val()){
						return "结束日期大于开始日期";
					}
				}
			});
			
  			/*查询*/
  			form.on('submit(formDemo)',function(data){
  				var a = data.field;
  				tableIns.reload({
  					page:{curr:1},
  					 where:{
  						dept:a.dept,
  						name:a.name,
  						type:a.type,
  						state:a.state,
  						begindate:a.begindate,
  						enddate:a.enddate
  					}  
  				});
  				return false;
  			});
			form.render();
				
		});
		
		</script>
		</body>
		
</html>