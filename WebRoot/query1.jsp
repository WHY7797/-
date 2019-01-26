<%@page import="com.util.HIBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.beans.*"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="80%">
<tr><th>Id</th><th>姓名</th><th>是否申请</th></tr>
<%
List<Student> stuList=(List<Student>)request.getAttribute("stuList");
int tid=(Integer)session.getAttribute("tid");
for(Student stu:stuList){

%>

<tr>
<td><%=stu.getSid() %></td>
<td><%=stu.getSname() %></td>
<%
int status=HIBUtil.selectStatus(stu.getSid(),tid);
	if(status==0){
%>
<td>
		未申请
	</td>
<%
}else if(status==1){
%>
	<td>
	<a href="${pageContext.request.contextPath}/StudentAction_yes?sid=<%=stu.getSid()%>&tid=${tid}">同意</a>|<a href="${pageContext.request.contextPath}/StudentAction_no?sid=<%=stu.getSid() %>&tid=${tid}">不同意</a>
	</td>

<%
}else if(status==2){
%>
<td>
	已同意
	</td>

<%
}else if(status==3){
%>
<td>
	不同意
	</td>
</tr>
<%
}
}
%>
</table>
${msg }
</body>
</html>