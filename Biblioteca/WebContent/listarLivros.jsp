<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="https://icon-icons.com/icons2/407/PNG/512/Library_40740.png" type="image/x-icon" />
	<title>Listar Livros</title>

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
			<th>Titulo</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Publicação</th>
			<th>Ed.</th>
			
			<th>Gerenciamento</th>
			<th>Emprestimos</th>
			
		</tr>
		
		<c:forEach var="livro" items="${livros }" >
		
		<tr>
			<td>${livro.titulo }</td>
			<td>${livro.autor }</td>
			<td>${livro.editora }</td>
			<td><fmt:formatDate value="${livro.publicacao.time }" pattern="yyyy" /></td>
			<td>${livro.edicao } .ed</td>
			
			<!-- Gerenciamento -->
			<td>
				<table class="panel gerenc">
					<td><a href = "/Biblioteca/livro/remove?id=${livro.id }">Remov.</a></td>
					<td><a href = "/Biblioteca/livro/altera?id=${livro.id }">Alter.</a></td>
				</table>
			</td>
			
			<!-- emprestimo -->
			<td>
			<c:choose>
				<c:when test = "${livro.disponivel }">
					<form action="/Biblioteca/livro/empresta">
						<input type="text"  pattern="[0-9]+$" name="aluno.matricula" placeholder="matricula" maxlength="14">
						<input type="hidden" name="livro.id" value="${livro.id }">
					</form>
				</c:when>
				<c:otherwise>
					<a href = "/Biblioteca/livro/devolve?id=${livro.id }">Devolver</a>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<c:import url="/resources/footer.jsp"/>
</body>
</html>