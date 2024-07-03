package ar.edu.unju.fi.dto;


import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class AlumnoDTO {
	private String lu;
	private String nombre;
	private String apellido;
	private String email;
	private boolean estado;
}
