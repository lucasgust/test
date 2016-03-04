<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$('#insertForm').submit(
		function(event) {
			event.preventDefault();
			var nome = $('input[name=nome]').val();
			var sexo = $('input[name=sexo]').val();
			var estadoCivil = $('select[name=estadoCivil] option:selected').text();
			var empregado = $('input[name=empregado]').val();

			var data = 'nome='
					+ encodeURIComponent(nome)
					+ '&sexo='
					+ encodeURIComponent(sexo)
					+ '&estadoCivil='
					+ encodeURIComponent(estadoCivil)
					+ '&empregado='
					+ encodeURIComponent(empregado);

			$.ajax({
				url : $("#insertForm").attr("action"),
				data : data,
				type : "POST",
				success : function(response) {
					console.log(response);
					window.location = "http://localhost:8080/fiveware-test-web/";
				},
				error : function(xhr, status, error) {
					console.log(xhr.responseText);
				}
			});
		}
	);
});
</script>
<title>Nova Pessoa</title>
</head>
<body>
	<div align="center">
		<h1>Nova Pessoa</h1>
		<form:form id="insertForm" action="insertPessoa" method="post" modelAttribute="pessoa">
			<table>
				<tr>
					<td>Nome</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Sexo</td>
					<td>
						<form:radiobutton path="sexo" value="M" />Masculino
						<form:radiobutton path="sexo" value="F" />Feminino
					</td>
				</tr>
				<tr>
					<td>Estado Civil</td>
					<td>
						<form:select path="estadoCivil">
						    <form:option value="SOLTEIRO" />
						    <form:option value="CASADO" />
						    <form:option value="VIÚVO" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Empregado?</td>
					<td><form:checkbox path="empregado" value="SIM"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"	value="Inserir"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>