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
#leave_div{width:100px;float:left;}

</style>
</head>
<body>
	<div>
		<div id="div1">	
			<form class="layui-form" >	
				<div id="leave_div">
					<select id="LeaveType" name="LeaveType" lay-verify="" >
						   
					</select>   
				</div>
				
				&nbsp;&nbsp; <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
			</form>
			
		</div>
		
	</div>
	<script type="text/javascript">
	 layui.use('form', function(){
		var form = layui.form;
		

	});
	 
	</script>
</body>
</html>