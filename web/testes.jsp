<%-- 
    Document   : testes
    Created on : 12/03/2015, 10:25:50
    Author     : 31409695
--%>

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
            //TESTES -- CARGO
            CargoDAO cargoDAO = new CargoDAOConcreto();
            Cargo c;
            ArrayList<Cargo> cargos = cargoDAO.readCargos();

            //exibir cargos
//            for (Cargo cargo : cargos) {
//                out.println(cargo);
//            }
            //exibir um determinado cargo
//            c = cargoDAO.readCargoById(2);
//            out.println(c);
//            c = cargoDAO.readCargoByNome("Gerente");
//            out.println(c);
            //atualizar e exibir cargos
//            cargoDAO.updateCargo(1, new Cargo(1, "Gerente"));
//            for (Cargo cargo : cargos) {
//                out.println(cargo);
//            }
            //adicionar um novo cargo
            cargoDAO.insertCargo(new Cargo("Teste"));
            for(Cargo cargo : cargos) {
                out.println(cargo);
            }
            
        %>
    </body>
</html>
