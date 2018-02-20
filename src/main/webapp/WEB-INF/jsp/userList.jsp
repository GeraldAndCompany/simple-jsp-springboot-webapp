<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Role(s)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="usersLoopStatus">
        <tr>
            <td><c:out value="${user.username}" default="[username not found]"/></td>
            <td>
                <c:forEach items="${user.roles}" var="role" varStatus="rolesLoopStatus">
                    <c:if test="${rolesLoopStatus.index != 0}">
                        <c:out value=","/>
                    </c:if>
                    <c:out value="${role.name}" default="[role name not found]"/>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
