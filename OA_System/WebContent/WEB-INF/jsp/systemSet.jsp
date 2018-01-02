
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>OA办公系统</title>
		<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_526922_1skvwtwj0sikvs4i.css" />
		<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
		<style>
			.layui-tab {
				margin: 0px 0;
			}
			
			.navLogo {
				padding: 10px 40px 10px 65px;
				font-size: 20px;
				font-style: italic;
				background-color: grey;
			}
		</style>
	</head>

	<body class="layui-layout-body">
		<div class="layui-layout-admin layui-layout">
			<!--顶部-->
			<div class="layui-header">
				<!--logo-->
				<a href="#" class="layui-hide-xs">
					<div class="layui-logo">
						OA办公系统
					</div>
				</a>
				<!--左侧菜单收缩按钮-->
				<a href="#" class="layui-hide-xs">
					<div class="menu">shousuo</div>
				</a>
				<!--顶部菜单-->
				<div class="nav">
					<!--菜单导航-->
					<ul class="layui-nav layui-layout-left">
						<li class="layui-nav-item">
							<a href="#">首页<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="#">个人<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="#">流程<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="#">人事<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="#">系统<span class="layui-badge">0</span></a>
						</li>
					</ul>
					<!--退出和个人信息菜单-->
					<ul class="layui-nav layui-layout-right">
						<li class="layui-nav-item">
							<a href="#">
								<img src="../resources/admin.JPG" class="layui-nav-img" /> 我
								<span class="layui-nav-more"></span>
								<dl class="layui-nav-child layui-anim layui-anim-upbit">
									<dd>
										<a href="#">基本资料</a>
									</dd>
									<dd>
										<a href="#">修改密码</a>
									</dd>
								</dl>
							</a>
						</li>
						<li class="layui-nav-item">
							<a href="#"><i class="iconfont icon-tubiao16"></i>退出</a>
						</li>
					</ul>
				</div>
				<div class="layui-side layui-bg-black">
					<div class="layui-side-scroll">
						<div class="navLogo">
							个人
						</div>
						<!--侧边菜单-->
						<ul class="layui-nav layui-nav-tree" lay-filter="test">
							<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
							<li class="layui-nav-item layui-nav-itemed">
								<a href="javascript:;">默认展开</a>
								<dl class="layui-nav-child">
									<dd>
										<a class="navs" href="javascript:;" title="1">选项1</a>
									</dd>
									<dd>
										<a class="navs" href="javascript:;" title="2">选项2</a>
									</dd>
									<dd>
										<a class="navs" href="javascript:;" title="3">跳转</a>
									</dd>
								</dl>
							</li>
							<li class="layui-nav-item">
								<a href="javascript:;">解决方案</a>
								<dl class="layui-nav-child">
									<dd>
										<a class="navs" href="javascript:;" title="4">移动模块</a>
									</dd>
									<dd>
										<a class="navs" href="javascript:;" title="5">后台模版</a>
									</dd>
									<dd>
										<a class="navs" href="javascript:;" title="6">电商平台</a>
									</dd>
								</dl>
							</li>
							<li class="layui-nav-item">
								<a href="">产品</a>
							</li>
							<li class="layui-nav-item">
								<a href="">大数据</a>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--主体-->
			<!--选项卡-->
			<div class="layui-body layui-tab layui-tab-card" lay-allowclose="true" lay-filter="test">
				<ul id="tab" class="layui-tab-title">
					<li title="0" class="layui-this">首页</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe src="index.jsp" width="100%" height="100%" frameborder="0"></iframe>
					</div>
				</div>
			</div>
			<div class="layui-footer">
				© 老司机七个8团队出品
			</div>
			<script>
				layui.use('element', function(){
					//获取元素需要使用的对象
					var element = layui.element;
					var form = layui.form;
					var $ = layui.jquery;
					
					
					//动态左侧nav
					$.get("../json//nav.json",function(data){
						//动态设置navLogo的字
						$(".navLogo").html(data.text);
						var children=data.children;
						var navTree=$(".layui-nav-tree");
						navTree.empty();
						var html='';
						for(var i=0;i<children.length;i++){					 
						  	var chi=children[i];
						  	html+='<li class="layui-nav-item">';
						  	html+='<a class="navs" href="javascript:;" title="'+chi.url+'">'+chi.text+'</a>'
						  	if(chi.children.length>0){
						  		html+='<dl class="layui-nav-child">';
						  		for(var j=0;j<chi.children.length;j++){
						  			html+='<dd><a class="navs" href="javascript:;" title="'+chi.children[j].url+'">'+chi.children[j].text+'</a></dd>'
						  		}
						  		html+='</dl>';
						  	}
						  	html+='</li>';
						  	
						}
						navTree.append(html);
						element.render();
					});
					//动态tab
					//找到TAb
					var tab = $("#tab");
					//找到tab下的内容元素
					var tabContent = $("#tabContent");

					//找到所有导航栏连接元素
					var navs = $(".navs");
					console.info(navs);
					//遍历导航栏，为导航栏增加点击事件
					for(var i = 0; i < navs.length; i++) {
						//增加点击事件
						$(navs[i]).click(function() {
							var nav = $(this);
							alert(nav);
							
							//声明一个boolean变量，判断TAB上是否有相同
							var flag = true;
							//寻找所有tab
							var lis = tab.find("li");
							//遍历tabs
							for(var i = 0; i < lis.length; i++) {
								//获取每个tab
								var that = $(lis[i]);
								//判断tab最大为20
								if(lis.length < 20) {
									//判断tab是否已存在，如果存在则跳转到该页面
									if(that[0].title == nav[0].title) {
										//移除之前高亮显示的tab
										$(".layui-this").removeClass("layui-this");
										//让现在存在tab显示
										that.addClass("layui-this");

										//将tab内容替换，将以前的内容隐藏
										$(".layui-show").removeClass("layui-show");
										//找到要显示的tab内容
										var tabId = "#" + that[0].title;
										//显示tab内容
										$(tabId).addClass("layui-show")
										flag = false;
										break;
									}
								}
							}
							//判断如果不存在，就添加一个tab，然后跳转到那个tab
							if(flag) {
								//移除以前显示的tab样式
								$(".layui-this").removeClass("layui-this");
								//追加一个tab
								tab.append('<li title="' + nav[0].title + '" class="layui-this">' + nav.html() + '</li>');
								//隐藏现在的tab内容
								$(".layui-show").removeClass("layui-show");
								//增加一个tab内容
								$(".layui-tab-content").append('<div id="' + nav[0].title + '" class="layui-tab-item layui-show">' + nav[0].title + '</div>')
								element.render();
							}
						});
					}
					form.render();
					element.render();
				});
			</script>
	</body>

</html>