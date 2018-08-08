<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("title", "Hey there");%>
<% request.setAttribute("message", "Hello sir");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
${message}
</body>
</html>
