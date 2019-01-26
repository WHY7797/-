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
<tr><th>Id</th><th>姓名</th><th>课程</th><th>申请状态</th></tr>

<%
List<Teacher> teaList=(List<Teacher>)request.getAttribute("teaList");
int sid=(Integer)session.getAttribute("sid");
for(Teacher tea:teaList){

%>

<tr>
<td><%=tea.getTid() %></td>
<td><%=tea.getTname() %></td>
<td><%=tea.getKe() %></td>
<%
int status=HIBUtil.selectStatus(sid,tea.getTid());
	if(status==0){
%>
<td>
		<a href="${pageContext.request.contextPath}/StudentAction_shen?tid=<%=tea.getTid() %>&sid=${sid}">申请</a>
	</td>
<%
}else if(status==1){
%>
	<td>
	申请中
	</td>

<%
}else if(status==2){
%>
<td>
	申请成功
	</td>

<%
}else if(status==3){
%>
<td>
	申请失败
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