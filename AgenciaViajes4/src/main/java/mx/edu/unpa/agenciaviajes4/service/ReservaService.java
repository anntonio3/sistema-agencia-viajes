package mx.edu.unpa.agenciaviajes4.service;

import java.util.Optional;

import mx.edu.unpa.agenciaviajes4.domain.Reserva;

public interface ReservaService {
	public Iterable<Reserva> findAll();
	public Optional<Reserva> findById(String id);
	public Reserva save(Reserva reserva);
	public void deleteById(String id);
	
}
