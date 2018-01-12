<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤统计</title>
<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
<script src="../plugs/layui/layui.js"></script>

<style type="text/css">
  
  .demo-input{padding-left: 10px; height: 35px; min-width: 275px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
	#attendance_top_div{margin-top:20px;margin-left:20px;}
	#attendance_table_div{margin-left:20px;margin-top:10px;}
</style>
	
</head>

<body>
<div>
	<div id="attendance_top_div">
		<form class="layui-form" action="">
		时间  : <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
	  			<input type="text" class="layui-input demo-input" placeholder="请选择日期" id="test1">
			</div> ~
			<div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
	  			<input type="text" class="layui-input demo-input" placeholder="请选择日期" id="test2">
			</div> 	
			 <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
			 <a class=" layui-btn layui-bg-green" lay-event="edit">导出</a>
	      </form>	
	</div>
	<div id="attendance_table_div">
		<table id="demo" lay-filter="test"></table>
	</div>
</div>
<script>
layui.use(['laydate','table','form'], function(){
  var laydate = layui.laydate;
  var $=layui.$
  var table = layui.table;
  var form = layui.form;
  //执行一个laydate实例
   laydate.render({
        elem: '#test1' //指定元素
   });
   laydate.render({
	    elem: '#test2' //指定元素
   });
   $.post('to_kqtj_table',{},function(data){
	   console.info(data);
   })
   
   //第一个实例
   table.render({
     elem: '#demo'
     ,height: 500
     ,url: 'to_attendancesCount' //数据接口
     ,page: true //开启分页
     ,cols: [[ //表头
       {field: 'id', title: 'ID', width:60,  fixed: 'left',align:'center'}
       ,{field: 'name', title: '姓名', width:65,align:'center'}
       ,{field: 'shouldWork', title: '应上班', width:75,align:'center'}
       ,{field: 'actualWord', title: '实上班', width:75,align:'center'} 
       ,{field: 'late', title: '迟到', width:60,align:'center'}
       ,{field: 'leaveEarly', title: '早退', width: 60,align:'center'}
       ,{field: 'absenteeism', title: '旷工', width: 60,align:'center'}
       ,{field: 'leakCard', title: '漏刷卡', width: 80,align:'center'}
       ,{field: 'restdayOvertime', title: '休息日加班', width: 100,align:'center'}
       ,{field: 'holidayOvertime', title: '节假日加班', width: 100,align:'center'}
       ,{field: 'weekdayOvertime', title: '平日加班', width: 90,align:'center'}
       ,{field: 'takeOff', title: '调休', width: 60,align:'center'}
       ,{field: 'yearLeave', title: '年假', width: 60,align:'center'}
       ,{field: 'thingLeave', title: '事假', width: 60,align:'center'}
       ,{field: 'sickLeave', title: '病假', width: 60,align:'center'}
       ,{field: 'marryLeave', title: '婚假', width: 60,align:'center'}
       ,{field: 'maternityLeave', title: '产假', width: 60,align:'center'}
     ]]
   });
 //监听提交
   form.on('submit(formDemo)', function(data){
     layer.msg(JSON.stringify(data.field));
     alert($("#test1").val());
     return false;
   });
 
});
</script>
</body>
</html>