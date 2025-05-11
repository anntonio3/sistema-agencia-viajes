package mx.edu.unpa.agenciaviajes4.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_reserva")
public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "cliente_id")
	private String cliente_id;
	
	@Column(name = "paquete_id")
	private String paquete_id;
	
	@Column(name = "fecha_reserva")
	private String fecha_reserva;
	
	@Column(name = "estado")
	private String estado;
}
