package repository.port;

import java.util.List;

import model.Alumno;

public interface AlumnosRepository {

	void saveAlumno(Alumno alumno);
	Alumno findByAlumno(String usuario);
	void updateAlumno(Alumno alumno);
	List<Alumno> allAlumnos();
	List<Alumno> alumnosCurso(int idCurso);
}
