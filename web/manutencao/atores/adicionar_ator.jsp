<%-- 
    Document   : adicionar_ator
    Created on : 20/04/2015, 21:07:28
    Author     : bruce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/style.css"/>
        <title>Adicionar Ator</title>
    </head>
    <body>
        <form method="post" action="../../FrontController">
            <p>Nome: <input type="text" name="nome"/></p>
            <p>Nacionalidade: <input type="text" name="nacionalidade"/></p>
            <p>Nascimento<input type="date" name="nascimento"/></p>
            <input type="hidden" name="command" value="AdicionarAtorCommand"/>
            <p><input type="submit" value="Adicionar Ator"/></p>
        </form>
    </body>
</html>
