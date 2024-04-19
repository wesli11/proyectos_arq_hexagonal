package service.port;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface CursosService {

	void guardarCurso(Curso curso);
	Curso buscarPorId(int idCurso);
	void actualizarCurso(Curso curso);
	List<Curso> obtenerCurso();
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursosDisponiblesAlumno(String usuario);
	List<Curso> cursosEntreFechas(Date f1, Date f2);
	
	//para dar de alta curso
	public Curso buscarPorIdCurso(int idCurso);
}
