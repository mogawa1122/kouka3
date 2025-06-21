<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@ page import="bean.Course, java.util.List" %>
<% List<Course> list = (List<Course>)request.getAttribute("list"); %>

<p>追加する学生の情報を入力してください。</p>
<form action ="/kouka2/insert">
	学生番号：
	<input type="number" name="stuId" required><br>
	学生名　：
	<input type="text" name="stuName" required><br>
	コース名：
	<select name="crsId">
	<%-- リクエストで渡された list から、順次データを取り出しセレクトボックスに格納する。 --%>
	<% for(Course crs : list){ %>
		<option value="<%= crs.getCourseId() %>"><%= crs.getCourseName() %></option>
	<% } %>
	</select>
	<input type="submit" value="送信">
</form>

<%@include file="../footer.html" %>
