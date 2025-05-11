package mx.edu.unpa.agenciaviajes4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.unpa.agenciaviajes4.domain.Reserva;
import mx.edu.unpa.agenciaviajes4.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Reserva> findAll() {
		// TODO Auto-generated method stub
		return reservaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Reserva> findById(String id) {
		// TODO Auto-generated method stub
		return reservaRepository.findById(id);
	}

	@Override
	@Transactional
	public Reserva save(Reserva reserva) {
		// TODO Auto-generated method stub
		return reservaRepository.save(reserva);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		reservaRepository.deleteById(id);
	}


}
