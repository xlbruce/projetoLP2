<%-- 
    Document   : testes
    Created on : 12/03/2015, 10:25:50
    Author     : 31409695
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.br.lp2.model.javabeans.Cliente.Especiais"%>
<%@page import="com.br.lp2.model.javabeans.Cliente"%>
<%@page import="com.br.lp2.model.DAO.ClienteDAOConcreto"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.br.lp2.model.ConnectionFactory.ConnectionFactory"%>
<%@page import="java.util.Date"%>
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
            ClienteDAOConcreto dao = new ClienteDAOConcreto();
            Cliente c = new Cliente(0, "João", new Date(), Especiais.GERAL);
            dao.deleteCliente(9);
            out.print(dao.readClienteById(1));
            


        %>
    </body>
</html>
