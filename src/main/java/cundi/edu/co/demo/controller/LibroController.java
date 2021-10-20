package cundi.edu.co.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.demo.entity.Libro;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

import cundi.edu.co.demo.service.ILibroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/libro")
@Api(tags = "Controlador (API's) de Libro", description = "Se evidencian todas las API's correspondientes a los libro.")
public class LibroController {
	@Autowired
	private ILibroService repo;
	
	
	@GetMapping(value = "/obtener-paginado", produces = "application/json")
	public ResponseEntity<?> obtenerAutoresPaginado(Pageable page) {
		Page<Libro> libro = repo.obtenerPaginado(page);
		return new ResponseEntity<Page<Libro>>(libro, HttpStatus.OK);
	}


	@GetMapping(value = "/obtener-sql/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorIdSql(@PathVariable Integer id) {
		Libro libro = repo.obtenerPorIdSql(id);
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

	@GetMapping(value = "/obtene-id/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorId(@PathVariable Integer id) throws ModelNotFoundException {
		Libro libro = repo.retornarPorId(id);
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

	@ApiOperation(value = "API para crear un estudiante")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Agregado correctamente"),
			@ApiResponse(code = 400, message = "Error en la solicitud"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
			@ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/insertar", produces = "application/json")
	public ResponseEntity<?> guardar(@Validated @RequestBody Libro autor)
			throws ConflictException, ModelNotFoundException {
		Libro libro = repo.guardar(autor);
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

	@ApiOperation(value = "API para actualizar un Autor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Actualizado correctamente"),
			@ApiResponse(code = 400, message = "Error en la solicitud"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
			@ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping(value = "/editar", consumes = "application/json")
	public ResponseEntity<?> editar(@Validated @RequestBody Libro autor)
			throws ModelNotFoundException, ArgumentRequiredException, ConflictException {
		Libro est = repo.editar(autor);
		return new ResponseEntity<Object>(est, HttpStatus.OK);
	}

	@ApiOperation(value = "API para eliminar un autor dado su Id")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Eliminado correctamente"),
			@ApiResponse(code = 400, message = "Error en la solicitud"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
			@ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping(value = "/eliminar/{i}")
	public ResponseEntity<?> eliminar(
			@ApiParam(value = "ID del autor a eliminar", example = "12", required = true) @PathVariable int i)
			throws ModelNotFoundException {
		repo.eliminar(i);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
