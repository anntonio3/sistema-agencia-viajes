package mx.edu.unpa.agenciaviajes.service;

import java.util.Optional;

import mx.edu.unpa.agenciaviajes.domain.Destino;

public interface DestinoService {
	public Iterable<Destino> findAll();
	public Optional<Destino> findById(String id);
	public Destino save(Destino destino);
	public void deleteById(String id);
	
}
