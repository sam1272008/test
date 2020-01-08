<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'login.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
    </script>
  </head>
  
  <body>
  	<font size="20px" color="red">${error }</font>
    <form action="login" method="post">
  		username:<input name="username" ><br><br>
  		password:<input name="password" ><br><br>
  		<input type="submit" value="login" ><br><br>
  		
  	</form>
  </body>
</html>
