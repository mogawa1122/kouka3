<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>
<% String message = (String)request.getAttribute("message"); %>
<%-- 引き渡された、成功/失敗 のメッセージを表示する --%>
<p><%= message %></p>

<p><a href="menu/top.html">Topページへ</a></p>

<%@include file="../footer.html" %>
