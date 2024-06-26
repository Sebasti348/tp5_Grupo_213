package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;

@Service
public interface MateriaService {
	
	public void guardarMateria(MateriaDTO materiaDTO);
	public List<MateriaDTO> mostrarMaterias();
	public void borrarMateria (String codigo);
	public void modificarMateria (MateriaDTO materia);
	public MateriaDTO buscarMateria(String codigo);
}