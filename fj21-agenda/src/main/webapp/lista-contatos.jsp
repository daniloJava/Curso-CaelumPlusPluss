<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<title>Lista COntatos</title>
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

<body>
<div class="container" >

		<div class="row">
		<c:import url="cabecalho.jsp" />
		</div>
	</div>


	<div class="container">
		<h2>Lista de Contatos</h2>
		<div class="table-responsive">
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<td>Nome</td>
						<td>E-mail</td>
						<td>Endereço</td>
						<td>Data de Nascimento</td>
						<td>Remover</td>
						<td>Alterar</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="contato" items="${contatos}">
						<tr>
							<td>${contato.nome}</td>
							<td><a href="mailto:${contato.email}">${contato.email}</a></td>
							<td>${contato.endereco}</td>
							<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
							<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
							<td><a href="altera-contato.jsp?id=${contato.id}&nome=${contato.nome}&email=${contato.email}&end=${contato.endereco}&nasc=<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>">Alterar</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
		<a href="adiciona-contato.jsp"><button class="btn btn-default">Voltar</button></a>
	</div>
	<!-- /.col-lg-4 -->



<c:import url="rodape.jsp" />

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="resources/assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="resources/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>