package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;
@Service
public class AlumnoServiceImp implements AlumnoService {
	@Autowired
	Alumno alumno;
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	AlumnoMapDTO alumnoMapDTO;

	@Override
	public void guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.save(alumno);
	}
	
	@Override
	public List<AlumnoDTO> mostrarAlumnos() {
		return alumnoMapDTO.convertirListaAlumnosAListaAlumnosDTO(alumnoRepository.findAlumnoByEstado(true)); 	
		}
	
	@Override
	public void borrarAlumno(String lu) {
		List<AlumnoDTO> alumnosDTO = alumnoMapDTO.convertirListaAlumnosAListaAlumnosDTO(alumnoRepository.findAll());
		alumnosDTO.forEach(adto -> {
			if(adto.getLu().equals(lu)) {
				adto.setEstado(false);
				alumnoRepository.save(alumnoMapDTO.convertirAlumnoDTOAAlumno(adto));
			}
		});
	}

	



	@Override
	public AlumnoDTO buscarAlumno(String lu) {
		// TODO Auto-generated method stub
		List<AlumnoDTO> fullAlumnos =alumnoMapDTO.convertirListaAlumnosAListaAlumnosDTO(alumnoRepository.findAll());
		for (AlumnoDTO alumno : fullAlumnos) {
			if(alumno.getLu().equals(lu)) {
				return alumno;
			}
		}
		return null;
	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnoDTOModificado) {
		/*
		 * int i=0; List<Alumno> alumnos = alumnoRepository.findAll(); for (Alumno
		 * alumno : alumnos) { if (alumno.getDni().equals(alumnoModificado.getDni())) {
		 * 
		 * } i++; }
		 */
		// TODO Auto-generated method stub
		alumnoRepository.save(alumnoMapDTO.convertirAlumnoDTOAAlumno(alumnoDTOModificado));
	}


}
