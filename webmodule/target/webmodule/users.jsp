<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Users</title>
</head>
<body>

<table border="1px">
    <tr bgcolor="#ccc">
        <th>First Name</th>
        <th>Last Name</th>
        <th>Password</th>
    </tr>
    <c:forEach var="u" items="${requestScope.users}">
        <tr>
            <td><c:out value="${u.getFirst_name()}"/></td>
            <td><c:out value="${u.getLast_name()}"/></td>
            <td><c:out value="${u.getPassword()}"/></td>
        <tr/>
    </c:forEach>
</table>

</body>
</html>
