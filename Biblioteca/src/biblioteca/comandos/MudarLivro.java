package biblioteca.comandos;


	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import biblioteca.daos.LivroDAO;
	import biblioteca.models.Livro;

	public class MudarLivro implements Comando {

		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				Livro livro = new LivroDAO().getLivroById(id);
				
				request.setAttribute("livro", livro);
			} catch (Exception e) {
				request.setAttribute("message", "Sinto muito. Ocorreu um erro inesperado ao buscar livro.");
				return "WEB-INF/message.jsp";
			}
			request.setAttribute("pagina", "servico?function=BuscaLivro");
			return "cadastro-livro.jsp";
		}

		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return null;
		}
	}

