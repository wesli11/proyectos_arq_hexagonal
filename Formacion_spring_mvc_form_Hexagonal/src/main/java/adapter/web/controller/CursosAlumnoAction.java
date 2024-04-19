package adapter.web.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import service.port.CursosService;


/**
 * Servlet implementation class CursosAlumnoAction
 */
@Controller
public class CursosAlumnoAction {
	@Autowired
	CursosService service;
	@PostMapping("doCursosAlumno")
	public String cursosAlumno(HttpServletRequest request, @RequestParam("usuario") String usuario) throws ServletException, IOException {
		
		request.setAttribute("cursosalumno", service.cursosAlumno(usuario));
		return "cursosalumno";
	}

}
