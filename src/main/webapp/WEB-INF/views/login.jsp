<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2021/4/8
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>"Login"
</h1>
<%
if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"<h3>");
}%>
<br/>
<form method="post" action="login.jsp">
    Username:<input type="text" name="username"><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="Submit"/>
</form>
<a href="week3/register.jsp">This is register</a>
<%@include file="footer.jsp"%>
