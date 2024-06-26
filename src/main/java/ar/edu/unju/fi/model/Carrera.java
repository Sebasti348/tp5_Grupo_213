package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity

public class Carrera {
	@Id
	private String codigo;
	private String nombre;
	private String cantidadHoras;
	private Boolean estado;
}
