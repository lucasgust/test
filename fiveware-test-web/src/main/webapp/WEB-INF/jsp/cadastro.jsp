<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
function inserir() {
	var nome = $('input[name=nome]').val();
	if (nome == 'undefined' || nome == null || $.trim(nome) == '') {
		alert('Nome não informado!');
		return false;
	}
	
	var sexo = $('input[name=sexo]:checked').val();
	var estadoCivil = $('select[name=estadoCivil] option:selected').text();
	
	var empregado = $('input[name=empregado]:checked').val();
	if (empregado == 'undefined' || empregado == null || $.trim(empregado) == '') {
		empregado = 'NÃO';
	}
	
	var data = 
		'nome=' + encodeURIComponent(nome) + 
		'&sexo=' + encodeURIComponent(sexo) + 
		'&estadoCivil=' + encodeURIComponent(estadoCivil) + 
		'&empregado=' + encodeURIComponent(empregado);

	$.ajax(
		{
			url : "inserir",
			data : data,
			type : "POST",
			success : function(response) {
				$('#grid').html(response);
				console.log(response);
			},
			error : function(xhr, status, error) {
				alert("Erro ao cadastrar...");
				console.log(xhr.responseText);
			}
		}
	);
}
</script>
<title>Cadastro</title>
</head>
<body>
	<div>
		<h1>Cadastro</h1>
		<table border="1">
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" /></td>
			</tr>
			<tr>
				<td>Sexo</td>
				<td>
					<input type="radio" name="sexo" value="M" checked />Masculino
					<input type="radio" name="sexo" value="F" />Feminino
				</td>
			</tr>
			<tr>
				<td>Estado Civil</td>
				<td>
					<select name="estadoCivil">
					    <option value="SOLTEIRO">Solteiro</option>
					    <option value="CASADO">Casado</option>
					    <option value="VIÚVO">Viúvo</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Empregado?</td>
				<td><input type="checkbox" name="empregado" value="SIM"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="Inserir" onclick="inserir()"></td>
			</tr>
		</table>
	</div>
	
	<br>
	
	<div id="grid">
		<table border="1">
			<th>ID</th>
			<th>Nome</th>
			<th>Sexo</th>
			<th>Estado Civil</th>
			<th>Empregado</th>
			<c:forEach var="pessoa" items="${listPessoa}">
				<tr>
					<td>${pessoa.id}</td>
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