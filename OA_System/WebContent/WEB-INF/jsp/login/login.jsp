<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../plugs/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/login.css" media="all" />
</head>
<body>
	<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="100%" data-width="100%" height="100%" width="100%">
	    <source src="../../resources/login.mp4" type="video/mp4">
	</video>
	<div class="video_mask"></div>
	<div class="login">
	    <h1>OA办公系统</h1>
	    <form class="layui-form" method="post">
	    	<div class="layui-form-item">
				<input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
		    </div>
		    <div class="layui-form-item">
				<input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		    </div>
		    <div class="layui-form-item form_code">
				<input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
				<div class="code"><img id="code" src="/login?code" width="116" height="36"></div>
		    </div>
			<input type="button" class="layui-btn login_btn" lay-submit lay-filter="login" value="登录">
		</form>
	</div>
	<script type="text/javascript" src="../../plugs/layui/layui.all.js"></script>
	<script type="text/javascript" src="../../js/login.js"></script>
	<script>
		layui.use(['element','form','layer'],function(){
			var $=layui.$;
			var form=layui.form;
			var layer=layui.layer;
			$('#code').click(function(){
				var url='/login?code&data=' + new Date();
				this.src=url;
			});
			form.on("submit(login)",function(data){
				$.post('/login/valiator',data.field,function(res){
					if(res.result){
						location.href="http://localhost:8080/index";
					}else{
						layer.msg(res.msg);
					}
				});
			});
			
		});
	</script>
</body>
</html>