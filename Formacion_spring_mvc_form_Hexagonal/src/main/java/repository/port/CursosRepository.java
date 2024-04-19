package repository.port;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface CursosRepository {

	void saveCurso(Curso curso);
	Curso findById(int idCurso);
	void updateCurso(Curso curso);
	List<Curso> allCurso();
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursosAvailableAlumno(String usuario);
	List<Curso> cursosBetweenDate(Date d1, Date d2);
	//para dar de alta curso
	public Curso findByIdCurso(int idCurso);
	
}
