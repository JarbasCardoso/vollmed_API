package br.com.sistema.api.model.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository  extends JpaRepository <Medico, Integer> {
    
    
}
