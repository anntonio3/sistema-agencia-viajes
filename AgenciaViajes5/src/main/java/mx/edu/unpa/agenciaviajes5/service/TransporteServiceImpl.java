package mx.edu.unpa.agenciaviajes5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.agenciaviajes5.domain.Transporte;
import mx.edu.unpa.agenciaviajes5.repository.TransporteRepository;

@Service
public class TransporteServiceImpl implements TransporteService{
	
	@Autowired
	private TransporteRepository transporteRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Transporte> findAll() {
		// TODO Auto-generated method stub
		return transporteRepository.findAll();
	}

	@Override
	@Transactional
	public Transporte save(Transporte transporte) {
		// TODO Auto-generated method stub
		return transporteRepository.save(transporte);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Transporte> findById(String id) {
		// TODO Auto-generated method stub
		return transporteRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		transporteRepository.deleteById(id);
	}

}
