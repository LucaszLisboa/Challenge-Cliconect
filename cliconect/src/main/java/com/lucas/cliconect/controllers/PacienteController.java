package com.lucas.cliconect.controllers;

import com.lucas.cliconect.model.Paciente;
import com.lucas.cliconect.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable Long id) {
        return pacienteRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<String> createPaciente(@Valid @RequestBody Paciente paciente){
        pacienteRepository.save(paciente);
        return ResponseEntity.ok("Paciente cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        Paciente pacienteFound = pacienteRepository.findById(id).get();
        pacienteFound.setNome(paciente.getNome());
        pacienteFound.setSexo(paciente.getSexo());
        pacienteFound.setCpf(paciente.getCpf());
        pacienteFound.setCelular(paciente.getCelular());
        pacienteFound.setEmail(paciente.getEmail());
        pacienteFound.setDataNascimento(paciente.getDataNascimento());
        pacienteFound.setInformacoesAtendimento(paciente.getInformacoesAtendimento());
        return pacienteRepository.save(pacienteFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id){
        pacienteRepository.deleteById(id);
        return ResponseEntity.ok("Cadastro de paciente deletado com sucesso!");

    }
}
