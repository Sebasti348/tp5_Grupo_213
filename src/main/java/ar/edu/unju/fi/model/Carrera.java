package ar.edu.unju.fi.model;
import java.util.List;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

@Component
@Entity
@Table(name="carrera")
public class Carrera {
	
	@Id
	private String codigo;
	private String nombre;
	private int cantidadAños;
	private boolean estado;
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Alumno> alumnos;
}