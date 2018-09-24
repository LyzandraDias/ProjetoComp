	package biblioteca.comandos;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import biblioteca.daos.LivroDAO;
	import biblioteca.models.Livro;

	public class AdicionarLivro implements Comando{
		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			//criando o objeto Livro ser populado
			Livro livro = new Livro();
			
			String id = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String editora = request.getParameter("editora");
			int edicao = Integer.parseInt(request.getParameter("edicao"));
			
			String dataText = request.getParameter("publicacao");
			Calendar data = null;
			
			try {
				Date date = new SimpleDateFormat("yyyy").parse(dataText);
				data = Calendar.getInstance();
				data.setTime(date);
			} catch (ParseException e) {
				request.setAttribute
				("message", "Sinto muito. Detectamos um erro durante a conversão de datas.");
			}
			//Monta o objeto livro
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setEditora(editora);
			livro.setEdicao(edicao);
			livro.setPublicacao(data);
				
			//Desvia o fluxo entre update e insert
			try {
				if(id == null || id.equals("0") || id.isEmpty()){
					new LivroDAO().inserir(livro);
				}else {
					livro.setId(Long.parseLong(id));
					new LivroDAO().alterar(livro);
				}
				request.setAttribute("message", "O livro " + titulo + " foi adicionado/alterado com sucesso.");
				
			} catch (Exception e) {
				request.setAttribute
				("message", "Sinto muito. Detectamos um erro durante a atualização do banco de dados.");
			}
			request.setAttribute("pagina", "servico?function=BuscaLivro");
			return "WEB-INF/message.jsp";
		}

		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return null;
		}

	}
