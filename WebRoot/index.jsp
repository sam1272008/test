<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>

  <body>
	<%@include file="top.jsp" %>
	<div style="width:200px;height:100%;float:left;border:1px solid;">
		<%@include file="left.jsp" %>
	
	</div>
	<div style="height:100%;border:1px solid;padding:10px 0 0 230px">
		<%@include file="main.jsp" %>
	
	</div>
	
  </body>
</html>
