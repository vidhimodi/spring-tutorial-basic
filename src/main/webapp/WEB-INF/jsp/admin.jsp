<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head lang="en">
    <title>Tiny Url</title>

    <style>
        table {
            border-collapse: collapse;
        }
        table td, table th {
            border: 1px solid black;
        }
        table tr:first-child th {
            border-top: 0;
        }
        table tr td:first-child,
        table tr th:first-child {
            border-left: 0;
        }
        table tr td:last-child,
        table tr th:last-child {
            border-right: 0;
        }
    </style>
</head>
<body>
<div>
    <table style="font-size: large; width: 100%; overflow: scroll;">
        <thead>
        <tr>
            <th>ID</th>
            <th>TinyUrl</th>
            <th>LongUrl</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mapping" items="${mapList}">
            <tr>
                <td>${mapping.id}</td>
                <td><a href="${mapping.tinyUrl}" target="_blank">${mapping.tinyUrl}</a></td>
                <td><a href="${mapping.longUrl}" target="_blank">${mapping.longUrl}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <a href="<c:url value="/"/>">Home</a>
</div>
</body>
</html>