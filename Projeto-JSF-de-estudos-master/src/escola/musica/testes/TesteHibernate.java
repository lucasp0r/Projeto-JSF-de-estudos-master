package escola.musica.testes;

import escola.musica.dao.CursoDAO;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

public class TesteHibernate {

	public static void main(String[] args) {

		Curso c = new Curso();
		CursoDAO dao = new CursoDAO();
		
		c.setNome("TESTE0002");
		c.setDescricao("Curos de violino");
		c.setDucarao(3);
		c.setTipo(TipoCurso.CORDAS);
		
		
		dao.salvar(c);
		
		System.out.println("Curso " + c.getNome() + " salvo com sucesso");
		
	}

}
