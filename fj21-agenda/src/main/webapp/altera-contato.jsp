<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<title>Altera Contato</title>
 <link href="css/jquery.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
    
<!-- Bootstrap core CSS -->

<link href="resourcess/css/bootstrap-theme.css" rel="stylesheet" />
<link href="resourcess/css/bootstrap-theme.css.map" rel="stylesheet" />
<link href="resourcess/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="resourcess/css/bootstrap-theme.min.css.map" rel="stylesheet" />
<link href="resourcess/css/bootstrap.css" rel="stylesheet" />
<link href="resourcess/css/bootstrap.css.map" rel="stylesheet" />
<link href="resourcess/css/bootstrap.min.css" rel="stylesheet" />
<link href="resourcess/css/bootstrap.min.css.map" rel="stylesheet" />
<link href="resourcess/css/adiciona-contato.css" rel="stylesheet" />
<script src="resourcess/js/bootsrap.js"></script>
<script src="resourcess/js/bootsrap.min.js"></script>
<script src="resourcess/js/npm.js"></script>

<script src="resourcess/js/npm.js"></script>
	
</head>
<body>


	<div class="container" >

		<div class="row">
		<c:import url="cabecalho.jsp" />
		</div>
	</div>


	<div class="container span7" style="margin: 0 auto;float: none; margin-top: 1%;  ;">
 
       <div class="row">
	
		 <div class="col-md-6 col-md-offset-3 ">
		 <div class="addContatoFormu">
		<form action="mvc"  method="POST">
		<input type="hidden" name="id" value="${param.id}" />
			<div class="form-group">
				<label for="inputName">Nome:</label> <input type="text" name="nome"
					class="form-control" id="inputName" value="${param.nome}">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">E-mail</label> <input type="email"
					class="form-control" id="exampleInputEmail1" name="email"
					value="${param.email}">
			</div>

			<div class="form-group">
				<label for="Endereco">EndereÃ§o:</label> <input type="text"
					class="form-control" id="Endereco" name="endereco"
					value="${param.end}">
			</div>
			<div class="form-group">
			 
			Data Nascimento: <caelum:campoData id="dataNascimento" />
			</div>
			<input type="hidden" name="logica" value="AlteraContato" />

			<button type="submit" class="btn btn-default">Altera Contato</button>
		</form>
		<a href="mvc?logica=ListaContatosLogic"><button class="btn btn-default">Lista</button></a>	
		</div>
		</div>
		</div>
	</div>

<c:import url="rodape.jsp" />


</body>
</html>