<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action="processa_vaga" method="post">
    <label>
        nome:
        <input type="text" name="field_nome">
    </label>
    <label>
        Data nascimento:
        <input type="text" name="field_data_nascimento">
    </label>


    <div>
        <div>idioma nativo:</div>
        <input type="radio" name="field_idioma" value="Português" checked> Portugês
        <input type="radio" name="field_idioma" value="INGLES"> Inglês
        <input type="radio" name="field_idioma" value="Espanhol"> Espanhol
    </div>

    <div>
        <div>Habilidades:</div>
        <input type="checkbox" name="field_habilidades" value="Java" checked> Java
        <input type="checkbox" name="field_habilidades" value="JavaScript"> JavaScript
        <input type="checkbox" name="field_habilidades" value="Html"> HTML
        <input type="checkbox" name="field_habilidades" value="Css"> CSS

    </div>

    <input type="submit" value="aplicar">
    <input type="reset" value="redefinir">
</form>


</body>
</html>