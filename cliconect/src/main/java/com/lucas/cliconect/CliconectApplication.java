package com.lucas.cliconect;

import com.lucas.cliconect.models.Paciente;
import com.lucas.cliconect.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CliconectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliconectApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PacienteRepository pacienteRepository) {
		return args -> {
			pacienteRepository.deleteAll();

			Paciente paciente = new Paciente();
			paciente.setNome("Lucas");
			paciente.setSexo("Masculino");
			paciente.setCpf("12345678910");
			paciente.setEmail("lucas@gmail.com");
			paciente.setCelular("43996543211");
			paciente.setDataNascimento("1998-05-13");
			paciente.setInformacoesAtendimento("Paciente com dor de cabeça");
			paciente.setRua("Rua das Flores");
			paciente.setNumero("123");
			paciente.setBairro("Centro");
			paciente.setCidade("Cascavel");
			paciente.setEstado("PR");
			pacienteRepository.save(paciente);

			Paciente paciente2 = new Paciente();
			paciente2.setNome("Yuri");
			paciente2.setSexo("Masculino");
			paciente2.setCpf("14725836910");
			paciente2.setEmail("yuri@gmail.com");
			paciente2.setCelular("43987412547");
			paciente2.setDataNascimento("1999-10-20");
			paciente2.setInformacoesAtendimento("Paciente com dor nas costas");
			paciente2.setRua("Rua das Arvores");
			paciente2.setNumero("654");
			paciente2.setBairro("Centro");
			paciente2.setCidade("Londrina");
			paciente2.setEstado("PR");
			pacienteRepository.save(paciente2);

		};
	}

}
