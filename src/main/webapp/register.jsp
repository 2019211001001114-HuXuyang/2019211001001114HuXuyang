<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2021/4/8
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="register.jsp">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gneder" value="male"/>Male
    <input type="radio" name="gender" value="female"><br/>
    Date of Birth:<input type="date" name="birthDate"/><br/>
    <input type="submit" value="Register">
</form>
<%@include file="footer.jsp"%>