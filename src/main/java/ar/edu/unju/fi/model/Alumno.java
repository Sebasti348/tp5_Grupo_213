package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class Alumno {
private String lu;
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String fec_nac;
	private String domicilio;
	private Boolean estado;

}
