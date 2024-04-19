package adapter.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import service.port.CursosService;


/**
 * Servlet implementation class CursoAction
 */
@Controller
public class CursosController extends HttpServlet {
	@Autowired
	CursosService service;
	@GetMapping("doCursos")
	public String cursos(HttpServletRequest request) {
		request.setAttribute("cursos", service.obtenerCurso());
		return "seleccioncursos";
	}

}
