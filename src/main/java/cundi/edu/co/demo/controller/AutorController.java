package cundi.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.service.IAutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private IAutorService repo;
	
	@GetMapping(value = "/obtener-paginado", produces = "application/json")
	public ResponseEntity<?> obtenerEstudiantesPaginado(Pageable page) {
		Page<Autor> estudiantes = repo.obtenerPaginado(page);
		return new ResponseEntity<Page<Autor>>(estudiantes, HttpStatus.OK);
	}
	
}
