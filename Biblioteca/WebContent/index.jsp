<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="https://icon-icons.com/icons2/407/PNG/512/Library_40740.png" type="image/x-icon" />
<title>el Partenon</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value= '/resources/body.css'/>">

</head>
<body>
	<c:import url="/resources/header.jsp" />
	<div id="this">
		<!-- funções relacionadas aos usuários -->
		<div id="aluno" class="panel index">
			<h3>Gerenciar Alunos <br /> <small>cadastros, remoções, relatórios, etc.</small>
			</h3>

			<a href = "/Biblioteca/aluno">Cadastrar um novo aluno</a>
			<a href = "/Biblioteca/aluno/lista">Listar alunos cadastrados</a>
			<br/>
			<a href = "/Biblioteca/aluno/relatorio" style="padding: 0.5%; margin: 0.5%;">Gerar Relatórios</a>
		</div>

		<!-- funções relacionadas aos livros -->
		<div id="livro" class="panel index">
			<h3>
				Opções para Livros <br /> <small>emprestimos, cadastros, listas, etc.</small>
			</h3>
			
			<a href = "/Biblioteca/livro">Cadastrar um novo livro</a>
			<a href = "/Biblioteca/livro/lista">Listar livros cadastrados</a>
			<br/>
			<form id="formLivro" style = "border: none; width: 100%; margin: 0px; padding: 0px;" action="/Biblioteca/livro/lista">
				<input type="text" name="titulo" placeholder="título ou parte e press Enter...">
				<input type="hidden" name="function" value="BuscaLivro">
			</form>
		</div>
	</div>
	<c:import url="/resources/footer.jsp" />
</body>
</html>