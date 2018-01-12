<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title>BootstrapValidator demo</title>

		<link rel="stylesheet" href="../plugs/bootstrapvalidator/vendor/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="../plugs/bootstrapvalidator/dist/css/bootstrapValidator.css" />

		<script type="text/javascript" src="../plugs/bootstrapvalidator/vendor/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="../plugs/bootstrapvalidator/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../plugs/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
	</head>

	<body>
		<div class="container">
			<div class="col-lg-8 col-lg-offset-2">
				<form id="defaultForm" method="post" action="target.php" class="form-horizontal">
					<fieldset>
						<legend>Not Empty validator</legend>

						<div class="form-group">
							<label class="col-lg-3 control-label">Username</label>
							<div class="col-lg-5">
								<input type="text" class="form-control" name="username" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-lg-3 control-label">Country</label>
							<div class="col-lg-5">
								<select class="form-control" name="country">
									<option value="">-- Select a country --</option>
									<option value="fr">France</option>
									<option value="de">Germany</option>
									<option value="it">Italy</option>
									<option value="jp">Japan</option>
									<option value="ru">Russia</option>
									<option value="gb">United Kingdom</option>
									<option value="us">United State</option>
								</select>
							</div>
						</div>
					</fieldset>
					<div class="form-group">
						<div class="col-lg-9 col-lg-offset-3">
							<input id="sb" type="submit" class="btn btn-primary"/>
						</div>
					</div>
				</form>
			</div>
		</div>

		<script type="text/javascript">
			$(document).ready(function() {
				$("#sb").click(function(){
					var index = parent.layer.getFrameIndex(window.name);
                    //先得到当前iframe层的索引
                    parent.layer.close(index); //再执
				});
			
			
				$('#defaultForm').bootstrapValidator({
					message: 'This value is not valid',
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					fields: {
						username: {
							message: 'The username is not valid',
							validators: {
								notEmpty: {
									message: 'The username is required and can\'t be empty'
								},
								stringLength: {
									min: 6,
									max: 30,
									message: 'The username must be more than 6 and less than 30 characters long'
								},
								regexp: {
									regexp: /^[a-zA-Z0-9_\.]+$/,
									message: 'The username can only consist of alphabetical, number, dot and underscore'
								}
							}
						},
						country: {
							validators: {
								notEmpty: {
									message: 'The country is required and can\'t be empty'
								}
							}
						},
						acceptTerms: {
							validators: {
								notEmpty: {
									message: 'You have to accept the terms and policies'
								}
							}
						},
						email: {
							validators: {
								notEmpty: {
									message: 'The email address is required and can\'t be empty'
								},
								emailAddress: {
									message: 'The input is not a valid email address'
								}
							}
						},
						website: {
							validators: {
								uri: {
									allowLocal: true,
									message: 'The input is not a valid URL'
								}
							}
						},
						phoneNumberUS: {
							validators: {
								phone: {
									message: 'The input is not a valid US phone number'
								}
							}
						},
						phoneNumberUK: {
							validators: {
								phone: {
									message: 'The input is not a valid UK phone number',
									country: 'GB'
								}
							}
						},
						color: {
							validators: {
								color: {
									type: ['hex', 'rgb', 'hsl', 'keyword'],
									message: 'Must be a valid %s color'
								}
							}
						},
						colorAll: {
							validators: {
								color: {}
							}
						},
						zipCode: {
							validators: {
								zipCode: {
									country: 'US',
									message: 'The input is not a valid US zip code'
								}
							}
						},
						password: {
							validators: {
								notEmpty: {
									message: 'The password is required and can\'t be empty'
								},
								identical: {
									field: 'confirmPassword',
									message: 'The password and its confirm are not the same'
								}
							}
						},
						confirmPassword: {
							validators: {
								notEmpty: {
									message: 'The confirm password is required and can\'t be empty'
								},
								identical: {
									field: 'password',
									message: 'The password and its confirm are not the same'
								}
							}
						},
						ages: {
							validators: {
								lessThan: {
									value: 100,
									inclusive: true,
									message: 'The ages has to be less than 100'
								},
								greaterThan: {
									value: 10,
									inclusive: false,
									message: 'The ages has to be greater than or equals to 10'
								}
							}
						}
					}
				});
			});
		</script>
	</body>

</html>