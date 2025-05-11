package mx.edu.unpa.agenciaviajes5.service;

import java.util.Optional;

import mx.edu.unpa.agenciaviajes5.domain.Transporte;

public interface TransporteService {
	
	public Iterable<Transporte> findAll();
	public Transporte save(Transporte transporte);
	public Optional<Transporte> findById(String id);
	public void deleteById(String id);
}
