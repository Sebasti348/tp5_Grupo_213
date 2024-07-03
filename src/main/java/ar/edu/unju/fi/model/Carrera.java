package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="carreras")
public class Carrera {
	
	@Id
	private String codigo;
	private String nombre;
	private int cantidadAños;
	private boolean estado;
}