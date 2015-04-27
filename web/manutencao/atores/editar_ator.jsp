<%-- 
    Document   : editar_atores
    Created on : 20/04/2015, 20:42:06
    Author     : bruce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            out.print(request.getParameter("id_ator"));
        %>
    </body>
</html>
