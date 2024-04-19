package service.port;

import java.util.List;

import model.Alumno;

public interface AlumnosService {

	void guardarAlumno(Alumno alumno);
	Alumno buscarPorUsuario(String usuario);
	void actualizarAlumno(Alumno alumno);
	List<Alumno> obtenerAlumnos();
	List<Alumno> alumnosCurso(int idCurso);
}
