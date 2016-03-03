<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Pessoas</title>
</head>
<body>
	<div align="center">
		<h1>Cadastro de Pessoas</h1>
		<h3>
			<a href="/cadastro">Inserir Pessoa...</a>
		</h3>
		<table border="1">
			<th>#</th>
			<th>Nome</th>
			<th>Sexo</th>
			<th>Estado Civil</th>
			<th>Empregado</th>
			<c:forEach var="pessoa" items="${listPessoa}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.sexo}</td>
					<td>${pessoa.estadoCivil}</td>
					<td>${pessoa.empregado}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>