package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;
@Service
public interface AlumnoService {
	public void guardarAlumno(Alumno alumno);
	public List<AlumnoDTO> mostrarAlumnos();
	public void borrarAlumno(String lu);
	public void modificarAlumno(Alumno alumnoModificado);
	public Alumno buscarAlumno(String lu);
}
