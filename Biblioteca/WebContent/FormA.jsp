<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Adicionar aluno TOP demais</h1>
	<form action="sistema" method="post">
		<input type="hidden" name="comando" value="AdicionarAluno">
		<div>
			<label>Matricula: </label> 
			<input type="text" name="matricula">
		</div>
		<div>
			<label>Nome: </label> 
			<input type="text" name="nome">
		</div>
		<div>
			<label>Cpf: </label> 
			<input type="text" name="cpf">
		</div>
		<div>
			<label>Data de Nascimento: </label>
			<input type="text" name="dataNascimento">
		</div>
		<div>
			<label>Endereço </label>
			<input type="text" name="endereco">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>