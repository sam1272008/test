<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript">
  function myajax2(){
    	var obj = {ename:"SMITH"};
    	$.ajax({
    		type:"post",
    		dataType:"json",
    		url:"emp?type=5",
    		data: obj,
    		success:function(msg){
    			alert(msg);
    			//alert( eval ("("+msg+")"));
    		}
    	
    	});
    }
 </script>
  </head>
  
  <body>
    <form action="emp?type=5" method="post">
    	请输入要查询的员工的ename:<input type="text" name="ename"><br><br>
    	
    	<input type="button" value="查询" onclick="myajax2()">
    
    </form>
    <br><br>
    结果是:<br>
    ${dd }
  </body>
</html>
