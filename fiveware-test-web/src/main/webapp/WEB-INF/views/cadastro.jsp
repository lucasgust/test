<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nova Pessoa</title>
</head>
<body>
	<div align="center">
		<h1>Nova Pessoa</h1>
		<form:form action="insertPessoa" method="post" modelAttribute="pessoa">
			<table>
				<tr>
					<td>Nome</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Sexo</td>
					<td><form:input path="sexo" /></td>
				</tr>
				<tr>
					<td>Estado Civil</td>
					<td><form:input path="estadoCivil" /></td>
				</tr>
				<tr>
					<td>Empregado?</td>
					<td><form:input path="empregado" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Inserir"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>