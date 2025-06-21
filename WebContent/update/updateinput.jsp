<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@ page import="bean.Student, java.util.List" %>
<% List<Student> list = (List<Student>)request.getAttribute("list"); %>

<p>データを更新する学生を選んでください</p>
<form action ="/kouka2/update">
	<select name="stuId">
	<%-- リクエストで渡された list から、順次データを取り出しセレクトボックスに格納する。 --%>
	<% for(Student stu : list){ %>
		<option value="<%= stu.getStudentId() %>"><%= stu.getStudentName() %></option>
	<% } %>
	</select>
	<input type="submit" value="送信">
</form>

<%@include file="../footer.html" %>
