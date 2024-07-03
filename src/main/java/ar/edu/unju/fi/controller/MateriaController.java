package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.service.MateriaService;
import ar.edu.unju.fi.dto.MateriaDTO;


@Controller
public class MateriaController {
	@Autowired
	MateriaDTO nuevaMateriaDTO;
	
	@Autowired
	MateriaService materiaService;

	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateriaDTO);	
		modelView.addObject("flag", false);
		return modelView;
	}

	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaParaGuardar)  {

		// guardar
		// ListadoMaterias.agregarMateria(materiaParaGuardar);
		materiaService.guardarMateria(materiaParaGuardar);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		// modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());
		modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
		//materiaService.mostrarMaterias();
		return modelView;
	}

	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name = "codigo") String codigo) {
		// borrar
		// ListadoMaterias.eliminarMateria(codigo);
		materiaService.borrarMateria(codigo);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		// modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());
		modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());	
		return modelView;
	}

	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView getFormModificarMateria(@PathVariable(name = "codigo") String codigo) {
		// buscar
		// Materia materiaParaModificar = ListadoMaterias.buscarMateriaPorCodigo(codigo);
		MateriaDTO materia = materiaService.buscarMateria(codigo);
		// mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materia);
		modelView.addObject("flag", true);
		return modelView;
	}

	@PostMapping("/modificarMateria")	
	public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaModificada) {

		// guardar
		//ListadoMaterias.modificarMateria(materiaModificada);
		materiaService.modificarMateria(materiaModificada);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());

		return modelView;
	}
	
    @GetMapping("/listadoMaterias")
    public ModelAndView showMaterias() {
        // mostrar el listado
        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    
}


}
