package mx.edu.unpa.agenciaviajes3.service;

import java.util.Optional;

import mx.edu.unpa.agenciaviajes3.domain.Cliente;

public interface ClienteService {
	public Iterable<Cliente> findAll();
	public Optional<Cliente> findById(String id);
	public Cliente save(Cliente cliente);
	public void deleteById(String id);
	
}
