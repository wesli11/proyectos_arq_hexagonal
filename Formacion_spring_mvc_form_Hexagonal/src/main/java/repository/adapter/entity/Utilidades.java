package repository.adapter.entity;

import java.util.ArrayList;
import java.util.stream.Collectors;

import model.Alumno;
import model.Curso;

public class Utilidades {

	public static Alumno alumnoBuilder(AlumnoEntity entity) {
		return new Alumno(entity.getUsuario(), 
				              entity.getNombre(),
				                 entity.getEdad(),
				                   entity.getEmail(),
				                     entity.getPassword());
	}
	
	public static AlumnoEntity alumnoEntityBuilder(Alumno alumno) {
		AlumnoEntity entity=new AlumnoEntity();
		entity.setUsuario(alumno.getUsuario());
		entity.setNombre(alumno.getNombre());
		entity.setEdad(alumno.getEdad());
		entity.setEmail(alumno.getEmail());
		entity.setPassword(alumno.getPassword());
		return entity;
	}
	
	public static Curso cursoBuilder(CursoEntity entity) {
		return new Curso(entity.getIdCurso(), 
				          entity.getNombre(),
				           entity.getDuracion(),
				            entity.getFechaInicio(),
				            entity.getAlumnos().size()>0?entity.getAlumnos().stream()
				                .map(a->Utilidades.alumnoBuilder(a))
				                  .collect(Collectors.toList()):new ArrayList<>()	);
	}
	public static CursoEntity cursoEntityBuilder(Curso curso) {
		CursoEntity entity=new CursoEntity();
		entity.setIdCurso(curso.getIdCurso());
		entity.setNombre(curso.getNombre());
		entity.setDuracion(curso.getDuracion());
		entity.setFechaInicio(curso.getFechaInicio());
		entity.setAlumnos(curso.getAlumnos().size()>0?curso.getAlumnos().stream()
				                            .map(a->Utilidades.alumnoEntityBuilder(a))
				                              .collect(Collectors.toList()):new ArrayList<>());
		
		return entity;
}

}