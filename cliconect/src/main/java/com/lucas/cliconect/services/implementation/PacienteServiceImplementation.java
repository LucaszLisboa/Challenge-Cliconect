package com.lucas.cliconect.services.implementation;

import com.lucas.cliconect.models.Paciente;
import com.lucas.cliconect.repository.PacienteRepository;
import com.lucas.cliconect.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImplementation implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public ResponseEntity<String> salvarCadastro (Paciente paciente){
        Paciente pacienteEmail = pacienteRepository.findByEmail(paciente.getEmail());
        Paciente pacienteCpf = pacienteRepository.findByCpf(paciente.getCpf());

        if (pacienteCpf != null) {
            return ResponseEntity.badRequest().body("CPF já cadastrado!");
        } else if (pacienteEmail != null) {
            return ResponseEntity.badRequest().body("Email já cadastrado!");
        } else {
            pacienteRepository.save(paciente);
            return ResponseEntity.ok("Paciente cadastrado com sucesso!");
        }
    }

    @Override
    public List<Paciente> exibirPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente exibirPacienteById(Long id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<String> updatePaciente(Long id, Paciente paciente) {
        Paciente pacienteFound = pacienteRepository.findById(id).get();
        pacienteFound.setNome(paciente.getNome());
        pacienteFound.setSexo(paciente.getSexo());
        pacienteFound.setCpf(paciente.getCpf());
        pacienteFound.setCelular(paciente.getCelular());
        pacienteFound.setEmail(paciente.getEmail());
        pacienteFound.setDataNascimento(paciente.getDataNascimento());
        pacienteFound.setInformacoesAtendimento(paciente.getInformacoesAtendimento());
        pacienteFound.setRua(paciente.getRua());
        pacienteFound.setNumero(paciente.getNumero());
        pacienteFound.setBairro(paciente.getBairro());
        pacienteFound.setCidade(paciente.getCidade());
        pacienteFound.setEstado(paciente.getEstado());
        pacienteRepository.save(pacienteFound);
        return ResponseEntity.ok("Cadastro de paciente atualizado com sucesso!");
    }

    @Override
    public ResponseEntity<String> deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
        return ResponseEntity.ok("Cadastro de paciente deletado com sucesso!");
    }
}
