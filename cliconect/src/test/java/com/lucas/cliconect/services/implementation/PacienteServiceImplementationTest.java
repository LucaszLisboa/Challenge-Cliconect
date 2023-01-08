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
    public void testExibirPacientes() {
        List<Paciente> pacientes = pacienteServiceImplementation.exibirPacientes();
        System.out.println(pacientes);
    }


    @Test
    public void testExibirPacienteById() {
        Paciente paciente = pacienteServiceImplementation.exibirPacienteById(1L);
        System.out.println(paciente);
    }

    @Test
    public void testDeletePaciente() {
        pacienteServiceImplementation.deletePaciente(1L);
        Optional<Paciente> optinalPaciente = pacienteRepository.findById(1L);
        assertFalse(optinalPaciente.isPresent());

    }

}
