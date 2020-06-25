<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head lang="en">
    <title>Home</title>
</head>
<body>
<div>
    <c:if test="${not empty errmsg}">
        <div style="color: darkred;">${errmsg}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div style="color: darkgreen;">${msg}</div>
        <div>
            Url: <a href="${url}" target="_blank">${url}</a>
        </div>
    </c:if>
    <br/>
    <h2>SPRING MVC DEMO</h2>
    <a href="<c:url value="/employees/"/>">Employees</a>
</div>
</body>
</html>