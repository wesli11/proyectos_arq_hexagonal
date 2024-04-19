package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import repository.port.AlumnosRepository;
import repository.port.CursosRepository;
import service.port.CursosService;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosRepository cursosRepository;
	
	@Autowired
	AlumnosRepository alumnosRepository;
	
	@Override
	public void guardarCurso(Curso curso) {
     if(cursosRepository.findByIdCurso(curso.getIdCurso())==null) {
    	 cursosRepository.saveCurso(curso);
     }
	}

	@Override
	public Curso buscarPorId(int idCurso) {
      Curso curso=cursosRepository.findById(idCurso);
      if(curso!=null) {
    	  return curso;
      }
		return null;
	}

	@Override
	public List<Curso> obtenerCurso() {
		return cursosRepository.allCurso();
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		Alumno alumno=alumnosRepository.findByAlumno(usuario);
		if(alumno!=null) {
			return cursosRepository.cursosAlumno(alumno.getUsuario());
		}
		return null;
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {
		Alumno alumno=alumnosRepository.findByAlumno(usuario);
        if(alumno!=null) {
        	return cursosRepository.cursosAvailableAlumno(alumno.getUsuario());
        }
		return null;
	}

	@Override
	public List<Curso> cursosEntreFechas(Date f1, Date f2) {
		   return cursosRepository.cursosBetweenDate(f1, f2);	
		}

	@Override
	public void actualizarCurso(Curso curso) {
		 if(cursosRepository.findById(curso.getIdCurso())==null) {
	    	 cursosRepository.updateCurso(curso);
	     }
		
	}

	@Override
	public Curso buscarPorIdCurso(int idCurso) {
		return cursosRepository.findByIdCurso(idCurso);
	}

	



}
