package biblioteca.comandos;

	import java.util.Calendar;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import biblioteca.daos.AlunoDAO;
	import biblioteca.daos.EmprestimoDAO;
	import biblioteca.daos.LivroDAO;
	import biblioteca.models.Aluno;
	import biblioteca.models.Emprestimo;
	import biblioteca.models.Livro;

	public class EmprestarLivro implements Comando {

		public String execute(HttpServletRequest request, HttpServletResponse response) {
			//objeto emprestimo a ser inserido
			Emprestimo emprestimo = null;
			
			try {
				emprestimo = new Emprestimo();
				
				long idLivro = Long.parseLong(request.getParameter("livro"));
				Livro livro = new LivroDAO().getLivroById(idLivro);
				String matAluno = request.getParameter("aluno");
				Aluno aluno = new AlunoDAO().getAlunoByMatricula(matAluno);
				Calendar data = Calendar.getInstance();
				
				emprestimo.setLivro(livro);
				emprestimo.setAluno(aluno);
				emprestimo.setDataEmp(data);
				
				//regra de negocio RN_STATUS
				if(!aluno.isStatus()){
					request.setAttribute("message", aluno.getNome() + " bloqueado por atrasos. Favor, regularizar situação.");
					
					return "WEB-INF/message.jsp";
				}
				//regra de negócio RN_MAXIMO
				if(aluno.getEmprestimos().size() >= Emprestimo.MAXIMO_ALUNO){
					request.setAttribute("message", aluno.getNome() + " bloqueado. Quantidade máxima por aluno atingida.");
					
					return "WEB-INF/message.jsp";
				}
				
				//Método de inserção.
				if (new EmprestimoDAO().inserir(emprestimo)) {
					request.setAttribute
					("message", "Emprestimo para " + aluno.getNome() + " realisado com sucesso!");
				}else {
					request.setAttribute
					("message", "Sinto muito. O empréstimo não pôde ser relisado.");
				}
			} catch (Exception e) {
				request.setAttribute
				("message", "Sinto muito. Um erro inesperado ocorreu ao emprestar livro.");
			}
			return "WEB-INF/message.jsp";
		}

		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return null;
		}
	}

