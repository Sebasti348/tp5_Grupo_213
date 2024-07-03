package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Modalidad;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class MateriaDTO {
	private String codigo;
	private String nombre;
	private String curso;
	private String cantidadHoras;
	private Docente docente;
	private String carrera;
	private Boolean estado;
}