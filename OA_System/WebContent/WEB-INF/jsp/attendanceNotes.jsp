<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤记录</title>
<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
<script src="../plugs/layui/layui.js"></script>
<style type="text/css">
  body{padding: 20px;}
  .demo-input{padding-left: 10px; height: 35px; min-width: 275px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
	
</style>
</head>
<body>
	<div>
		时间  : <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  			<input type="text" class="layui-input demo-input" placeholder="请选择日期" id="test1">
		</div> ~
		<div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  			<input type="text" class="layui-input demo-input" placeholder="请选择日期" id="test2">
		</div> 
	
		<a class=" layui-btn layui-bg-green" lay-event="edit">查询</a>
 		<a class=" layui-btn layui-bg-green" lay-event="edit">导入</a>
 		<a class=" layui-btn layui-bg-green" lay-event="edit">添加</a>
		
	</div>
	<div>
		<table id="demo" lay-filter="test"></table>
	</div>
	<script>
layui.use(['laydate','table'], function(){
  var laydate = layui.laydate;
  var table = layui.table;
  //执行一个laydate实例
   laydate.render({
        elem: '#test1' //指定元素
   });
   laydate.render({
	    elem: '#test2' //指定元素
   });
   
   //第一个实例
   table.render({
     elem: '#demo'
     ,height: 500
     ,url: 'toNotes' //数据接口
     ,page: true //开启分页
     ,cols: [[ //表头
       {field: 'date', title: '日期', width:300,  fixed: 'left',unresize:'true',align:'center'}
       ,{field: 'week', title: '星期', width: 300,unresize:'true',align:'center'}
       ,{field: 'gotowork', title: '上班', width:300,unresize:'true',align:'center'}
       ,{field: 'gooffwork', title: '下班', width:300,unresize:'true',align:'center'}
      
     ]]
   });
});
</script>
</body>
</html>