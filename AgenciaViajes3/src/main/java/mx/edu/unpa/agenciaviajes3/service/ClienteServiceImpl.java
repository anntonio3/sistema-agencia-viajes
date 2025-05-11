package mx.edu.unpa.agenciaviajes3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.agenciaviajes3.domain.Cliente;
import mx.edu.unpa.agenciaviajes3.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> findById(String id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

}
