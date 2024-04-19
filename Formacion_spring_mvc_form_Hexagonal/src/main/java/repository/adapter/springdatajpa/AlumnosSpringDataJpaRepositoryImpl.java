package repository.adapter.springdatajpa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Alumno;
import repository.adapter.entity.AlumnoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.AlumnosRepository;

@Repository
public class AlumnosSpringDataJpaRepositoryImpl implements AlumnosRepository{

	@Autowired
	AlumnosSpringDataJpaRepository repository;
	
	@Override
	public void saveAlumno(Alumno alumno) {
		repository.save(Utilidades.alumnoEntityBuilder(alumno));	
	}

	@Override
	public Alumno findByAlumno(String usuario) {
		AlumnoEntity entity=repository.findById(usuario).orElse(null);
		if(entity!=null) {
			return Utilidades.alumnoBuilder(entity);
		}
		return null;
	}

	@Override
	public void updateAlumno(Alumno alumno) {
		repository.saveAndFlush(Utilidades.alumnoEntityBuilder(alumno));	

	}

	@Override
	public List<Alumno> allAlumnos() {
		return repository.findAll()
				     .stream()
				        .map(a->Utilidades.alumnoBuilder(a))
				           .collect(Collectors.toList());
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		List<AlumnoEntity> entities=repository.alumnosByCurso(idCurso);
		return entities.stream()
		        .map(a->Utilidades.alumnoBuilder(a))
		           .collect(Collectors.toList());

	}

}
