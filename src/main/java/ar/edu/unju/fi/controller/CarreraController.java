package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.service.CarreraService;
import ar.edu.unju.fi.dto.CarreraDTO;


@Controller
public class CarreraController {
	@Autowired
	CarreraDTO nuevaCarreraDTO;
	
	@Autowired
	CarreraService carreraService;

	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", nuevaCarreraDTO);	
		modelView.addObject("flag", false);
		return modelView;
	}

	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carreraParaGuardar)  {

		// guardar
		// ListadoCarreras.agregarCarrera(carreraParaGuardar);
		carreraService.guardarCarrera(carreraParaGuardar);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		// modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());
		//carreraService.mostrarCarreras();
		return modelView;
	}

	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable(name = "codigo") String codigo) {
		// borrar
		// ListadoCarreras.eliminarCarrera(codigo);
		carreraService.borrarCarrera(codigo);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		// modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());	
		return modelView;
	}

	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView getFormModificarCarrera(@PathVariable(name = "codigo") String codigo) {
		// buscar
		// Carrera carreraParaModificar = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		CarreraDTO carrera = carreraService.buscarCarrera(codigo);
		// mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carrera);
		modelView.addObject("flag", true);
		return modelView;
	}

	@PostMapping("/modificarCarrera")	
	public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carreraModificada) {

		// guardar
		//ListadoCarreras.modificarCarrera(carreraModificada);
		carreraService.modificarCarrera(carreraModificada);
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());

		return modelView;
	}
	
    @GetMapping("/listadoCarreras")
    public ModelAndView showCarreras() {
        // mostrar el listado
        ModelAndView modelView = new ModelAndView("listaDeCarreras");
        modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());
        return modelView;
    
}


}