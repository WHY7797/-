<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  
  <body>
  <form  action ="UserAction">
    <table border="1" width="100%">
    	  	<th>id</th><th>姓名</th><th>操作</th>
    	<tr>	
    	<s:iterator value="#ulist" var="u">
    		<tr><td>${u.id }</td><td>${u.uname }</td><td><a href="updateu?id=${u.id }">修改</a></td></tr>
    	</s:iterator>
    	</tr>
    </table>
    </form>
 </body>
</html>
