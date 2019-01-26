<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'udateu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    


  </head>
  
  <body>
  <form action="update">
   请输入名字 <input type="text" name="uname" value ="${u.uname }"/><input type="hidden" name ="id" value="${u.id }"/>
   <input type ="submit" value ="确定">
   </form>
   ${msg }
  </body>
  
</html>
