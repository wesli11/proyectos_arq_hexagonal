package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import repository.port.AlumnosRepository;
import repository.port.CursosRepository;
import service.port.MatriculasService;

@Service
public class MatriculasServiceImpl implements MatriculasService {
	
	@Autowired
	AlumnosRepository alumnosRepository;
	@Autowired
	CursosRepository cursosRepository;
	
	@Override
	public void matricularAlumno(String usuario, int idCurso) {
      Alumno alumno=alumnosRepository.findByAlumno(usuario);
      Curso curso=cursosRepository.findById(idCurso);
      if(alumno!=null && curso!=null) {
           curso.getAlumnos().add(alumno);  
           cursosRepository.updateCurso(curso);
      }
	}

	@Override
	public List<Curso> consultarMatriculas(String f1, String f2) {
		try {
			Date fIni = (new SimpleDateFormat("yyyy-MM-dd")).parse(f1);
			Date fFin=(new SimpleDateFormat("yyyy-MM-dd")).parse(f2);
			if(fIni.before(fFin)) {
				return cursosRepository.cursosBetweenDate(fIni, fFin);//cursosEntreFechas
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

}
