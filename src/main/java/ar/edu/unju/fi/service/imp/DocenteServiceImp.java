package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.mapper.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.DocenteService;
@Service
public class DocenteServiceImp implements DocenteService {
	@Autowired
	DocenteRepository docenteRepository; 
	@Autowired
	DocenteMapDTO docenteMapDTO;

	@Override
	public void guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		//alumnodDTO.setEstado(true);
			docenteRepository.save(docente);
		
	}

	@Override
	public List<DocenteDTO> mostrarDocentes() {
		// TODO Auto-generated method stub
		return  docenteMapDTO.convertirListaDocentesAListaDocentesDTO(docenteRepository.findDocenteByEstado(true)); 
	}

	@Override
	public void borrarDocente(String lu) {
		// TODO Auto-generated method stub
		List<Docente> docenteDTO = docenteRepository.findAll();
		docenteDTO.forEach(ddto -> {
			if(ddto.getLegajo().equals(lu)) {
				ddto.setEstado(false);
				docenteRepository.save(ddto);
			}
		});
		
	}

	@Override
	public void modificarDocente(Docente docenteDTOModificado) {
		// TODO Auto-generated method stub
		docenteRepository.save(docenteDTOModificado);
	}

	@Override
	public Docente buscarDocente(String lu) {
		// TODO Auto-generated method stub
		List<Docente> fullDocentes =docenteRepository.findAll();
		for (Docente docentes : fullDocentes) {
			if(docentes.getLegajo().equals(lu)) {
				return docentes;
			}
		}
		return null;
	}

} 
