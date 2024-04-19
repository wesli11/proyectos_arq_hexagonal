package repository.adapter.springdatajpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import repository.adapter.entity.CursoEntity;

public interface CursosSpringDataJpaRepository extends JpaRepository<CursoEntity, Integer> {

	@Query("Select c from CursoEntity c join c.alumnos a where a.usuario=?1")
	public List<CursoEntity> cursosByAlumno(String usuario);

	@Query("Select c from CursoEntity c where c Not In ( Select c from CursoEntity c join c.alumnos a where a.usuario=?1)")
	public List<CursoEntity> cursosNoAlumno(String usuario);
	
	@Query("Select c from CursoEntity c join fetch c.alumnos where c.fechaInicio between ?1 and ?2")
	public List<CursoEntity> cursosEntreFechas(Date d1, Date d2);

  //@Query("Select c From CursoEntity c join fetch c.alumnos where c.fechaInicio between ?1 and ?2")

}
