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
import org.springframework.security.access.prepost.PreAuthorize;
import ch.qos.logback.core.pattern.Converter;
import cundi.edu.co.demo.dto.AutorDto;
import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.entity.Estudiante;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IAutorEditorialService;
import cundi.edu.co.demo.service.IAutorService;
import cundi.edu.co.demo.service.IEditorialConsulta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/autores")
@Api(tags = "Controlador (API's) de Autores", description = "Se evidencian todas las API's correspondientes a los Autores.")
//@PreAuthorize("hasAuthority('Administrador')")
public class AutorController {

	@Autowired
	private IAutorService repo;
	
	ModelMapper modelMapper = new ModelMapper();

	//@PreAuthorize("hasAuthority('Administrador')  OR hasAuthority('Autor') ")
	@GetMapping(value = "/obtener-paginado/{estado}", produces = "application/json")
	public ResponseEntity<?> obtenerAutoresPaginado(Pageable page, @PathVariable Integer estado) {
		Page<Autor> autores = repo.obtenerPaginadog(page);
		if (estado == 0) {
			// Page<AutorDto> pageAutorDto = autores.map(new Converter<Autor, AutorDto>());

			Page<AutorDto> pageAutorDto = repo.mapEntityPageIntoDtoPage(autores, AutorDto.class);
			return new ResponseEntity<Page<AutorDto>>(pageAutorDto, HttpStatus.OK);
		} else {

			return new ResponseEntity<Page<Autor>>(autores, HttpStatus.OK);
		}
	}
	
	@GetMapping("/retornaEditorialPorAutor/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable Long id,Pageable page)throws ModelNotFoundException {
		Page<IEditorialConsulta> listaAutor = repo.retornarEditorialAutores(id,page);
		Page<Editorial> pageAutorDto = repo.mapEntityPageIntoDtoPage(listaAutor,Editorial.class);
		return new ResponseEntity<Object>(pageAutorDto, HttpStatus.OK);
	}


	@GetMapping(value = "/obtener-jpql/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorIdJpql(@PathVariable Integer id) {
		Object autor = repo.obtenerPorIdJpql(id);
		AutorDto autorDto = modelMapper.map(autor, AutorDto.class);
		return new ResponseEntity<AutorDto>(autorDto, HttpStatus.OK);
	}

	@GetMapping(value = "/obtener-sql/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorIdSql(@PathVariable Integer id) {
		Object autor = repo.obtenerPorIdSql(id);
		return new ResponseEntity<Object>(autor, HttpStatus.OK);
	}

	@GetMapping(value = "/obtene-id/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerAutorPorId(@PathVariable Integer id) throws ModelNotFoundException {
		Object autor = repo.retornarPorId(id);
		return new ResponseEntity<Object>(autor, HttpStatus.OK);
	}

	@ApiOperation(value = "API para crear un estudiante")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Agregado correctamente"),
			@ApiResponse(code = 400, message = "Error en la solicitud"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
			@ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/insertar", produces = "application/json")
	public ResponseEntity<?> guardar(@Validated @RequestBody Autor autor)
			throws ConflictException, ModelNotFoundException {
		Autor estudiantes = repo.guardar(autor);
		return new ResponseEntity<Autor>(estudiantes, HttpStatus.OK); 
	}

	@ApiOperation(value = "API para actualizar un Autor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Actualizado correctamente"),
			@ApiResponse(code = 400, message = "Error en la solicitud"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
			@ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping(value = "/editar", consumes = "application/json")
	public ResponseEntity<?> editar(@Validated @RequestBody Autor autor)
			throws ModelNotFoundException, ArgumentRequiredException, ConflictException {
		Autor aut = repo.editar(autor);
		AutorDto autorDto = modelMapper.map(aut, AutorDto.class);
		return new ResponseEntity<AutorDto>(autorDto, HttpStatus.OK);

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
