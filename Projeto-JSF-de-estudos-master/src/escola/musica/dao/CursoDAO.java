package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import escola.musica.modelo.Curso;

public class CursoDAO {

	public void salvar(Curso curso) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(curso);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarTodos() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Curso");
		
		return query.getResultList();
	}

	public void excluir(Curso curso) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		curso = entityManager.merge(curso);
		
		entityManager.remove(curso);

		entityManager.getTransaction().commit();

		entityManager.close();
		
	}
}
