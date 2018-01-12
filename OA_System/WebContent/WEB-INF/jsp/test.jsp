<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/themes/icon.css"/>">

<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
	<script>
        function onSelect(d) {
            var sd = $('#sd').datebox('getValue').replace(/-/g, '/'), ed = $('#ed').datebox('getValue').replace(/-/g, '/');
            console.log(sd,ed)
            if (sd != '' && ed != '') {
                var totalMS = new Date(ed).getTime() - new Date(sd).getTime();//得到相差的毫秒数
                var day = Math.ceil(totalMS / 1000 / 24 / 60 / 60);//得到相差天数，不满一天不算一天将Math.ceil改为Math.floor

                alert(day)
            }
    }
    </script>
    开始日期：<input class="easyui-datetimebox" id="sd" data-options="onChange:onSelect" />
    结束日期：<input class="easyui-datetimebox" id="ed" data-options="onChange:onSelect" />
</body>
</html>