<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>薪资项目</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/css/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/themes/icon.css"/>">
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>



</head>
 <body class="easyui-layout">
 <script type="text/javascript">
	$(function(){
		/**
			用户管理按钮的单击事件啊
		*/
		$(".nav_btn").linkbutton({onClick:function(){
				var center = $("body").layout("panel", "center");
				var title = $(this).attr("title");
				var url=$(this).attr("id");
				center.panel("refresh",url);
			}
			
		})
		
	});
</script>
 <!-- 布局的上方 -->
<div data-options="region:'north'" style="height: 70px;overflow: hidden;padding: 0 10px;">
  <div class="user-info">
    <span class="item" id="public_change_info"><i class="fa fa-user"></i> ${s_member.realName}</span>
    <span class="item" id="public_change_password"><i class="fa fa-user"></i> 修改密码</span>
    <a class="item" href="/logout"><i class="fa fa-sign-out"></i> 注销</a>
  </div>
  <h1>TR22OA的薪资项目标准</h1>
</div> 
    <div data-options="region:'south',title:'下南'" style="height:80px;"></div>   
     <!--布局的左边  -->
    <div data-options="region:'west',title:'菜单'" style="width:180px;">
    	<div class="easyui-accordion" data-options="fit:true,border: true">
    		<div title="系统管理">
    			<ul>
    				<li><a title="用户管理" id="to_user" class="easyui-linkbutton nav_btn" data-options="fit:true,iconCls:'icon-skiing', plain:true">用户管理</a></li>
    				<li><a title="角色管理" id="to_tree"  class="easyui-linkbutton nav_btn" data-options="fit:true,iconCls:'icon-skiing', plain:true">角色管理</a></li>
    				<li><a title="资源管理" class="easyui-linkbutton" data-options="fit:true,iconCls:'icon-skiing', plain:true">资源管理</a></li>
    			</ul>
    		</div>
    	</div>
    </div>   
	<!--布局中中间  -->
<div data-options="region:'center',href:'to_desktop'">
</div>
</body> 

</html>






