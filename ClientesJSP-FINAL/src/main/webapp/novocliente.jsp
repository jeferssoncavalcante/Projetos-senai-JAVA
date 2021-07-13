<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sp.senai.br.model.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
<link href="css/lista.css" rel="stylesheet" type="text/css" >
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<main>
<% Cliente novo = (Cliente) request.getAttribute("cliente"); %>
<% if (novo == null) { %>
		<div class="form-content-erro">
			<div class="well">
				<div class="alert alert-danger" id="Erro">
			  		<p><strong>Erro!</strong> Não Foi Possível Cadastrar o Cliente !</p>
				</div>
			</div>
			<div class="btn-toolbar">
            	<button class="btn btn-primary" onclick="window.location.href='/ClientesJSP-FINAL/'">Novo Cliente</button>
       		</div>
	        <div class="btn-toolbar">
	            <button class="btn btn-primary" onclick="window.location.href='/ClientesJSP-FINAL/listaclientes'">Ver Lista de Clientes</button>
	        </div>
		</div>
<% } else { %>
	<div class="form-content-erro">
		<div class="well">
			<div class="alert alert-success" id="Erro">
		  		<p><strong>Sucesso !</strong> Cliente <%=novo.getNomeCliente() %> Foi Cadastrado no Sistema.</p>
			</div>
		</div>
		<div class="btn-toolbar">
            <button class="btn btn-primary" onclick="window.location.href='/ClientesJSP-FINAL/'">Novo Cliente</button>
        </div>
        <div class="btn-toolbar">
            <button class="btn btn-primary" onclick="window.location.href='/ClientesJSP-FINAL/listaclientes'">Ver Lista de Clientes</button>
        </div>
	</div>
<% } %>
</main>
</body>
</html>