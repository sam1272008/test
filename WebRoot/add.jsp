<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE>
<html>
<head>
<style type="text/css">
.class1{text-align:right;width:150px;padding:5px}
</style>
</head>
  <body>
<%@include file="top.jsp" %>
	<div style="width:200px;height:100%;float:left;border:1px solid;">
		<%@include file="left.jsp" %>
	
	</div>
	<div style="height:100%;border:1px solid;padding:10px 0 0 230px">
<form action="emp?type=3" method="post">
	<table border="2" width="400px" >
		<tr><td class="class1">姓名ename: 	</td>	<td><input type="text" name="ename"></td></tr>
		<tr><td class="class1">岗位job:    	</td>	<td><input type="text" name="job">	</td></tr>
		<tr><td class="class1">领导编号mgr: 	</td>	<td><input type="text" name="mgr" > </td></tr>
		<tr><td class="class1">入职时间hiredate:</td>	<td><input type="text" name="hdate"></td></tr>
		<tr><td class="class1">工资sal:    	</td>	<td><input type="text" name="sal"> 	</td></tr>
		<tr><td class="class1">奖金comm: 		</td>	<td><input type="text" name="comm">	</td></tr>
		<tr><td class="class1"> 部门编号deptno:</td>	<td><input type="text" name="deptno"></td></tr>
		<tr><td colspan="2"><input type="submit" value="确定添加"></td></tr>
	</table>
</form>	
	
	</div>
	

  </body>
</html>
