package com.lucas.cliconect.services;

import com.lucas.cliconect.models.Paciente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PacienteService {

    ResponseEntity<String> salvarCadastro(Paciente paciente);
    List<Paciente> exibirPacientes();
    Paciente exibirPacienteById(Long id);
    ResponseEntity<String> updatePaciente(Long id, Paciente paciente);
    ResponseEntity<String> deletePaciente(Long id);

}
