<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>${error}</p>
<p>${message}</p>
<form:form modelAttribute="loginForm" action="/login" method="post">
    <label>Username: </label><form:input path="username"/> <br/>
    <label>Password: </label><form:password path="password"/> <br/>
    <input type="submit" value="Login"/>
</form:form>
</body>
</html>
