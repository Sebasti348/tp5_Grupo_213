package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.AlumnoService;

@Controller
public class AlumnoController {
	@Autowired
	AlumnoDTO nuevoAlumnoDTO;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", nuevoAlumnoDTO);	
		modelView.addObject("flag", false);
		return modelView;
	}
	
	@GetMapping("/listadoAlumnos")
	public ModelAndView getFormListaAlumno() {
		
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());	
		
		return modelView;	
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoDTOParaGuardar) {
				
		alumnoService.guardarAlumno(alumnoDTOParaGuardar);
		//Mostrar el listado
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());	
		
		return modelView;		
	}
	
	@GetMapping("/modificarAlumno/{lu}")
	public ModelAndView getFormModificarAlumno(@PathVariable(name = "lu") String lu) {
		// buscar
		// Alumno alumnoParaModificar = ListadoAlumnos.buscarAlumnoPorLu(lu);
		AlumnoDTO alumno = alumnoService.buscarAlumno(lu);
		// mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumno);
		modelView.addObject("flag", true);
		return modelView;
	}
 
	@PostMapping("/modificarAlumno")	
	public ModelAndView updateAlumnoByName(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoModificado) {

		// guardar
		//ListadoAlumno.modificarAlumno(alumnoModificado);
		alumnoService.modificarAlumno(alumnoModificado);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());

		return modelView;
	} 


    
}