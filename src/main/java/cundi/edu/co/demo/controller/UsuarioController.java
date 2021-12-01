package cundi.edu.co.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cundi.edu.co.demo.entity.Usuario;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IUsuarioService;

@RestController
@RequestMapping("/registro")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Usuario usuario) throws ConflictException, ModelNotFoundException {
		service.guardar(usuario);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
}

