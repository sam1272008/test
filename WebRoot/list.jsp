<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
   	<%@include file="top.jsp" %>
	<div style="width:200px;height:100%;float:left;border:1px solid;">
		<%@include file="left.jsp" %>
	
	</div>
	<div style="height:100%;border:1px solid;padding:10px 0 0 230px">
		---数据显示--
	<table width="80%" border="1">
		<tr><td>员工编号</td><td>员工姓名</td><td>岗位</td><td>入职时间</td>
		<td>领导编号</td><td>工资</td><td>奖金</td><td>部门编号</td><td>操作</td></tr>
		<c:forEach items="${data }" var="e">
			<tr><td>${e.empno }</td><td>${e.ename }</td><td>${e.job }</td>
			<td>${e.hiredate }</td><td>${e.mgr }</td><td>${e.sal }</td>
			<td>${e.comm }</td><td>${e.deptno }</td>
			<td><a href='emp?type=4&empno=${e.empno }'>编辑</a>  <a href='emp?type=2&empno=${e.empno }'>删除</a></td></tr>
		
		</c:forEach>
	</table>
	</div>
	
  </body>
</html>
