package mx.edu.unpa.agenciaviajes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.agenciaviajes.domain.Destino;
import mx.edu.unpa.agenciaviajes.repository.DestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService{
	
	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Destino> findAll() {
		// TODO Auto-generated method stub
		return destinoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Destino> findById(String id) {
		// TODO Auto-generated method stub
		return destinoRepository.findById(id);
	}

	@Override
	@Transactional
	public Destino save(Destino destino) {
		// TODO Auto-generated method stub
		return destinoRepository.save(destino);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		destinoRepository.deleteById(id);
	}

}
