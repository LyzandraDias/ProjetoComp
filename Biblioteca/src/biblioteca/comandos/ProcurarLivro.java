package biblioteca.comandos;

	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import biblioteca.daos.LivroDAO;
	import biblioteca.models.Livro;

	public class ProcurarLivro implements Comando {
		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			String titulo = request.getParameter("titulo");
			List<Livro> result = new ArrayList<>();
			
			try {
				//requisição vasia retorna toda a Lista
				if(titulo== null || titulo.equals("0") || titulo.isEmpty() || titulo.length() == 0){
					result = new LivroDAO().getLista();
				}
				//livros cujos titulos contém a porcao
				else {
					for(Livro livro : new LivroDAO().getLista()){
						if(livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
							result.add(livro);
						}
					}
				}
			} catch (Exception e) {
				request.setAttribute("message", "Sinto muito. Ocorreu um erro inesperado ao buscar livros.");
				return "WEB-INF/message.jsp";
			}
			
			//adiciona a lista resultante à requisicao
			request.setAttribute("livros", result);
			
			return "lista-livros.jsp";
		}

		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return null;
		};
	}

