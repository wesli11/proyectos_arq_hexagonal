package repository.adapter.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import repository.adapter.entity.AlumnoEntity;

public interface AlumnosSpringDataJpaRepository extends JpaRepository<AlumnoEntity, String> {

	@Query("Select a from AlumnoEntity a join a.cursos c where c.idCurso=?1")
	List<AlumnoEntity> alumnosByCurso(int idCurso);
	
	}
