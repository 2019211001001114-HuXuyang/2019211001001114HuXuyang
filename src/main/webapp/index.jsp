<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form method="get"  target="_blank" action="search">
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="Baidu">Baidu</option>
        <option value="Bing">Bing</option>
        <option value="Google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include file="footer.jsp"%>
