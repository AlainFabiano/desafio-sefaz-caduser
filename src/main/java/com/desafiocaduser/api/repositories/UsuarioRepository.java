package com.desafiocaduser.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafiocaduser.api.entities.*;

public interface UsuarioRepository extends JpaRepository<CadUsuario, Long> {
	
	CadUsuario findByNome(String nome);
	CadUsuario findByID(String ID);
}
