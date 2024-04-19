package adapter.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import service.port.AlumnosService;


/**
 * Servlet implementation class AlumnosAction
 */
@Controller
public class AlumnosMatricularController{
	@Autowired
	AlumnosService service;
	@GetMapping("doSeleccionAlumnoMatricular")
	public String alumnos(HttpServletRequest request) {
		request.setAttribute("alumnos", service.obtenerAlumnos());
		return "alumnosmatricular";
	}

}
