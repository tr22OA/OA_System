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
				<!--顶部菜单-->
				<div class="nav">
					<!--菜单导航-->
					<ul class="layui-nav layui-layout-left"  lay-filter="top">
						<li class="layui-nav-item">
							<a href="../json/nav.json" onclick="return false">首页<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="../json/nav.json" onclick="return false">个人<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="../json/lc.json" onclick="return false">流程<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="../json/rs.json" onclick="return false">人事<span class="layui-badge">0</span></a>
						</li>
						<li class="layui-nav-item">
							<a href="../json/set.json" onclick="return false">系统<span class="layui-badge">0</span></a>
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
						<ul class="layui-nav layui-nav-tree" lay-filter="side">
						</ul>
					</div>
				</div>
			</div>

			<!--主体-->
			<!--选项卡-->
			<div class="layui-body layui-tab layui-tab-card" lay-allowclose="true" lay-filter="menu">
				<ul id="tab" class="layui-tab-title">
					<li title="0" class="layui-this">首页</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe name="myFrame" src="index.jsp" width="100%" height="100%" frameborder="0"></iframe>
					</div>
				</div>
			</div>
			<div class="layui-footer">
				© 老司机七个8团队出品
			</div>
			<script>
				layui.use('element', function() {

					var element = layui.element;
					var form = layui.form;
					var $ = layui.jquery;

				
					element.on('nav(top)',function(ele){
						console.info(ele.find("a").attr("href"));
						loadNav(ele.find("a").attr("href"));
					});

					function loadNav(url) {
						//动态左侧nav
						$.get(url, function(data) {

							//动态设置navLogo的字
							$(".navLogo").html(data.text);
							var children = data.children;
							var navTree = $(".layui-nav-tree");
							navTree.empty();
							var html = '';
							for(var i = 0; i < children.length; i++) {
								var chi = children[i];
								html += '<li id="' + chi.id + '" class="layui-nav-item">';
								html += '<a class="navs" onclick="return false" href="' + chi.url + '">' + chi.text + '</a>'
								if(chi.children!=null){
									if(chi.children.length > 0) {
										html += '<dl class="layui-nav-child">';
										for(var j = 0; j < chi.children.length; j++) {
											html += '<dd  id="' + chi.children[j].id + '"><a onclick="return false" class="navs" target="myFrame"  href="' + chi.children[j].url + '">' + chi.children[j].text + '</a></dd>'
										}
										html += '</dl>';
									}
									html += '</li>';
								}

							}
							navTree.append(html);
							element.render();
						});

					}
				});
			</script>
			<script>
				layui.use('element', function() {
					//获取元素需要使用的对象
					var element = layui.element;
					var layer = layui.layer;
					var form = layui.form;
					var $ = layui.jquery;

					//设置侧边nav的点击事件
					element.on('nav(side)', function(elem) {
						var li = $("#tab li");
						var seletor = "#tab li[lay-id=" + elem[0].id + "]";
						var tab = $(seletor);
						console.info();
						if(tab.length == 0) {
							//新增一个Tab项
							var page = elem.find("a").attr('href');
							element.tabAdd('menu', {
								title: elem[0].textContent,
								content: '<iframe  src="' + page + '" width="100%" height="100%" frameborder="0"></iframe>',
								id: elem[0].id //实际使用一般是规定好的id，这里以时间戳模拟下
							});
							element.tabChange('menu', elem[0].id);
						} else {
							element.tabChange('menu', elem[0].id);
						}
					})

					form.render();
					element.render();
				});
			</script>
	</body>

</html>