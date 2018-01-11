<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<link rel="stylesheet" type="text/css" href="../plugs/fontIconPicker-2.0.0/css/jquery.fonticonpicker.min.css"/>
		<link rel="stylesheet" type="text/css" href="../plugs/fontIconPicker-2.0.0/themes/dark-grey-theme/jquery.fonticonpicker.darkgrey.min.css"/>
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
				<form id="addForm" method="post" action="target.php" class="form-horizontal">
					<fieldset>
						<legend>新增菜单</legend>
						<div class="form-group">
							<label class="col-lg-3 control-label">菜单名称</label>
							<div class="col-lg-5">
								<input type="text" class="form-control" name="menuName" />
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
								<select name="fatherMenu" class="form-control">
									<option value="">无</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">菜单样式</label>
							<div class="col-lg-5">
								<select id="e1_element" name="e1_element">
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
                                    <input type="checkbox" name="" value="french" /> 
                                </label>
                            </div>
						</div>
					</fieldset>
					<div class="form-group">
						<div class="col-lg-9 col-lg-offset-3">
							<input id="submit" type="submit" class="btn btn-primary"/>
						</div>
					</div>
				</form>
			</div>
		</div>

		<script type="text/javascript">
			$(document).ready(function() {
				/*$("#sb").click(function(){
					var index = parent.layer.getFrameIndex(window.name);
                    //先得到当前iframe层的索引
                    parent.layer.close(index); //再执
				});*/
			
			$('#e1_element').fontIconPicker();
			$('#defaultForm').bootstrapValidator({
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
                        			regexp:'^/',
                        			message: '必须以/开头'
                    			}
							}
						}
					}
				});
			$('#defaultForm').submit(function(){
				var bootstrapValidator=$('#defaultForm').data('bootstrapValidator');
				if(bootstrapValidator.isValid()){
					var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index); 
				}
			});
			
			});
		</script>
	</body>

</html>