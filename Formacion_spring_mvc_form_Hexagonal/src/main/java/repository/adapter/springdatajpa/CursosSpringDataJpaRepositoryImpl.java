package repository.adapter.springdatajpa;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Curso;
import repository.adapter.entity.Utilidades;
import repository.port.CursosRepository;

@Repository
public class CursosSpringDataJpaRepositoryImpl implements CursosRepository {

	@Autowired
	CursosSpringDataJpaRepository repository;
	
	@Override
	public void saveCurso(Curso curso) {
		repository.save(Utilidades.cursoEntityBuilder(curso));
	}

	@Override
	public Curso findById(int idCurso) {
		return null;
	}

	@Override
	public void updateCurso(Curso curso) {
		repository.saveAndFlush(Utilidades.cursoEntityBuilder(curso));

	}

	@Override
	public List<Curso> allCurso() {
		return repository.findAll().stream()
				    .map(a->Utilidades.cursoBuilder(a))
				      .collect(Collectors.toList());
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return null;
	}

	@Override
	public List<Curso> cursosAvailableAlumno(String usuario) {
		return null;
	}

	@Override
	public List<Curso> cursosBetweenDate(Date d1, Date d2) {
		return null;
	}

	@Override
	public Curso findByIdCurso(int idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
