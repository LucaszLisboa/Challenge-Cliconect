package com.lucas.cliconect.repository;

import com.lucas.cliconect.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    

}
