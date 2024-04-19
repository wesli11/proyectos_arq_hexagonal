package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import repository.port.AlumnosRepository;
import service.port.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService {

	@Autowired
	AlumnosRepository alumnosRepository;
	
	@Override
	public void guardarAlumno(Alumno alumno) {
		if(alumnosRepository.findByAlumno(alumno.getUsuario())==null) {
			alumnosRepository.saveAlumno(alumno);
		}
//     Alumno a=alumnosRepository.findByAlumno(alumno.getUsuario());
//     if(a==null) {
//    	 alumnosRepository.saveAlumno(a);
//     }
	}

	@Override
	public Alumno buscarPorUsuario(String usuario) {
		Alumno alumno=alumnosRepository.findByAlumno(usuario);
		if(alumno!=null) {
			return alumno;
		}
		return null;
	}

	@Override
	public void actualizarAlumno(Alumno alumno) {
		Alumno a=alumnosRepository.findByAlumno(alumno.getUsuario());
	     if(a==null) {
	    	 alumnosRepository.saveAlumno(a);
	     }
	}

	@Override
	public List<Alumno> obtenerAlumnos() {
		return alumnosRepository.allAlumnos();
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		//comporbar que el curso exista??????????
		return alumnosRepository.alumnosCurso(idCurso);
	}

}
