package biblioteca.comandos;


	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import biblioteca.daos.LivroDAO;
	import biblioteca.models.Livro;

	public class RemoverLivro implements Comando {

		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			Long id = null;
			Livro livro = null;
			
			try {
				id = Long.parseLong(request.getParameter("id"));
				livro = new LivroDAO().getLivroById(id); 
				
				if(new LivroDAO().remover(livro)){
					request.setAttribute("message", livro.getTitulo() + " foi removido com sucesso.");
				}else {
					request.setAttribute("message", "Sinto muito. " + livro.getTitulo() + " não pôde ser removido.");
				}
			} catch (Exception e) {
				request.setAttribute("message", "Sinto muito. Ocorreu um erro inesperado ao remover livro.");
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

