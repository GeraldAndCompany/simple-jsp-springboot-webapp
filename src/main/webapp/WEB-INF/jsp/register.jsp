<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
  <form:form modelAttribute="registrationForm" action="/register" method="POST">
    <label>Username: </label><form:input path="username"/><form:errors path="username" cssClass="error"/><br/>
    <label>Password: </label><form:password path="password"/><form:errors path="password" cssClass="error"/><br/>
    <label>Confirm Password: </label><form:password path="confirmPassword"/><form:errors path="confirmPassword" cssClass="error"/><br/>
    <input type="submit" value="Register"/>
  </form:form>
</body>
</html>
