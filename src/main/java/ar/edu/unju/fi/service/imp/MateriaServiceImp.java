package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;

@Service
public class MateriaServiceImp implements MateriaService{
	
	@Autowired
	MateriaRepository materiaRepository;	
	
	@Autowired
	MateriaMapDTO materiaMapDto;
	
	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
			materiaRepository.save(materia);
	}

	@Override
	public List<MateriaDTO> mostrarMaterias() {
		// TODO Auto-generated method stub
		
		return materiaMapDto.convertirListaMateriaAListaMateriaDTO(materiaRepository.findMateriasByEstado(true));
	}

	@Override
	public void borrarMateria(String codigo) {
		List<Materia> materias = materiaRepository.findAll();
		materias.forEach(materia -> {
			if(materia.getCodigo().equals(codigo)) {
				materia.setEstado(false);
				materiaRepository.save(materia);
			}
		});
	}

	@Override
	public Materia buscarMateria(String codigo) { 
		// TODO Auto-generated method stub
		List<Materia> todasLasMaterias = materiaRepository.findAll();
		for (Materia materias : todasLasMaterias) {
			if(materias.getCodigo().equals(codigo)) {
				return materias;
			}
		}
		return null;
	}

	@Override
	public void modificarMateria(Materia materia) {
		// TODO Auto-generated method stub
		materiaRepository.save(materia);
	}

}