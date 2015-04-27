<%-- 
    Document   : manter_atores
    Created on : 20/04/2015, 12:58:50
    Author     : bruce
--%>

<%@page import="com.br.lp2.model.Ator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.br.lp2.model.DAO.AtorDAOConcreto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manutenção de Atores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../../css/style.css"/>

    </head>
    <body>
        <%
            //Conexão com o banco
            AtorDAOConcreto dao = new AtorDAOConcreto();
        %>
        <form method="post" action="../../FrontController">
        <table>
            <thead>
                <tr>
                    <th>__</th>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Nacionalidade</th>
                    <th>Nascimento</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Ator> atores = dao.readAtors();
                    //Loop para preencher a tabela
                    for (Ator ator : atores) {
                %>

                <tr>
                    <td><input name="id_ator" type="radio" value="<%=ator.getId()%>"/></td>
                    <td><%=ator.getId()%></td>           
                    <td><%=ator.getNome()%></td> 
                    <td><%=ator.getNacionalidade()%></td>
                    <td><%=ator.getNascimento()%></td> 
                </tr>

                <%
                        //Finaliza o loop
                    }
                %>
            </tbody>
        </table>
        <br/>        
        <a href="adicionar_ator.jsp"><input type="button" value="Adicionar Ator"/></a>
        <a href="editar_ator.jsp"><input type="submit" value="EditarAtor"/></a>
    </form>
</body>
</html>
