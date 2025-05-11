package mx.edu.unpa.agenciaviajes2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.agenciaviajes2.domain.Paquete;
import mx.edu.unpa.agenciaviajes2.repository.PaqueteRepository;

@Service
public class PaqueteServiceImpl implements PaqueteService{
	
	@Autowired
	private PaqueteRepository paqueteRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Paquete> findAll() {
		// TODO Auto-generated method stub
		return paqueteRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Paquete> findById(String id) {
		// TODO Auto-generated method stub
		return paqueteRepository.findById(id);
	}

	@Override
	@Transactional
	public Paquete save(Paquete paquete) {
		// TODO Auto-generated method stub
		return paqueteRepository.save(paquete);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		paqueteRepository.deleteById(id);
	}

}

