<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>

    <% Cookie [] cookies = request.getCookies(); %>
    <h1>Os Cookies armazenados no cliente são: </h1>

    <ul>
    <% for (int i = 0; i < cookies.length; i++) {%>
        <li> <%= cookies[i].getName() %> | <%= cookies[i].getValue() %> </li>
    <%}%>
    </ul>

</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>