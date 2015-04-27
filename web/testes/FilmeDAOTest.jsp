<%-- 
    Document   : FilmeDAOTest
    Created on : 30/03/2015, 15:56:28
    Author     : bruce
--%>

<%@page import="com.br.lp2.model.javabeans.Filme.TipoSituacao"%>
<%@page import="com.br.lp2.model.javabeans.Filme"%>
<%@page import="com.br.lp2.model.DAO.FilmeDAOConcreto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            FilmeDAOConcreto dao = new FilmeDAOConcreto();
            Filme f = new Filme(1, "A culpa é da sua avó", TipoSituacao.CARTAZ, "BRBR", null, null, null, 12, 12, 12);
            out.print(dao.readFilmes());
            %>
    </body>
</html>
