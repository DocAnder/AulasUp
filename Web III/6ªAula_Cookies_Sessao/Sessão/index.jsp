<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%

    Boolean logado = (Boolean) session.getAttribute("is_logged_in");
    if(logado == null || logado == false){
        response.sendRedirect("http://localhost:8080/login/index.jsp");
    }
%>

<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<form action="login" method="post">
    <div>
        <input type="text" name="field_user" placeholder="usuario">
    </div>
    <div>
        <input type="text" name="field_password" placeholder="senha">
    </div>
    <input type="submit">

</form>


</body>
</html>