package mx.edu.unpa.agenciaviajes.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_destino")
public class Destino implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "pais")
	private String pais;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio_base")
	private String precio_base;
}
