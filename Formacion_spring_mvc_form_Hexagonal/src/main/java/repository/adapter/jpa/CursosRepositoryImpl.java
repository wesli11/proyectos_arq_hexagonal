package repository.adapter.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Curso;
import repository.adapter.entity.CursoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.CursosRepository;

@Repository
public class CursosRepositoryImpl implements CursosRepository {

	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;               
	                                  
	@Transactional
	@Override
	public void saveCurso(Curso curso) {
//		   CursoEntity entity= em.find(CursoEntity.class, curso.getIdCurso());
//            em.persist(entity);
		em.persist(Utilidades.cursoEntityBuilder(curso));
	}

	@Override
	public Curso findById(int idCurso) {
		String jpql="Select c from CursoEntity c join fetch c.alumnos where c.idCurso=?1";
	       TypedQuery<CursoEntity> query=em.createQuery(jpql, CursoEntity.class);
	       query.setParameter(1, idCurso);
	       List<CursoEntity>entities=query.getResultList();
			return entities.size()>0?Utilidades.cursoBuilder(entities.get(0)):null;
			}

	@Transactional
	@Override
	public void updateCurso(Curso curso) {
	      em.merge(Utilidades.cursoEntityBuilder(curso));

	}

	@Override
	public List<Curso> allCurso() {
		String jpql="Select c from CursoEntity c";
		TypedQuery<CursoEntity>query=em.createQuery(jpql, CursoEntity.class);
		List<CursoEntity>entities=query.getResultList();
		
		return entities.stream()
				    .map(c->Utilidades.cursoBuilder(c))
				      .collect(Collectors.toList());
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		String jpql="Select c from CursoEntity c join c.alumnos a where a.usuario=?1";
		TypedQuery<CursoEntity>query=em.createQuery(jpql, CursoEntity.class);
        query.setParameter(1, usuario);
        List<CursoEntity>entities=query.getResultList();
		return entities.size()>0?entities.stream()
				                  .map(c->Utilidades.cursoBuilder(c))
				                    .collect(Collectors.toList()):new ArrayList<>();
	}

	@Override
	public List<Curso> cursosAvailableAlumno(String usuario) {
		String jpql="Select c from CursoEntity c where c Not In ("
				+ "Select c from CursoEntity c join c.alumnos d where d.usuario=?1)";
		TypedQuery<CursoEntity> query=em.createQuery(jpql,CursoEntity.class);
		query.setParameter(1, usuario);		
		List<CursoEntity>entities=query.getResultList();
		return entities.size()>0?entities.stream()
				                  .map(c->Utilidades.cursoBuilder(c))
				                    .collect(Collectors.toList()):new ArrayList<>();	
    }
	
	@Override
	public List<Curso> cursosBetweenDate(Date d1, Date d2) {
		String jpql="Select c from CursoEntity c where c.fechaInicio between ?1 and ?2";
		TypedQuery<CursoEntity> query=em.createQuery(jpql,CursoEntity.class);
		query.setParameter(1, d1,TemporalType.DATE);
		query.setParameter(2, d2,TemporalType.DATE);
		List<CursoEntity>entities=query.getResultList();
		return entities.size()>0?entities.stream()
				                  .map(c->Utilidades.cursoBuilder(c))
				                    .collect(Collectors.toList()):new ArrayList<>();	
		}

	@Override
	public Curso findByIdCurso(int idCurso) {
		String jpql="Select c from CursoEntity c where c.idCurso=?1";
		TypedQuery<CursoEntity>query=em.createQuery(jpql, CursoEntity.class);
        query.setParameter(1, idCurso);
        List<CursoEntity>entities=query.getResultList();
	     return entities.size()>0?Utilidades.cursoBuilder(entities.get(0)):null;
	}

}


