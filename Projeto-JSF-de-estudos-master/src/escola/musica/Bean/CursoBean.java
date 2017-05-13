package escola.musica.Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import escola.musica.dao.CursoDAO;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

@ManagedBean
@SessionScoped
public class CursoBean {

	private Curso curso = new Curso();
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public CursoBean(){
		cursos = new CursoDAO().listarTodos();
		curso = new Curso();
	}
	
	public String salvar(){
		new CursoDAO().salvar(curso);
		cursos = new CursoDAO().listarTodos();
		curso = new Curso();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso salvo com sucesso"));
		return "curso_lista?faces-redirect=true";
	}
	
	public String editar(Curso curso){
		this.curso = curso;
		return "curso_formulario?faces-redirect=true";
	}
	
	public void prepararExclusao(Curso curso){
		this.curso = curso;
	}
	
	public void excluir(){
		new CursoDAO().excluir(curso);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso excluido com sucesso!"));
		cursos = new CursoDAO().listarTodos();
	}
	
	public String getDataAtual(){
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TipoCurso> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoCurso> tipos) {
		this.tipos = tipos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	

}
