package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Component
@Data
@Entity
public class Alumno {
	 
	@Id
	private String lu;
	private String dni;
	
	@Size(min=3,max=30,message="Ingrese su nombre, mas de 3 caracteres")
	private String nombre;
	
	private String apellido;
	
	private String email;
	private String telefono;

	private String fec_nac;
	private String domicilio;
	private boolean estado;
	
}
