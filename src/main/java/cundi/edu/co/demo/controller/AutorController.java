package cundi.edu.co.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.demo.dto.AutorDto;
import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.service.IAutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private IAutorService repo;
	
	@GetMapping(value = "/obtener-paginado", produces = "application/json")
	public ResponseEntity<?> obtenerAutoresPaginado(Pageable page) {
		Page<Autor> autores = repo.obtenerPaginado(page);
		return new ResponseEntity<Page<Autor>>(autores, HttpStatus.OK);
	}
	
	@GetMapping(value = "/obtener-jpql/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorIdJpql(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Autor autor = repo.obtenerPorIdJpql(id);
		AutorDto autorDto = modelMapper.map(autor, AutorDto.class);
		return new ResponseEntity<AutorDto>(autorDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/obtener-sql/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorIdSql(@PathVariable Integer id) {
		Autor estudiantes = repo.obtenerPorIdSql(id);
		return new ResponseEntity<Autor>(estudiantes, HttpStatus.OK);
	}
	
}
