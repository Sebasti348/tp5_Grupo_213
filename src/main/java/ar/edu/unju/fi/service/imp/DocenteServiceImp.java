package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;
@Service
public class DocenteServiceImp implements DocenteService{
	@Autowired
	Docente docente;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	DocenteMapDTO docenteMapDTO;
	@Override
	public void guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		docenteRepository.save(docente);
	}
	@Override
	public void borrarDocente(String lu) {
		List<DocenteDTO> docentesDTO = docenteMapDTO.convertirListaDocentesAListaDocentesDTO(docenteRepository.findAll());
		docentesDTO.forEach(adto -> {
			if(adto.getLegajo().equals(lu)) {
				adto.setEstado(false);
				docenteRepository.save(docenteMapDTO.convertirDocenteDTOADocente(adto));
				}});
	}
	@Override
	public DocenteDTO buscarDocente(String legajo) {
		// TODO Auto-generated method stub
		List<DocenteDTO> fullDocentes =docenteMapDTO.convertirListaDocentesAListaDocentesDTO(docenteRepository.findAll());
		for (DocenteDTO docente : fullDocentes) {
			if(docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}
	@Override
	public void modificarDocente(DocenteDTO docenteDTOModificado) {
		// TODO Auto-generated method stub
		docenteRepository.save(docenteMapDTO.convertirDocenteDTOADocente(docenteDTOModificado));
	}
	@Override
	public List<DocenteDTO> mostrarDocentes() {
		// TODO Auto-generated method stub
			return docenteMapDTO.convertirListaDocentesAListaDocentesDTO(docenteRepository.findDocenteByEstado(true)); 	
	}
}
