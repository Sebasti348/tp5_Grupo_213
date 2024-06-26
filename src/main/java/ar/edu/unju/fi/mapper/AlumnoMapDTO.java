package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface AlumnoMapDTO {
	
	@Mapping(source="lu", target="lu")
	@Mapping(source="dni", target="dni")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")	
	@Mapping(source="email", target="email")
	@Mapping(source="telefono", target="telefono")
	@Mapping(source="fec_nac", target="fec_nac")
	@Mapping(source="domicilio", target="domicilio")
	@Mapping(source="estado", target="estado")
	@Mapping(source="materias", target="materias")
	 
		AlumnoDTO convertirAlumnoAAlumnoDTO(Alumno a);
	@InheritConfiguration	
		Alumno convertirAlumnoDTOAAlumno(AlumnoDTO adto);
	
	List<AlumnoDTO> convertirListaAlumnosAListaAlumnosDTO (List<Alumno> listaA);
	List<Alumno> convertirListaAlumnosDTOAListaAlumnos (List<AlumnoDTO> listaADTO);
	
}
