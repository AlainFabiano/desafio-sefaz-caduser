package com.desafiocaduser.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafiocaduser.api.utils.SenhaUtils;

@SpringBootApplication
public class DesafioCadUserSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCadUserSecurityApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded : " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded novamente : " + senhaEncoded);
			
			System.out.println("Senha válida : " + SenhaUtils.senhaValida("123456", senhaEncoded));
		};
	}

}
