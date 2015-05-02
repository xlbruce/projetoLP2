<%@page import="com.br.lp2.model.javabeans.Distribuidora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="manter_distribuidora.css" />
<title>Manter Distribuidora</title>
</head>

<body>
	<div class="container">
		<div class="row">
        	<div class="titulo">Buscar Distribuidora</div>
            	<div class="informacao">Desejo obter as seguitnes informaÃ§Ãµes:</div>
                
                <form class="form">
					<INPUT TYPE="checkbox" NAME="OPCAO" VALUE="op1"/> ID
					<INPUT TYPE="checkbox" NAME="OPCAO" VALUE="op2"/> Nome
					
				</form>
            <div class="busca">*Buscar por :</div>
            
            	<div class="nome">Nome</div>
                <input type="text" class="nomeBOX"/>
            	
                <input type="submit" class="voltar"  value="Voltar"/>
                <input type="submit" class="enviar"  value="Buscar"/>
        </div>
	</div>
</body>
</html>
