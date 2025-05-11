package mx.edu.unpa.agenciaviajes5.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_transporte")
public class Transporte implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "capacidad")
	private String capacidad;
	
	@Column(name = "horario")
	private String horario;

}
