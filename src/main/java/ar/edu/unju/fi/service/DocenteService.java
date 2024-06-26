package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;

@Service
public interface DocenteService {
	
	public void guardarDocente(DocenteDTO  docenteDTO);
	public List<DocenteDTO> mostrarDocentes();
	public void borrarDocente(String lu);
	public void modificarDocente(DocenteDTO docenteDTOModificado);
	public DocenteDTO buscarDocente(String lu);
}