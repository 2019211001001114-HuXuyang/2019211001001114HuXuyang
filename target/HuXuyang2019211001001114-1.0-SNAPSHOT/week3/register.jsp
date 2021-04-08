
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style type="text/css">
        body{
            display: flex;
            flex-direction: row;
            justify-content: center;
            margin-top:50px ;
        }
        input{
            margin: 20px 0 20px 0;
            border-radius: 2em;
            outline: none;
            padding-left: 5px;
            width: 200px;
            height: 30px;
        }
        div input{
            width: 100px;
            height: 10px;
        }
    </style>
</head>
<body>
<form  method="post" action="${pageContext.request.contextPath}/register">
    TEXT:<input type="text" name="username" placeholder="username"><br/>
    PASSWORD：<input type="text" name="password" placeholder="password" id="password"><br/>
    Email：<input type="text" name="email" placeholder="Email"><br/>
    Gender: <input type="text" name="gender" placeholder="gender"><br/>
    birthDate:<input type="text" name="birthDate"><br/>
    <input type="submit" value="register" name="submit" id="submit"/>
</form>
</body>
<script src="register.js"></script>
</html>

