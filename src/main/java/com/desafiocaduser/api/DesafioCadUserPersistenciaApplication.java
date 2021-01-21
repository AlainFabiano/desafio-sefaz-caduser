package com.desafiocaduser.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafiocaduser.api.entities.CadUsuario;
import com.desafiocaduser.api.repositories.UsuarioRepository;

@SpringBootApplication
public class DesafioCadUserPersistenciaApplication {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioCadUserPersistenciaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			CadUsuario cadusuario = new CadUsuario();
			cadusuario.setNome("Nome");
			cadusuario.setEmail("Email");

			this.usuarioRepository.save(cadusuario);

			List<CadUsuario> cadusuarios = usuarioRepository.findAll();
			cadusuarios.forEach(System.out::println);

			CadUsuario cadUsuario = usuarioRepository.findByID("");
			System.out.println("Usuario por ID: " + cadUsuario);

			cadUsuario.setNome("");
			this.usuarioRepository.save(cadUsuario);

			CadUsuario empresaCnpj = usuarioRepository.findByNome("");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);

			this.usuarioRepository.deleteById(1L);
			cadusuarios = usuarioRepository.findAll();
			System.out.println("Empresas: " + cadusuarios.size());

		};

	}

}
