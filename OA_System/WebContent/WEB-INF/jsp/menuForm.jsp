<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<<<<<< HEAD
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
=======
<html>

	<head>
		<meta charset="utf-8" />
		<title>BootstrapValidator demo</title>
		<!--BootStrap样式-->
		<link rel="stylesheet" href="../plugs/bootstrap/css/bootstrap.min.css" />
		<!--validator样式-->
		<link rel="stylesheet" href="../plugs/bootstrapvalidator/dist/css/bootstrapValidator.min.css" />
		<!--图标样式-->
		<link rel="stylesheet" href="//at.alicdn.com/t/font_526922_65mggzgbz92dfgvi.css" />
		<!--fontIconPicker样式-->
		<link rel="stylesheet" type="text/css" href="../plugs/fontIconPicker-2.0.0/css/jquery.fonticonpicker.min.css" />
		<link rel="stylesheet" type="text/css" href="../plugs/fontIconPicker-2.0.0/themes/dark-grey-theme/jquery.fonticonpicker.darkgrey.min.css" />
		<link rel="stylesheet" type="text/css" href="../plugs/fontIconPicker-2.0.0/themes/bootstrap-theme/jquery.fonticonpicker.bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="../plugs/fontIconPicker-2.0.0/themes/inverted-theme/jquery.fonticonpicker.inverted.min.css" />

		<!--jquery-->
		<script type="text/javascript" src="../plugs/jquery2.x/jquery-2.1.3.js"></script>
		<!--Bootstrap-->
		<script type="text/javascript" src="../plugs/bootstrap/js/bootstrap.min.js"></script>
		<!--validtor-->
		<script type="text/javascript" src="../plugs/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
		<!--fontIconPicker-->
		<script type="text/javascript" src="../plugs/fontIconPicker-2.0.0/jquery.fonticonpicker.min.js"></script>
	</head>

	<body>
		<div class="container">
			<div class="col-lg-8 col-lg-offset-2">
				<form id="add_edit_form" action="" method="post" class="form-horizontal">
					<fieldset>
						<legend>新增菜单</legend>
						<div class="form-group">
							<label class="col-lg-3 control-label">菜单名称</label>
							<div class="col-lg-5">
								<input type="text" class="form-control" name="meuName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">菜单连接</label>
							<div class="col-lg-5">
								<input type="text" class="form-control" name="menuLink" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">父级菜单</label>
							<div class="col-lg-5">
								<select name="menuFather" class="form-control">
									<option value="">无</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">菜单样式</label>
							<div class="col-lg-5">
								<select id="e1_element" name="menuImg">
									<option value="">No icon</option>
									<option>iconfont icon-renwu</option>
									<option>iconfont icon-add</option>
									<option>iconfont icon-tubiao16</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">是否隐藏</label>
							<div class="col-lg-3 checkbox">
								<label>
                                    <input type="checkbox" name="menuIsvisible" value="french" /> 
                                </label>
							</div>
						</div>
					</fieldset>
					<div class="form-group">
						<div class="col-lg-9 col-lg-offset-3">
							<input id="sb" type="submit" class="btn btn-primary" />
						</div>
					</div>
					<input name="menuId" type="hidden"/>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="../js/a.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#e1_element').fontIconPicker();
				$('#add_edit_form').bootstrapValidator({
					message: '这个值不能验证',
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					fields: {
						menuName: {
							validators: {
								notEmpty: {
									message: '菜单名称不能为空'
								}
							}
						},
						menuLink: {
							validators: {
								notEmpty: {
									message: '菜单连接不能为空'
								},
								regexp: {
									regexp: '^/',
									message: '必须以/开头'
								}
							}
						}
					}
				});
				$("#add_edit_form").submit(function() {
					var form=$(this);
					console.info(form.seriallizeObject());
					var bootstrapValidator = $('#add_edit_form').data('bootstrapValidator');
					if(bootstrapValidator.isValid()) {
							var index = parent.layer.getFrameIndex(window.name);
							var url;
							console.info($(form).find("input[name=menuId]").val());
							if($(form).find("input[name=menuId]").val()){
								form.attr("action","/editMenu");
							}else{
								form.attr("action","/addMenu");
							}
					}

				});
			});
		</script>
	</body>

>>>>>>> zmy
</html>