package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapDTO;

import ar.edu.unju.fi.repository.DocenteRespository;
import ar.edu.unju.fi.service.DocenteService;
@Service
public class DocenteServiceImp implements DocenteService {
	@Autowired
	DocenteRespository docenteReposiroty;
	@Autowired
	DocenteMapDTO docenteMapDTO;

	@Override
	public void guardarDocente(DocenteDTO docenteDTO) {
		// TODO Auto-generated method stub
		if(!docenteReposiroty.existsById(docenteDTO.getLegajo())) {
			//alumnodDTO.setEstado(true);
			docenteReposiroty.save(
			docenteMapDTO.convertirDocenteDTOADocente(docenteDTO));
		}
		
	}

	@Override
	public List<DocenteDTO> mostrarDocentes() {
		// TODO Auto-generated method stub
		return  docenteMapDTO.convertirListaDocentesAListaDocentesDTO(docenteReposiroty.findDocenteByEstado(true)); 
	}

	@Override
	public void borrarDocente(String lu) {
		// TODO Auto-generated method stub
		List<DocenteDTO> docenteDTO = docenteMapDTO.convertirListaDocentesAListaDocentesDTO(docenteReposiroty.findAll());
		docenteDTO.forEach(ddto -> {
			if(ddto.getLegajo().equals(lu)) {
				ddto.setEstado(false);
				docenteReposiroty.save(docenteMapDTO.convertirDocenteDTOADocente(ddto));
			}
		});
		
	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTOModificado) {
		// TODO Auto-generated method stub
		docenteReposiroty.save(docenteMapDTO.convertirDocenteDTOADocente(docenteDTOModificado));
	}

	@Override
	public DocenteDTO buscarDocente(String lu) {
		// TODO Auto-generated method stub
		return null;
	}

}
