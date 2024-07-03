package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.DocenteService;
@Controller
public class DocenteController {
		@Autowired
		Docente docente;
		@Autowired
		DocenteService docenteService;
		@GetMapping("/formularioDocente")
		public ModelAndView getFormDocente() {
			ModelAndView modelView = new ModelAndView("formDocente");
			modelView.addObject("nuevoDocente", docente);	
			modelView.addObject("flag", false);
			return modelView;
		}
		@GetMapping("/listadoDocentes")
		public ModelAndView getFormListaDocente() {
			ModelAndView modelView = new ModelAndView("listaDeDocentes");
			modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());	
			return modelView;	
		}
		@PostMapping("/guardarDocente")
		public ModelAndView saveDocente( @ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {
			ModelAndView modelView = new ModelAndView("listaDeDocentes");
			//guardar Docente
			docenteService.guardarDocente(docenteParaGuardar);
			modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());
			return modelView;	
		}
		@GetMapping("/modificarDocente/{legajo}")
		public ModelAndView getFormModificarDocente(@PathVariable(name = "legajo") String legajo) {
			// buscar Docente
			DocenteDTO docente = docenteService.buscarDocente(legajo);
			// mostrar el nuevo formulario
			ModelAndView modelView = new ModelAndView("formDocente");
			modelView.addObject("nuevoDocente", docente);
			modelView.addObject("flag", true);
			return modelView;
		}
		@PostMapping("/modificarDocente")	
		public ModelAndView updateDocenteByName(@ModelAttribute("nuevoDocente") DocenteDTO docenteModificado) {
			// guardar
			docenteService.modificarDocente(docenteModificado);
			// mostrar el listado de Docente
			ModelAndView modelView = new ModelAndView("listaDeDocentes");
			modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());
			return modelView;
		} 
		@GetMapping("/borrarDocente/{legajo}")
		public ModelAndView deleteDocenteDelListado(@PathVariable (name="legajo") String legajo) {
			//borrar
			docenteService.borrarDocente(legajo);
			//mostrar nueva lista de Docente
			ModelAndView modelView = new ModelAndView("listaDeDocentes");
			modelView.addObject("listadoDocentes",docenteService.mostrarDocentes());
			 return modelView;
		}
	}