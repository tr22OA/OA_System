<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
<script src="../plugs/layui/layui.js"></script>
<script src="../plugs/easyui/jquery.min.js"></script>
<style>
	 .balance_span1{color:#333;}
	#balance_form_div{margin-top:20px;margin-left:20px;}
	 #balance_table_div{margin-top:10px;margin-left:20px;}
	
</style>
</head>
<body>
	<div>	
 		<div id="balance_form_div">	
			<form class="layui-form" action="">	
				<span class="balance_span1">年份:</span><div class="layui-inline topdiv" style="margin-left:10px;"> 
			  		<input type="text" class="layui-input demo-input" placeholder="请选择年份"  id="balance_year">
				</div>
				 &nbsp;&nbsp;&nbsp;<button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
				
			</form>
			
		</div>
		<div id="balance_table_div">
			<table id="demo" lay-filter="test" ></table>
		</div>
		
	</div>
<script type="text/javascript">
	
 layui.use(['form','table','laydate'], function(){
		var form = layui.form;
		var laydate = layui.laydate;
		var table = layui.table;
		 var $=layui.$
		//执行一个laydate实例
		laydate.render({
		    elem: '#balance_year' //指定元素
		    ,type: 'year'
		}); 
		 $.post('findBalanceList',{},function(data){
			   console.info(data);
		 })
		 selectDate();//调用获取年的方法 
		//第一次进入页面动态获取当前年份
		  function selectDate(){
			 var mydate = new Date();
			 var year1=mydate.getFullYear();
			 $("#balance_year").val(year1);
		}  
		 table.render({
			  elem: '#demo'
			  ,height: 500
			  ,url: 'findBalanceList' //数据接口
			  ,page: true //开启分页
			  ,cols: [[ //表头
			  	{field: 'deptName', title: '部门名称', width:200,  fixed: 'left',align:'center'}
			  	,{field: 'empName', title: '员工姓名', width:150,align:'center'}
			  	,{field: 'number', title: '加班结余', width:150,align:'center'}
			  	,{field: 'balance_caozuo', title: '操作', width:500,align:'center',toolbar: '#balance_barDemo'}
			 ]]
		});
		 
		//监听工具条
		 table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		   var data = obj.data; //获得当前行数据
		   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		   var tr = obj.tr; //获得当前行 tr 的DOM对象
		  
		   if(layEvent == 'detail'){ //变更日志
			   layui.use('layer', function(){
					layer.open({
	  					type: 2, 
	  					content: 'to_Changelog', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	  					area: ['620px', '320px'],
	  					skin:'layui-layer-molv',
	  					
	  					title: ['变更日志', 'font-size:15px;'],
	  					shade: [0.8, '#393D49'],
	  					anim: 4,
	  					closeBtn: 1,
	  					resize:false,
					});
				});
		   } else if(layEvent == 'linian'){ //历年 
		     
			   layui.use('layer', function(){
					layer.open({
	  					type: 2, 
	  					content: 'to_Overtheyear', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	  					area: ['640px', '320px'],
	  					skin:'layui-layer-molv',
	  					title: ['历年加班', 'font-size:15px;'],
	  					shade: [0.8, '#393D49'],
	  					anim: 4,
	  					closeBtn: 1,
	  					resize:false,
					});
				});
		  } else if(layEvent == 'edit'){ //编辑
		     var balyear= $("#balance_year").val();
		     $.ajax({
					type : "POST",//请求方式
					url : "to_Incoming_Data",//请求URL
					data : {
						deptName : data.deptName,
						empName : data.empName,
						number:data.number,
						year:balyear,
					},//设置参数
					success : function(msg) {//访问成功回调方法						
						//alert(msg);
					}
				});
		   layui.use('layer', function(){
				layer.open({
  					type: 2, 
  					content: 'to_balanceAmend', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
  					area: ['640px', '320px'],
  					skin:'layui-layer-molv',
  					title: ['修改加班', 'font-size:15px;'],
  					shade: [0.8, '#393D49'],
  					anim: 4,
  					closeBtn: 1,
  					resize:false,
				});
			}); 
		     
		     //同步更新缓存对应的值
		     obj.update({
		       username: '123'
		       ,title: 'xxx'
		     });
		   } else if(layEvent== 'notes'){
			   layui.use('layer', function(){
					layer.open({
	  					type: 2, 
	  					content: 'to_Detailrecord', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	  					area: ['640px', '320px'],
	  					skin:'layui-layer-molv',
	  					title: ['明细记录', 'font-size:15px;'],
	  					shade: [0.8, '#393D49'],
	  					anim: 4,
	  					closeBtn: 1,
	  					resize:false,
					});
				});
		    }
		 });
		
	}); 
	
</script>
<script type="text/html" id="balance_barDemo">
  <a class="layui-btn  layui-btn-xs"  lay-event="edit">编辑</a>
  <a class="layui-btn  layui-btn-xs" lay-event="detail">日志</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="notes">记录</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="linian">历年</a>
  
  <!-- 这里同样支持 laytpl 语法，如： -->
  {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  {{#  } }}
</script>
</body>
</html>