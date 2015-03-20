<%-- 
    Document   : testes
    Created on : 12/03/2015, 10:25:50
    Author     : 31409695
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.br.lp2.model.ConnectionFactory.ConnectionFactory"%>
<%@page import="java.sql.Date"%>
<%@page import="com.br.lp2.model.Ator"%>
<%@page import="com.br.lp2.model.DAO.AtorDAOConcreto"%>
<%@page import="com.br.lp2.model.DAO.AtorDAO"%>
<%@page import="com.br.lp2.model.javabeans.Funcionario"%>
<%@page import="com.br.lp2.model.DAO.FuncionarioDAOConcreto"%>
<%@page import="com.br.lp2.model.DAO.FuncionarioDAO"%>
<%@page import="com.br.lp2.model.javabeans.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.br.lp2.model.DAO.CargoDAOConcreto"%>
<%@page import="com.br.lp2.model.DAO.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            AtorDAOConcreto dao = new AtorDAOConcreto();
            Ator a = new Ator("teset", "aaa");
            dao.updateAtor(1, a);

        %>
    </body>
</html>
