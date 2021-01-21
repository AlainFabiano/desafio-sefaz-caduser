package com.desafiocaduser.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.desafiocaduser.api.DTOs.CadUsuarioDto;


@RestController
@RequestMapping("/api/cadUsuario")
public class CadUsuariosController {

	@GetMapping(value = "/{nome}")
	public String nome(@PathVariable("nome") String nome) {
		 return "Olá " + nome;
	}
	
	@PostMapping
	public ResponseEntity<CadUsuarioDto> cadastrar(@RequestBody CadUsuarioDto cadUsuarioDto) {
		cadUsuarioDto.setNome("");
		return ResponseEntity.ok(cadUsuarioDto);
	}
	
	@PostMapping
	public ResponseEntity<Response<CadUsuarioDto>> cadastrar(@Valid @RequestBody CadUsuarioDto empresaDto,
			BindingResult result) {
		Response<CadUsuarioDto> response = new Response<CadUsuarioDto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		cadUsuarioDto.setNome("");
		response.setData(cadUsuarioDto);
		
		return ResponseEntity.ok(response);
	}
	
}
