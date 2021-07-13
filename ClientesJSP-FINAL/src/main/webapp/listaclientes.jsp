<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="sp.senai.br.model.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
<link href="css/lista.css" rel="stylesheet" type="text/css" >
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<% List<Cliente> lista = (List<Cliente>) request.getAttribute("lista"); %>	
<main>
<% if (lista == null) { %>
		<div class="form-content-erro">
			<div class="well">
				<div class="alert alert-danger" id="Erro">
			  		<p><strong>Erro!</strong> Não Foi Possível Encontrar a Lista.</p>
				</div>
			</div>
		</div>
<% } else { %>
	<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>Lista dos Clientes Cadastrados no Banco de Dados !</p>
                </div>
                <div class="form-content">
                    <div class="well">
                        <table class="table">
                          <thead>
                            <tr>
                              <th>ID Cliente</th>
                              <th>Nome do Cliente</th>
                              <th>Telefone</th>
                              <th>Endereço</th>
                              <th style="width: 35px;"></th>
                            </tr>
                          </thead>
                          <tbody>
                     		<% for (Cliente clientes : lista) { %>
								<tr>
									<td><%= clientes.getIdCliente() %></td>
									<td><%= clientes.getNomeCliente() %></td>
									<td><%= clientes.getTelefoneCliente() %></td>
									<td><%= clientes.getEnderecoCliente() %></td>
									<td><a href="/ClientesJSP-FINAL/detalhacliente?txtId=<%=clientes.getIdCliente() %>" ><i class="icon-pencil"></i></a></td>
									<td><a href="/ClientesJSP-FINAL/excluircliente?txtId=<%= clientes.getIdCliente() %> " role="button" data-toggle="modal"><i class="icon-remove"></i></a></td>
								</tr>		
							<%} %>
                          </tbody>
                        </table>
                    </div>
                    <div class="btn-toolbar">
                        <button class="btn btn-primary" onclick="window.location.href='/ClientesJSP-FINAL/'">Novo Cliente</button>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
</main>
</body>
</html>