package com.ong.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ong.backend.dto.NotificacaoUsuarioDTO;
import com.ong.backend.entities.NotificacaoUsuario;
import com.ong.backend.services.NotificacaoUsuarioService;

@RestController
@RequestMapping(value = "notificarUsuario/")
public class NotificacaoUsuarioController {

	@Autowired
	NotificacaoUsuarioService notificacaoUsuarioService;
	
	@PostMapping(value = "notificar")
	public ResponseEntity<NotificacaoUsuario> notificarUsuario(@RequestBody NotificacaoUsuarioDTO dto){
		return notificacaoUsuarioService.notificar(dto);
	}
	
	@GetMapping(value = "/listar/usuario/{id}")
	public List<NotificacaoUsuario> listarPorUsuario(Long id){
		return notificacaoUsuarioService.listarPorUsuario(id);
	}
}
