package repository.adapter.jpa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Alumno;
import repository.adapter.entity.AlumnoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.AlumnosRepository;

@Repository
public class AlumnosRepositoryImpl implements AlumnosRepository {

	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;
	
	@Transactional
	@Override
	public void saveAlumno(Alumno alumno) {
		// if(alumno!=null) {
	      em.persist(Utilidades.alumnoEntityBuilder(alumno));
	//}
	}

	@Override
	public Alumno findByAlumno(String usuario) {
		AlumnoEntity entity= em.find(AlumnoEntity.class, usuario);
		if(entity!=null) {
			return Utilidades.alumnoBuilder(entity);
		}
		return null;
	}

	@Transactional
	@Override
	public void updateAlumno(Alumno alumno) {
	      em.persist(Utilidades.alumnoEntityBuilder(alumno));

	}

	@Override
	public List<Alumno> allAlumnos() {
		TypedQuery<AlumnoEntity>query=em.createNamedQuery("AlumnoEntity.findAll", AlumnoEntity.class);
		 List<AlumnoEntity>entidades=query.getResultList();
		 return entidades.stream()
				     .map(entity->Utilidades.alumnoBuilder(entity))
				       .collect(Collectors.toList());
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		String jpql="Select a from AlumnoEntity a join a.cursos c where c.idCurso=?1";
		TypedQuery<AlumnoEntity>query=em.createQuery(jpql, AlumnoEntity.class);
		query.setParameter(1, idCurso);
		List<AlumnoEntity> entities=query.getResultList();
		return entities.stream()
				    .map(a->Utilidades.alumnoBuilder(a))
				     .collect(Collectors.toList());
	}

}
