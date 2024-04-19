package service.port;

import java.util.List;

import model.Curso;

public interface MatriculasService {

	public void matricularAlumno(String usuario, int idCurso);
	public List<Curso> consultarMatriculas(String f1, String f2);
}
