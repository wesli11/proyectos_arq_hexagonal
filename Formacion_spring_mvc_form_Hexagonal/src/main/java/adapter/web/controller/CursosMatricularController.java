package adapter.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import service.port.CursosService;


/**
 * Servlet implementation class CursosMatricularAction
 */
@Controller
public class CursosMatricularController {
	@Autowired
	CursosService service;
	@PostMapping("doSeleccionCursoMatricular")
	public String cursosMatricular(HttpServletRequest request, HttpSession sesion, @RequestParam("usuario") String usuario) {
		sesion.setAttribute("usuario", usuario);//se recuerde a la hora de matricular
		request.setAttribute("cursosmatricular", service.cursosDisponiblesAlumno(usuario));
		return "cursosmatricular";
	}

}
