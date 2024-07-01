package ar.edu.unju.fi.model;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Component
@Data
@Entity
public class Alumno {
	
	@Id
	private String lu;
	private String dni;
	@NotBlank(message="No deje este campo vacio, ingresa tu nombre/s")
	private String nombre;
	@NotBlank(message="No deje este campo vacio, ingresa tu apellido/s")

	private String apellido;
	private String email;
	private String telefono;
	private String fec_nac;
	private String domicilio;
	private Boolean estado;
	
}
