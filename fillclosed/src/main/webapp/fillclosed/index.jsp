<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>测试</title>
  <script type="text/javascript" src="../jquery-1.6.2.min.js"></script>
  <script type="text/javascript">
  	var json = "[{\"userId\":1,\"score\":100,\"usetime\":\"2015-01-01 00:11:11\"},{\"userId\":2,\"score\":89,\"usetime\":1671100000}]";
  	var url = "/user/savescore/";
  	$.ajax({
  		 type: "POST",
  		 url: url,
  		 data: "scoreStr="+json,
  		 success: function(msg){//成功时执行函数
  		    alert( "回调成功！"+msg );
  		    }
  		 });
  </script>
  </head>
  
  <body>
  </body>
</html>