<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班类型—新增排班类型</title>
<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css" />
<script src="../plugs/layui/layui.js"></script>
<style>
	body{background-color:#F1F6FF;}
	 #xgjb-bigdiv{border:0px solid red;padding: 10px;}
	
	td{border:1px solid #e6e6e6;}
	#add_name,#add_notes,#add_week{width:100px;text-align:right;color:#666666;font-weight:bold;}
	#add_week{height:60px;}
	#add_notes_td{height:60px;}
	 #add_notes_td input{width:550px;} 
	#bottom-div{margin-top:20px;text-align:center;} 
	.checkboxtd{width:650px;}
	#div_input{margin-left:9px;}
	#add_name_div,#add_notes_div{margin-left:10px;width:200px;}
	#add_name_div{margin-top:13px;}
</style>
</head>
<body>
	
	<div id="xgjb-bigdiv">
		<div >
			<form class="layui-form" action="to_form">
				<table id="xgjb-table">
					<tbody>
						<tr>
							<td id="add_name">名称:</td>
							<td >
								<div class="layui-input-block layui-form-item" id="add_name_div">
      								<input type="text" name="title" required  lay-verify="required" placeholder="请输入排班类型名称" autocomplete="off" class="layui-input">
      							</div>
      						</td>
						</tr>
						<tr>
							<td id="add_week">工作日:</td>
							<td class="checkboxtd">
								<div id="div_input" >
							        <input type="checkbox" name="checkweek1" title="星期一" lay-skin="primary" >
									<input type="checkbox" name="checkweek2" title="星期二" lay-skin="primary"> 
									<input type="checkbox" name="checkweek3" title="星期三" lay-skin="primary"> 
									<input type="checkbox" name="checkweek4" title="星期四" lay-skin="primary"> 
									<input type="checkbox" name="checkweek5" title="星期五" lay-skin="primary"> 
									<input type="checkbox" name="checkweek6" title="星期六" lay-skin="primary"> 
									<input type="checkbox" name="checkweek7" title="星期日" lay-skin="primary"> 
							    </div>
							</td>
						</tr>
						<tr>
							<td id="add_notes">备注:</td>
							<td id="add_notes_td">
								<div class="layui-input-block" id="add_notes_div">
	      							<input type="text" name="aa" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	      						</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div id="bottom-div">
					  <button class="layui-btn" lay-submit  lay-filter="formDemo">保存</button>
					<button class="layui-btn" id="add_cancel">取消</button>
	 				
				</div>
			</form>
			
		</div>
	</div>
<script>
layui.use('form', function(){
	var form = layui.form;
	 //监听提交
	   form.on('submit(formDemo)', function(data){
	     layer.msg(JSON.stringify(data.field));
	    	
	     return false;
	   });
});
</script>
</body>
</html>