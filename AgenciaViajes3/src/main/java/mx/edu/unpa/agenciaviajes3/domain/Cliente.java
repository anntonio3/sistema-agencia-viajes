package mx.edu.unpa.agenciaviajes3.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "direccion")
	private String direccion;
}

