<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sp.senai.br.model.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Alterar Cliente</title>
	<link href="css/cadastro.css" type="text/css" rel="stylesheet" >
	<link href="css/lista.css" rel="stylesheet" type="text/css" >
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link href="css/cadastro.css" type="text/css" rel="stylesheet" >
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<% Cliente cliente = (Cliente) request.getAttribute("detalha"); %>
	<main>
	 <% if (cliente != null) { %>
		<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Bem Vindo !</h3>
                        <p>Tela Para Alterar Clientes do Bitteta, Jeferson e Pedro Santana</p>
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Digite os Dados do Cliente</h3>
                                <form action="/ClientesJSP-FINAL/alterarcliente" method="post">
                                    <div class="row register-form">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input type="text" class="form-control" placeholder="Nome" name="txtNome" value="<%=cliente.getNomeCliente() %>" />
                                            </div>
                                            <div class="form-group">
                                                <input type="hidden" class="form-control" placeholder="Nome" name="txtId" value="<%=cliente.getIdCliente() %>" />
                                            </div>
                                            <div class="form-group">
                                                <div class="maxl">
                                                    <label class="radio inline"> 
                                                        <input type="radio" name="gender" value="male" checked>
                                                        <span> Masculino </span> 
                                                    </label>
                                                    <label class="radio inline"> 
                                                        <input type="radio" name="gender" value="female">
                                                        <span> Feminino </span> 
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input type="text" minlength="10" maxlength="10" name="txtTelefone" class="form-control" placeholder="Telefone" value="<%=cliente.getTelefoneCliente() %>" />
                                            </div>
                                            <div class="form-group">
                                                <input type="text" class="form-control" placeholder="Endereço" name="txtEndereco" value="<%=cliente.getEnderecoCliente() %>" />
                                            </div>
                                            <input type="submit" class="btnRegister" value="Alterar"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         <% } else { %>
	        <div class="form-content-erro">
				<div class="well">
					<div class="alert alert-danger" id="Erro">
				  		<p><strong>Erro!</strong> Não Foi Possível Encontrar o Cliente</p>
					</div>
				</div>
			</div>
		<% } %>
	</main>
</body>
</html>