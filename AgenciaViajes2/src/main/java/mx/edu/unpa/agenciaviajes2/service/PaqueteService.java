package mx.edu.unpa.agenciaviajes2.service;

import java.util.Optional;

import mx.edu.unpa.agenciaviajes2.domain.Paquete;


public interface PaqueteService {
	public Iterable<Paquete> findAll();
	public Optional<Paquete> findById(String id);
	public Paquete save(Paquete paquete);
	public void deleteById(String id);
	
}
