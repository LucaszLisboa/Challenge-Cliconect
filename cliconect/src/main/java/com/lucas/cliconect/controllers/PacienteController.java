package com.lucas.cliconect.controllers;

import com.lucas.cliconect.models.Paciente;
import com.lucas.cliconect.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.exibirPacientes();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable Long id) {
        return pacienteService.exibirPacienteById(id);
    }

    @PostMapping
    public ResponseEntity<String> createPaciente(@Valid @RequestBody Paciente paciente){
        return pacienteService.salvarCadastro(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        return pacienteService.updatePaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id){
        return pacienteService.deletePaciente(id);
    }
}
