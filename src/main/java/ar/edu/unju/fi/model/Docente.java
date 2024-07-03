package ar.edu.unju.fi.model;



import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Component
@Data
@Entity

public class Docente {
    @Id
    @Column(name = "legajo")
    private String  legajo;
    
    @Column(name = "nombre", nullable = false)
    @Pattern(regexp = "[a-z A-Z]*", message = "Este campo solo debe contener Letras.")
    private String nombre;
    
    @Column(name = "apellido", nullable = false)
    private String apellido;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "estado", nullable = false)
    private boolean estado;
}