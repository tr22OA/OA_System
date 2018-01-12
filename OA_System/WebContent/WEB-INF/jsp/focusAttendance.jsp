<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集中考勤</title>
<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
<script src="../plugs/layui/layui.js"></script>
<script src="../plugs/easyui/jquery.min.js"></script>
<style type="text/css">
 body{padding: 15px;}
  .demo-input{padding-left: 10px; height: 38px;  line-height: 38px; }
  .topdiv{float:left;min-width: 275px;}
  #button1{margin-left:20px;}
 select{width:275px;height:38px;border-radius: 2px;border-color:#D2D2D2;} 
 td{width:40.1px;text-align:center;height:30px;background-color:#F2F2F2;border:1px solid #e6e6e6;color:#666;}
 #divtable{margin-top:10px;}
.tdd{color:#009688;font-weight:bolder;font-size:15px;}

</style>
</head>
<body>
	<div>
		<div id="div1">	
			<form class="layui-form" action="">	
				<div class="topdiv">
					<select id="dept" name="dept" lay-verify="" >
						   
					</select>   
				</div>
				
				 <div class="layui-inline topdiv" style="margin-left:10px;"> 
			  		<input type="text" class="layui-input demo-input" placeholder="请选择日期"  id="test1">
				</div>
				 &nbsp;&nbsp;&nbsp;<button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
			</form>
			
		</div>
		<div id="divtable">
			<table id="table1">
				<tr id="tr1">
					<td id="name">姓名</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
	
	 layui.use(['form','laydate'], function(){
		var form = layui.form;
		var laydate = layui.laydate;
		var html ="<option value='all'>请选择部门</option>";
		
		//执行一个laydate实例
		laydate.render({
		    elem: '#test1' //指定元素
		    ,type: 'month'
		}); 
		selectDate(); 
		renderForm();
		appendOption();
		sxTable();
		
		function sxTable(){
			var arr = ($("#test1").val()).split('-');
			var a=arr[0];
			var b=arr[1];
			createMonthDay(a,b);
		}
		
		function sxTable1(g){
			var arr = g.split('-');
			var c=arr[0];
			var d=arr[1];
			createMonthDay(c,d);
		}
		function renderForm(){
			layui.use('form', function(){
				 var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
				 form.render();
			});
		}
		
		//动态加载部门option 
		function appendOption(){
			$.ajax({
				type : "POST",//请求方式
				url : "to_Select",//请求URL
				success : function(msg) {//访问成功回调方法						
					 for (var i = 0; i < msg.length; i++) {
						html += "<option class='option1' value='"+msg[i].deptId+"'>"
								+ msg[i].deptName
								+ "</option>";
					} 
					$("#dept").html(html);
					 renderForm();
				}
			});
		}
		//第一次进入页面动态获取当前日期 
		 function selectDate(){
			 var mydate = new Date();
			 var year1=mydate.getFullYear();
			 var month=mydate.getMonth()+1;
			 $("#test1").val(year1+"-"+month);
			 var da= $("#test1").val(); 
		} 
		//动态获取选中年月的日期
		function createMonthDay(year,month) {
			var week =new Date(year, month-1,1).getDay();//拿到这个月1号是星期几  
		    var date1 = 32 - new Date(year, month-1, 32).getDate();//拿到这个月有多少天  
			/* alert(week);
		    alert(date1); */
		    var html;
             if(week==0||week==6){
            	 $("#tr1").append("<td class='tdd t' >"+1+"</td>");
             }else{
            	 $("#tr1").append("<td class='t'>"+1+"</td>");
             }
			 for(var i=2;i<=date1;i++){
				 
				 var x=0;
				 var y=0;
				 for(var j=1;j<=5;j++){
					 if(i==(6-week+1)+j*7){
						x=1;
						break;
					 }else{
						 x=0;
					 }
					 if(i==(7-week+1)+j*7){
							y=1;
							break;
						 }else{
							 y=0;
						 }
				 }
				 if(x==1||y==1||i==6-week+1||i==7-week+1){
					 $("#tr1").append("<td class='tdd t' >"+i+"</td>");
				 }else{
					 $("#tr1").append("<td class='t'>"+i+"</td>"); 
				 }
			 }
		};
		
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    var q=$("#test1").val();
		   	var h=$("#dept").val();
		   //	
		   $(".t").remove();
		   sxTable1(q);
		   
		   	//sxTable1(g);
		     /*  $.ajax({
				type : "POST",//请求方式
				url : "to_form",//请求URL
				data : {
					dept : h,
					time : g,
				},//设置参数
				success : function(msg) {//访问成功回调方法						
					alert(msg);
					
					
				}
			});  */
		    return false;
		  }); 
	});
	 
	</script>
</body>
</html>