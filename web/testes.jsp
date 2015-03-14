<%-- 
    Document   : testes
    Created on : 12/03/2015, 10:25:50
    Author     : 31409695
--%>

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
//            cargoDAO.insertCargo(new Cargo("Teste"));
//            for(Cargo cargo : cargos) {
//                out.println(cargo);
//            }
//           

                        //Testes Funcionario
            FuncionarioDAO funcionarioDAO = new FuncionarioDAOConcreto();
            Funcionario f;
            ArrayList<Funcionario> funcionarios = funcionarioDAO.readFuncionarios();
            
            //Exibir funcionarios
            for (Funcionario funcionario : funcionarios) {
                out.println(funcionario);
            }
            
            //Exibir um determinado funcionario
            f = funcionarioDAO.readFuncionarioById(2);
            out.println(f);
            f = funcionarioDAO.readFuncionarioByRg("6543123");
            out.println(f);
            
            //Atualizar e exibir funcionario
            funcionarioDAO.updateFuncionario(1, new Funcionario (1, "Jao", "324253", 1, 2));
            for (Funcionario funcionario : funcionarios) {
                out.println(funcionario);
            }
            
            //Adicionar um novo funcionario
            funcionarioDAO.insertFuncionario(new Funcionario ("Teste", "2544", 1, 1));
            for (Funcionario funcionario : funcionarios) {
                out.println(funcionario);
            }
            
        %>
    </body>
</html>
