package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	@Autowired	  
	Alumno nuevoAlumno = new Alumno();

	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formAlumno.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		
		return modelView;
	}
	
	@GetMapping("/listadoAlumnos")
	public ModelAndView getFormListaAlumnos() {
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());
		return modelView;
	}
	

	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno( @ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {

			//guardar
		ListadoAlumnos.agregarAlumno(alumnoParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
	
		return modelView;		
	}
	
	
	@GetMapping("/eliminarAlumno/{lu}")
	public ModelAndView deleteAlumnoDelListado(@PathVariable (name="lu") int lu) {
		
		//borrar
		ListadoAlumnos.eliminarAlumno(lu);
		
		//mostrar nueva lista de alumnos
		ModelAndView modelView = new ModelAndView("listadoDeAlumno");
		modelView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnos());
		
		 return modelView;
	}
	  
	@GetMapping("/modificarAlumno/{lu}")
	public ModelAndView getFormAlumnoCarrera(@PathVariable(name="lu") int lu) {
		Alumno alumno = ListadoAlumnos.buscarAlumnoPorLu(lu);
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumno); 
		modelView.addObject("flag", true);
		return modelView;
		
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView modifcarAlumno (@ModelAttribute("nuevoAlumno")Alumno alumnoModificado) {
		ListadoAlumnos.modificarAlumno(alumnoModificado);
		ModelAndView modelView =new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());
		return modelView;
	}
	

}
