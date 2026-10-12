package br.com.sistema.api.model.medico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findByNomeContainingIgnoreCase(String nome);
}
