package com.ong.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ong.backend.dto.MensagemResponse;
import com.ong.backend.dto.VoluntarioDTO;
import com.ong.backend.entities.Voluntario;
import com.ong.backend.services.VoluntarioService;

@RestController
@RequestMapping(value = "voluntario")
public class VoluntarioController {

	@Autowired
	VoluntarioService voluntarioService;
	
	@PostMapping(value = "/tornar")
	public ResponseEntity<Voluntario> tornarVoluntario(@RequestBody VoluntarioDTO dto){
		return voluntarioService.tornarVoluntario(dto);
	}

	@GetMapping(value = "/listar")
	public List<Voluntario> listarVoluntarios(){
		return voluntarioService.listar();
	}
	
	@GetMapping(value = "/listar/aprovados")
	public List<Voluntario> listarVoluntariosAprovados(){
		return voluntarioService.listarAprovados();
	}

	@DeleteMapping(value = "cancelar/{id}")
	public ResponseEntity<MensagemResponse> cancelar (@PathVariable Long id){
		return voluntarioService.cancelar(id);
	}
	
	// Parte de validação
	@PutMapping("aprovar/{id}")
    public ResponseEntity<Voluntario> aprovar(@PathVariable Long id) {
        return voluntarioService.aprovarVoluntario(id);
    }
    @DeleteMapping("negar/{id}")
    public ResponseEntity<MensagemResponse> negarBlog(@PathVariable Long id){
    	return voluntarioService.negarVoluntario(id);
    }
}
