<%-- 
    Document   : index
    Created on : 24/02/2015, 13:52:59
    Author     : bruce
--%>

<%@page import="com.br.lp2.model.ListaDeAtores"%>
<%@page import="java.util.Date"%>
<%@page import="com.br.lp2.model.Ator"%>
<%@page import="com.br.lp2.model.javabeans.Filme"%>
<%@page import="com.br.lp2.model.javabeans.Distribuidora"%>
<%@page import="com.br.lp2.model.javabeans.Diretor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        String usuario = (String) session.getAttribute("usuario");
        String senha = (String) session.getAttribute("senha");
        if(!"".equals(usuario) && !"".equals(senha)) {
            request.getRequestDispatcher("menu_principal.html");
        }
    %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de Controle de Cinema</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="login">
            <h1>Login</h1>
            <form method="post" action="FrontController">
                <input type="text" name="usuario" placeholder="Username" required="required" />
                <input type="password" name="senha" placeholder="Password" required="required" />
                <input type="hidden" name="command" value="LoginCommand"/>
                <button type="submit" class="btn btn-primary btn-block btn-large">Entrar</button>
            </form>
        </div>
    </body>
</html>
