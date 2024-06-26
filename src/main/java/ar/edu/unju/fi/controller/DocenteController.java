package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;

@Controller
 
public class DocenteController {
	@Autowired
	DocenteDTO nuevoDocenteDTO;
	@Autowired
	DocenteService docenteService;
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//agrega el objeto
		
		modelView.addObject("nuevoDocente", nuevoDocenteDTO);
		modelView.addObject("flag", false);
		return modelView;
	}

	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente( @ModelAttribute("nuevoDocente") DocenteDTO docenteParaGuardar) {
		
		//guardar 
		docenteService.guardarDocente(docenteParaGuardar);
		//ListadoDocentes.agregarDocente(docenteParaGuardar);
		//mostrar el listado
		ModelAndView modelView 	= new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());	
	
		return modelView;		
	}
	@GetMapping("/listaDocentes")
	public ModelAndView getFormListaDocentes(){
		//vista listadoDeDocentes.html
		
		
		ModelAndView modelView= new  ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());
		return modelView;
	}
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable (name="legajo") String legajo) {
		
		//borrar
		docenteService.borrarDocente(legajo);
		
		//mostrar nueva lista de docentes
		ModelAndView modelView = new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes",docenteService.mostrarDocentes());
		
		 return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView getFormModificarDocente(@PathVariable(name = "legajo") String legajo) {
		// buscar
		// Docente docenteParaModificar = ListadoDocentes.buscarDocentePorLegajo(legajo);
		DocenteDTO docente = docenteService.buscarDocente(legajo);
		// mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docente);
		modelView.addObject("flag", true);
		return modelView;
	}

	@PostMapping("/modificarDocente")	
	public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteModificado) {

		// guardar
		//ListadoDocentes.modificarDocente(docenteModificada);
		docenteService.modificarDocente(docenteModificado);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listadoDeDocentes");
		modelView.addObject("listaDocentes", docenteService.mostrarDocentes());

		return modelView;
	}
	
	
		
}
