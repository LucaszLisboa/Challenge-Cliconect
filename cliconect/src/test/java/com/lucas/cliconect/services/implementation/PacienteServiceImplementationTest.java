package com.lucas.cliconect.services.implementation;

import com.lucas.cliconect.models.Paciente;
import com.lucas.cliconect.repository.PacienteRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration

public class PacienteServiceImplementationTest {

    @Autowired
    private PacienteServiceImplementation pacienteServiceImplementation;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void testSalvarCadastro(){
        Paciente paciente = new Paciente();
        paciente.setNome("Carlos");
        paciente.setSexo("Masculino");
        paciente.setCpf("98765432199");
        paciente.setEmail("carlos@gmail.com");
        paciente.setCelular("43996543211");
        paciente.setDataNascimento("10/05/2000");
        paciente.setInformacoesAtendimento("Paciente com dor de barriga");
        paciente.setRua("Rua das Pedras");
        paciente.setNumero("321");
        paciente.setBairro("Centro");
        paciente.setCidade("Londrina");
        paciente.setEstado("PR");
        pacienteServiceImplementation.salvarCadastro(paciente);
        assertEquals("Carlos", paciente.getNome());
        assertEquals("98765432199", paciente.getCpf());

    }

    @Test
    public void testExibirPacientes() {
        List<Paciente> pacientes = pacienteServiceImplementation.exibirPacientes();
        assertEquals(2, pacientes.size());

    }


    @Test
    public void testExibirPacienteById() {
        Paciente paciente = pacienteServiceImplementation.exibirPacienteById(1L);
        assertEquals("1", String.valueOf(paciente.getId()));
        assertEquals("Lucas", paciente.getNome());
        assertEquals("Masculino", paciente.getSexo());
        assertEquals("12345678910", paciente.getCpf());
        assertEquals("43996543211", paciente.getCelular());
        assertEquals("20/10/1998", paciente.getDataNascimento());
        assertEquals("lucas@gmail.com", paciente.getEmail());
        assertEquals("Rua das Flores", paciente.getRua());
        assertEquals("123", paciente.getNumero());
        assertEquals("Centro", paciente.getBairro());
        assertEquals("Cascavel", paciente.getCidade());
        assertEquals("PR", paciente.getEstado());
        assertEquals("Paciente com dor de cabeça", paciente.getInformacoesAtendimento());
    }

    @Test
    public void testUpdatePaciente(){
        Optional<Paciente> paciente = pacienteRepository.findById(2L);
        paciente.get().setNome("Yuri Santos");
        paciente.get().setInformacoesAtendimento("Paciente com dor no corpo");
        pacienteServiceImplementation.updatePaciente(paciente.get().getId(), paciente.get());
        assertEquals("Yuri Santos", paciente.get().getNome());
        assertEquals("Paciente com dor no corpo", paciente.get().getInformacoesAtendimento());
    }


    @Test
    public void testDeletePaciente() {
        pacienteServiceImplementation.deletePaciente(1L);
        Optional<Paciente> optinalPaciente = pacienteRepository.findById(1L);
        assertFalse(optinalPaciente.isPresent());

    }
}
