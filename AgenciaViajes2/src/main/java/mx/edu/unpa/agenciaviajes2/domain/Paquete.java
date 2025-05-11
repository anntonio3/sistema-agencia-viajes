package mx.edu.unpa.agenciaviajes2.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_paquete")
public class Paquete implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "destino_id")
	private String destino_id;
	
	@Column(name = "duracion_dias")
	private String duracion_dias;
	
	@Column(name = "precio")
	private String precio;
}
