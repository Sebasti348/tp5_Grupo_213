package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alumno> alumnos;
}
