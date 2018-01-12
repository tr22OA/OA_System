<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考核评分</title>
<link rel="stylesheet" href="../plugs/layui/css/layui.css">
<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
<script src="../plugs/layui/layui.js"></script>

<style type="text/css">
.layui-input {
	width: 160px;
}

.layui-inline {
	margin-top: 20px;
	text-align: center;
}

.kh-one {
	margin-top: 10px;
}
</style>

<script type="text/javascript">
	layui.use([ 'laydate', 'form', 'table' ], function() {
		var laydate = layui.laydate, form = layui.form;
		//执行一个laydate实例
		laydate.render({
			elem : '#kh-year'
			,type : 'year'
		});
		
		//创建数据表格
		var table=layui.table;
		table.render({
			elem:'#khScoreTab'
			,height:315
			,width:990
			,url:'find_kh_score_list'
			,page:true
			,cols:[[
			        {field:'khName',title:'考核名称',width:150,align: 'center'},
			        {field:'khStep',title:'考核步骤',width:150,align: 'center'},
			        {field:'khPeople',title:'被考核人',width:150,align: 'center'},
			        {field:'a',title:'评分开始',width:180,align: 'center'},
			        {field:'b',title:'评分结束',width:180,align: 'center'},
			        {title:'操作',width:180,align: 'center',toolbar: '#KhScoreBar'}
			      ]]
		});
	});
</script>
<script type="text/html" id="KhScoreBar">
	<a class="layui-btn-xs" lay-event="detail">查看</a>
</script>
</head>

<body>
	<form class="layui-form" action="#">
		<div class="layui-inline">
			<label>考核年份：</label>
			<div class="layui-input-inline">
				<input type="text" id="kh-year" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label>考核类型：</label>
			<div class="layui-input-inline">
				<select class="layui-select" name="khScore-select"
					lay-filter="khScore-select">
					<option value="">选择类型</option>
					<option value="yuedu">月度考核</option>
					<option value="jidu">季度考核</option>
					<option value="niandu">年度考核</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label>考核状态：</label>
			<div class="layui-input-inline">
				<select id="kh-state" class="layui-select">
					<option value="daipingfen">待评分</option>
					<option value="yipingfen">已评分</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<div class="layui-input-inline">
				<button class="layui-btn" style="margin-left: 10px">查询</button>
			</div>
		</div>
		<div class="kh-one">
			<label>考核部门：</label>
			<div class="layui-input-inline">
				<select id="kh-dept" class="layui-select">
					<option value="">选择</option>
					<option value="BossDept">公司总部</option>
					<option value="managerDept">总经办</option>
					<option value="peopleDept">人事部</option>
					<option value="caiwuDept">财务部</option>
					<option value="jishuDept">技术部</option>
				</select>
			</div>
			<label>考核步骤：</label>
			<div class="layui-input-inline">
				<select id="kh-step" class="layui-select">
					<option value="">选择</option>
					<option value="deptManager">部门经理评</option>
				</select>
			</div>

			<div class="layui-input-inline">
				<button class="layui-btn" style="margin-left: 10px">批量评分</button>
			</div>
		</div>
	</form>
	
	<table id="khScoreTab" lay-filter="khScoreTabFilter"></table>
</body>
</html>