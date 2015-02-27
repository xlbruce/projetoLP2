<%-- 
    Document   : index
    Created on : 24/02/2015, 13:52:59
    Author     : bruce
--%>

<%@page import="com.br.lp2.model.ListaDeAtores"%>
<%@page import="java.util.Date"%>
<%@page import="com.br.lp2.model.Ator"%>
<%@page import="com.br.lp2.model.Filme"%>
<%@page import="com.br.lp2.model.Distribuidora"%>
<%@page import="com.br.lp2.model.Diretor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de Controle de Cinema</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <% 
            /*Testes 
            Ator a = new Ator("Johnny Depp", "EUA");
            ListaDeAtores listaAtores = new ListaDeAtores();
            listaAtores.addAtor(a, "Jack", "principal");
            Filme f = new Filme ("Filme1", Filme.TiposSituacao.ESTREIA.toString(), "Portugues", listaAtores, new Distribuidora(1, "Paramount"), new Diretor("Diretor1", 1), 12, 1988, 1, 123, false);
            out.print(f);
            */
        %>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Sistema de Controle de Cinema</h1>
                    <div class="account-wall">
                        <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                             alt="">
                        <form class="form-signin">
                            <input type="text" class="form-control" placeholder="Login" required autofocus>
                            <input type="password" class="form-control" placeholder="Senha" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Entrar</button>
                            <label class="checkbox pull-left">
                                <input type="checkbox" value="remember-me">
                                Lembrar-me
                            </label><br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
