package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Component
@Data
@Entity

public class Materia {
	@Id  

	@Column(name = "Materia_codigo")
	private String  codigo;

	@Column(name = "nombre" ,nullable = false)
	@Pattern(regexp = "[a-z A-Z]*", message = "Este campo solo debe contener Letras.")
	private String nombre;
	
	@Column(name = "curso" ,nullable = false)
	private String curso;
	
	@Column(name = "cantidadHoras" ,nullable = false)
	private String cantidadHoras;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "modalidad", nullable = false)
	private Modalidad modalidad;
	
	@Column(name = "carrera" ,nullable = false)
	private String carrera;
	
	@Column(name = "estado" ,nullable = false)
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name = "docente" ,referencedColumnName = "legajo" )
	private Docente docente;
		
	
	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alumno> alumnos;
}