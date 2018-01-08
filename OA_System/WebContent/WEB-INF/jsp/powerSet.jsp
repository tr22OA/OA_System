<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>系统设置</title>
		<link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="../plugs/easyui/demo/demo.css">
		<link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="//at.alicdn.com/t/font_526922_2mm2tte3pgj2x1or.css" />
		<script type="text/javascript" src="../plugs/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="../plugs/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
		<style>
			.childrenBody {
				margin: 10px 10px 0;
			}
			
			.news_search {
				padding: 10px 10px;
			}
			
			.grid-demo-bg1 {
				padding: 10px;
				line-height: 50px;
				text-align: center;
			}
			
			.grid-demo {
				padding: 10px;
				line-height: 50px;
				text-align: center;
			}
		</style>
	</head>

	<body class="childrenBody">

		<div class="layui-row">
			<div class="layui-col-xs2">
				<div><button id="addMenu" class="layui-btn layui-btn-lg" style="margin-left: 20px;"><i class="iconfont icon-add"></i>添加菜单</button></div>
				<ul class="easyui-tree" data-options="url:'',method:'get',animate:true,lines:true"></ul>
			</div>
			<table class="layui-hide layui-col-xs10" id="table_menu" lay-filter="menu"></table>
		</div>
		<script type="text/html" id="bar">
			<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
		<script type="text/html" id="imgUrl">
			<img src="../resources/admin.JPG" />
		</script>
		<script>
		//定义变量
			var table = layui.table;
			var $ = layui.$;
			var layer = layui.layer;
			var form=layui.form;
			//初始化表头结构
			table.render({
				elem: '#table_menu',
				url: 'table',
				cols: [
					[{
						field: 'menuId',
						title: 'ID',
						width: 80,
						sort: true
					}, {
						field: 'meuName',
						title: '菜单名称',
						width: 80
					}, {
						field: 'menuLink',
						title: '菜单路径',
						width: 80
					}, {
						field: 'menuFather',
						title: '父级菜单',
						width: 80
					}, {
						field: 'menuImg',
						title: '菜单图片',
						width: 80,
						templet: '#imgUrl'
					}, {
						field: 'menuIsvisable',
						title: '是否可见',
						width: 80,
						templet: '#checkboxTpl',
						unresize: true
					}, {
						title: "操作",
						fixed: 'right',
						width: 178,
						align: 'center',
						toolbar: '#bar'
					}]
				],
				id: 'testReload',
				page: true,
				height: "full"
			});
			
			//添加的点击事件
			$("#addMenu").click(function() {
				layer.open({
					type: 2,
					content: "/form",
					area: ['450px', '90%'],
					btn:['确定', '取消'],
					yes: function(index) {
						var form = layer.getChildFrame('#addForm', index);
						var submit = form.find('#submit');
						submit.click();
					}
				});

			});
			
			//表格内的工具条的点击事件
			table.on('tool(menu)',function(obj){
				var data=obj.data;
				var event=obj.event;
				switch(event){
					case 'edit':
					edit(data);
					break;
					case 'del':
					del(obj);
					break;
				}
				
				//编辑点击事件
				function edit(data){
					layer.open({
					type: 2,
					content: "/form",
					area: ['450px', '90%'],
					btn:['确定', '取消'],
					before:function(){
					},
					success:function(layero,index){
						alert("success");
						var body = layer.getChildFrame('body', index);
						console.info(data);
						var menuId=body.find('input[name=menuId]');
						menuId.val(data.menuId);
						var menuName=body.find('input[name=meuName]');
						menuName.val(data.meuName);
						var menuLink=body.find('input[name=menuLink]');
						menuLink.val(data.menuLink);
						var ifrme=body.context.getElementsByTagName('iframe');
						var doc=ifrme[0].contentDocument;
						var dds=doc.getElementsByTagName('dd');
						for(var i=0;i<dds.length;i++){
							if(dds[i].getAttribute('lay-value')==data.menuFather){
								dds[i].click();return;
							}
						}
						var munuCkeckBox=body.find('div.layui-form-checkbox');
						if(data.menuIsvisable=='yes'){
							munuCkeckBox.click();
						}
						var img=body.find('#uploadImg');
						if(data.menuImg!=undefined){
							img.append('<img src="../resources/'+data.menuImg+'" style="height:30px;weight:30px">');
						}
					},
					yes: function(index) {
						alert("yes");
						var form = layer.getChildFrame('#addForm', index);
						var submit = form.find('#submit');
						submit.click();
					}
				});

				}
				
				//删除点击事件
				function del(obj){
					var index=layer.load();
					$.post('/delMenu',obj.data,function(){
						layer.close(index);
						obj.del();
					})
				}
				//重新渲染表单
				form.render();
			});
			
		</script>
	</body>

</html>