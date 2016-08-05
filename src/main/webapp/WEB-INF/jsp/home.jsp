<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head lang="en">
    <title>Tiny Url</title>
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
    <form action="<c:url value="/new_entry"/>" method="post">
        <input name="longUrl" id="longUrl" placeholder="Enter the web url."/>
        <button type="submit" name="newEntry">Submit Url</button>
    </form>
    <br/>
    <a href="<c:url value="/admin/"/>">Admin</a>
</div>
</body>
</html>