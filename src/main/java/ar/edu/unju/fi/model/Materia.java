package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity

public class Materia {
	@Id
	private String codigo;
	private String nombre;
	private String curso;
	private String cantidadHoras;
	private Modalidad modalidad;
	private String docente;
	private String carrera;
	private Boolean estado;
}
