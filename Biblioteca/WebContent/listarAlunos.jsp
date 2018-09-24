<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="https://icon-icons.com/icons2/407/PNG/512/Library_40740.png" type="image/x-icon" />
	<title>Listar Alunos</title>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<c:url value= '/resources/body.css'/>">
	
	<style>
	
	</style>
</head>

<body>
	<c:import url="/resources/header.jsp"/>
	<div id = "this">
		<table class = "panel lista">
		<tr>
			<th>Matricula</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Endereço</th>
			<th>Nascimento</th>
			
			<th>Gerenciamento</th>
		</tr>
		
		<c:forEach var="aluno" items="${alunos }" >
		<tr>
			<td>${aluno.matricula }</td>
			<td>${aluno.nome }</td>
			<td>${aluno.cpf }</td>
			<td>${aluno.endereco }</td>
			<td><fmt:formatDate value="${aluno.dataNascimento.time }" pattern="dd/MM/yyyy" /></td>
			
			<!-- opções de gerenciamento -->
			<td><table class="panel gerenc">
				<td><a href = "/Biblioteca/aluno/remove?id=${aluno.id }">Remov.</a></td>
				<td><a href = "/Biblioteca/aluno/altera?id=${aluno.id }">Alter.</a></td>
			</table></td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<c:import url="/resources/footer.jsp"/>
</body>
</html>