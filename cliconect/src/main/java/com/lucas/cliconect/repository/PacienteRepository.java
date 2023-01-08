package com.lucas.cliconect.repository;

import com.lucas.cliconect.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByEmail(String email);
    Paciente findByCpf(String cpf);

}
