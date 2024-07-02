package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.MateriaService;
import jakarta.validation.Valid;

@Controller
public class AlumnoController {
	@Autowired
	Alumno alumno;
	@Autowired
	AlumnoDTO nuevoAlumnoDTO;
	
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	MateriaService materiaService;
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumno);	
		modelView.addObject("flag", false);
		modelView.addObject("listaMaterias", materiaService.mostrarMaterias());
		return modelView;
	}
	
	@GetMapping("/listadoAlumnos")
	public ModelAndView getFormListaAlumno() {
		
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());	
		
		return modelView;	
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@Valid @ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar, BindingResult resul) {
		ModelAndView modelView = new ModelAndView();
		if(resul.hasErrors()) {
			modelView.setViewName("formAlumno");
		}
		else {
			modelView.setViewName("listadoDeAlumnos");
			alumnoService.guardarAlumno(alumnoParaGuardar);
			modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());

		}
		/*
		 * try { alumnoService.guardarAlumno(alumnoParaGuardar) ; } catch (Exception e){
		 * 
		 * boolean errors = true; modelView.addObject("errors", errors);
		 * modelView.addObject("carga AlumnoErrorMessage", e.getMessage());
		 * System.out.println(e.getMessage()); }
		 */
		
		/*
		 * if(resultado.hasErrors()) { modelView=new ModelAndView ("formAlumno"); } else
		 * { alumnoService.guardarAlumno(alumnoParaGuardar); //mostrar el listado De
		 * Alumnos modelView.setViewName("listadoDeAlumnos");
		 * modelView.addObject("listaDOAlumnos", alumnoService.mostrarAlumnos()); }
		 */
		
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