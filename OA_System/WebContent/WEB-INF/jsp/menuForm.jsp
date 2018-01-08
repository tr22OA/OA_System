<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../plugs/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
    <script type="text/javascript" src="../plugs/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../plugs/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
</head>
<body>
<form id="addForm" class="layui-form">
    <div class="layui-container" style="margin-top: 2%">
     	<input id="menuId" type="hidden" name="menuId"/>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单名称</label>
            <div class="layui-input-block">
                <input type="text" name="meuName" required  lay-verify="required" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单连接</label>
            <div class="layui-input-block">
                <input name="menuLink" type="text" class="layui-input" lay-varify="required"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父级菜单</label>
            <div class="layui-input-block layui-form" lay-filter="selFilter">
                <select id="fatherMenu" name="menuFather" lay-verify="required">
                    <option value="0">无</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item" id="uploadImg">
            <label class="layui-form-label">菜单图标</label>
            <select name="img" type="button" class="layui-btn" id="test1">
                    <i class="layui-icon">&#xe67c;</i>上传图片
            </select>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否可见</label>
            <input name="menuIsvisible" class="layui-form-checkbox" type="checkbox">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea  placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <!--表单提交-->
        <input id="submit" type="hidden" class="layui-btn" lay-submit lay-filter="formDemo"/>
        <!--菜单ID-->
       
    </div>
</form>
<!--加载form-->
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        var $=layui.jquery;
        var layer=layui.layer;
        //监听表单提交
        form.on('submit(formDemo)', function(data){
        	alert(1);
        	var url=undefined;
        	//判断表单是新增还是修改
	        if($("#menuId").val()==''){
	        	url='/addMenu';
	        }else{
	       		url='/editMenu';
	        }
        	//用post提交表单
            $.post(url,data.field,function () {
                layer.alert(JSON.stringify(data.field),function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭!/
            	});
            });
        });
       	//表单选项卡动态加载
        $.post("/menuList",{"fatherId":0},function (data) {
        	var select= $("#fatherMenu");
            for(var i=0;i<data.length;i++) {
               select.append('<option value=' + data[i].id + '>' + data[i].text + '</option>');
               var children=data[i].children;
                for(var j=0;j<children.length;j++){
                	 $("#fatherMenu").append('<option value=' + children[j].id + '>' + children[j].text + '</option>');
                }
            }
            form.render('select');
        });
        form.render();
    });
</script>
<!--图片上传-->
</body>
</html>