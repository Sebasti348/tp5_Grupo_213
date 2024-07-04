package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Component
@Data
@Entity
public class Alumno {
	@Id
	private String lu;
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String fec_nac;
	private String domicilio;
	private Boolean estado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_cod")
	private Carrera carrera;
}
