<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../header.html" %>

<%@page import="bean.StudentExp, java.util.List" %>

<!-- 下記の@SuppressWarningsはEclipseの警告を消すための記述です。 -->
<%
@SuppressWarnings("unchecked")
List<StudentExp> list=(List<StudentExp>)request.getAttribute("list");
%>
<table border="1">
<tr><th>学生番号</th><th>学生氏名</th><th>コース名</th></tr>
<% for (StudentExp s : list) { %>
	<tr>
	<td><%=s.getStudentId() %></td>
	<td><%=s.getStudentName() %></td>
	<td><%=s.getCourseName() %></td>
	</tr>
<% } %>
</table>

<p><a href="menu/top.html">Topページへ</a></p>

<%@include file="../footer.html" %>
