<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2021/4/28
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    <input type="hidden" id="id" name="id" value="<%=user.getId()%>">
    <input type="text" name="Username" placeholder ="Username"  value="<%=u.getUsername()%>" style="background:#FFFCEC;border: 0;width:300px;height:30px;margin-bottom: 10px;" required autofocus><br/>
    <input type="password" name="password" minlength="8" placeholder ="Password" value="<%=u.getPassword()%>"  style="background:#FFFCEC;border: 0;width:300px;height:30px;margin-bottom: 10px;"><br/>
    <input type="email" name="Email" placeholder ="Email"  value="<%=u.getEmail()%>"  style="background:#FFFCEC;border: 0;width:300px;height:30px;margin-bottom: 10px;"required autofocus><br/>
    Gender<input type="radio" name="sex" value="male" <%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="sex" value="female" <%="female".equals(u.getGender())?"checked":""%> style="margin-bottom: 10px;">Female<br/>
    <input type="date" name="BirthDate" placeholder ="Date of Birth(yyyy-mm-dd)"  value="<%=u.getBirthDate()%>" style="background:#FFFCEC;border: 0;height:30px;width:300px;margin-bottom: 10px;"><br/>
    <input type="submit" value="Save Changes"  style="background:#Ff9925; color:#fff; width:100px; height:30px;border: 0;"/>
</form>
<%@include file="footer.jsp"%>
