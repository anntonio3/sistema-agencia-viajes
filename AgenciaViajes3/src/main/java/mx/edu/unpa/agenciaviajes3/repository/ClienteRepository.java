package mx.edu.unpa.agenciaviajes3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.unpa.agenciaviajes3.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
