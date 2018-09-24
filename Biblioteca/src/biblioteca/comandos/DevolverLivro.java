package biblioteca.comandos;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import biblioteca.daos.EmprestimoDAO;
	import biblioteca.daos.LivroDAO;
	import biblioteca.models.Livro;

	public class DevolverLivro implements Comando{
		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			long id = Long.parseLong(request.getParameter("id"));
			Livro livro = new LivroDAO().getLivroById(id);
			
			try{
				if(new EmprestimoDAO().removerByLivro(livro)){
					request.setAttribute
					("message", livro.getTitulo() + " devolvido à biblioteca. Obrigado.");
				}else {
					request.setAttribute
					("message", "Sinto muito. " + livro.getTitulo() + " não pôde ser devolvido.");
				}
			}
			catch (Exception e) {
				request.setAttribute
				("message", "Sinto muito. Um erro inesperado ocorreu ao devolver livro.");
			}
			return "WEB-INF/message.jsp";
		}

		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return null;
		}
	}

