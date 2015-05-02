<%@page import="com.br.lp2.model.javabeans.Filme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="manter_filme.css" />
<title>Manter Filmes</title>
</head>

<body>
	<div class="container">
		<div class="row">
        	<div class="titulo">Buscar Filme</div>
            	<div class="informacao">Desejo obter as seguitnes informaÃ§Ãµes:</div>
                
                <form class="form">
					<INPUT TYPE="checkbox" NAME="OPCAO" VALUE="op1"/> ID
					<INPUT TYPE="checkbox" NAME="OPCAO" VALUE="op2"/> Titulo
					<INPUT TYPE="checkbox" NAME="OPCAO" VALUE="op3"/> Idioma
            		 <input type="checkbox" name="OPCAO" value="op4" />Ano
            		 <input type="checkbox" name="OPCAO" value="op4" />Distribuidora
            		 <input type="checkbox" name="OPCAO" value="op4" />Diretor
            		 <input type="checkbox" name="OPCAO" value="op4" />ClassificaÃ§Ã£o
            		 <input type="checkbox" name="OPCAO" value="op4" />DuraÃ§Ã£o
				</form>
                
            <div class="busca">*Buscar por :</div>
            
            	<div class="nome">Titulo</div>
                <input type="text" class="nomeB"/>
            	<div class="idioma">Idioma</div>
                
                <input type="text" class="idiomaB"/>
                
            	<div class="situacao">SituaÃ§Ã£o</div>
                <input type="text" class="situacaoB"/>
                
                <div class="ano">Ano</div>
                <input type="text" class="anoB"/>
                
                <div class="distribuidora">Distribuidora</div>
                <input type="text" class="distribuidoraB"/>
               
                <div class="diretor">Diretor</div>
                <input type="text" class="diretorB"/>
              
                <div class="classificacao">ClassificaÃ§Ã£o</div>
                <input type="text" class="classificacaoB"/>
                <div class="duracao">DuraÃ§Ã£o</div>
                <input type="text" class="duracaoB"/>

            	<div class="obs">*O preenchimento nÃ£o Ã© obrigatÃ³rio em todos os campos.</div>
                                              
    <input type="submit" class="voltar"  value="Voltar"/>
              <input type="submit" class="enviar"  value="Buscar"/> 
        </div>
	</div>
</body>
</html>
