package adapter.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Alumno;
import service.port.AlumnosService;

/**
 * Servlet implementation class AltaAlumnoAction
 */
@Controller
public class AltaAlumnoController {
	@Autowired
	AlumnosService service;
	@PostMapping("doAltaAlumno")
	public String altaAlumno(@ModelAttribute("alumno") Alumno alumno)  {	
		if(service.buscarPorUsuario(alumno.getUsuario())==null) {			
			service.guardarAlumno(alumno);
			return "menu";
		}else {
			return "usuariorepetido";
		}
	}
	//se ejecuta al entrar en la p�gina, para preparar el model attribute
	/*@GetMapping("toAltaAlumno")
	public String prepararBean(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "altaalumno";
	}*/

}
