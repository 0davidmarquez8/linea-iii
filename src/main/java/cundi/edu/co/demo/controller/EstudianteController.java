package cundi.edu.co.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import cundi.edu.co.demo.dto.UsuarioDto;
import cundi.edu.co.demo.entity.Estudiante;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IEstudianteService;
import cundi.edu.co.demo.service.IUsuarioService;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
@RestController
@Validated
@RequestMapping("/estudiante")
@Api (tags = "Controlador (API's) de estudiantes", description = "Se evidencian todas las API's correspondientes a los estudiantes.")
public class EstudianteController {

	@Autowired
	@Qualifier("estudiante")
	private IEstudianteService service;

	// @RequestMapping(value = "/obtener", method = RequestMethod.GET)
	@ApiOperation(value = "API para obtener un estudiante por su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Estudiante.class ),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping(value = "/obtener/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> retonar(@ApiParam(value = "ID del estudiante a buscar", example = "12", required = true) @PathVariable int id) throws ModelNotFoundException {
		Estudiante estudiante = service.retornar(id);
		return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
	}
	
	@ApiOperation(value = "API para obtener un estudiante por su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Estudiante.class ),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping(value = "/obtener-id/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> retonarPorId(@ApiParam(value = "ID del estudiante a buscar", example = "12", required = true) @PathVariable int id) throws ModelNotFoundException {
		Estudiante estudiante = service.retornarPorId(id);
		return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
	}

	@ApiOperation(value = "API para crear un estudiante")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Agregado correctamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/insertar", consumes = "application/json")
	public ResponseEntity<?> guardar(@Validated @RequestBody Estudiante estudiante) throws ModelNotFoundException, ConflictException {
		Estudiante user = service.guardar(estudiante);
		return new ResponseEntity<Estudiante>(user, HttpStatus.CREATED);
	}

	@ApiOperation(value = "API para actualizar un estudiante")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizado correctamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping(value = "/editar", consumes = "application/json")
	public ResponseEntity<?> editar(@Validated @RequestBody Estudiante estudiante) throws ModelNotFoundException, ArgumentRequiredException, ConflictException {
		Estudiante est = service.editar(estudiante);
		return new ResponseEntity<Object>(est, HttpStatus.OK);
	}

	@ApiOperation(value = "API para obtener un estudiante dado su codigo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Estudiante.class),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@ApiIgnore
	@GetMapping(value = "/listarCodigo/{cod}", produces = "application/json")
	public ResponseEntity<?> listarCodigo(@ApiParam(value = "Codigo del estudiante a buscar", example = "12312", required = true)
			@PathVariable @NotBlank @Pattern(regexp = "^[0-9]{9}$", message = "El codigo debe contener 9 caracteres numericos") String cod) {
		Estudiante estudiante = service.listarCodigo(cod);
		return new ResponseEntity<Object>(estudiante, HttpStatus.OK);
	}
	
	@ApiOperation(value = "API para obtener todos los estudiantes registrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Estudiante.class),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@ApiIgnore
	@GetMapping(value = "/obtener", produces = "application/json")
	public ResponseEntity<?> obtenerEstudiantes() {
		
		List<Estudiante> estudiantes = service.obtenerEstudiantes();
		return new ResponseEntity<List<Estudiante>>(estudiantes, HttpStatus.OK);
	}
	
	@ApiOperation(value = "API para obtener todos los estudiantes registrados, con paginado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Estudiante.class),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@ApiIgnore
	@GetMapping(value = "/obtener-paginado/{page}/{size}", produces = "application/json")
	public ResponseEntity<?> obtenerEstudiantesPaginado(@PathVariable int page, @PathVariable int size) {
		
		Page<Estudiante> estudiantes = service.obtenerEstudiantesPaginado(page, size);
		return new ResponseEntity<Page<Estudiante>>(estudiantes, HttpStatus.OK);
	}
	
	@ApiOperation(value = "API para obtener todos los estudiantes registrados, con paginado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Estudiante.class),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@ApiIgnore
	@GetMapping(value = "/obtener-paginado", produces = "application/json")
	public ResponseEntity<?> obtenerEstudiantesPaginado(Pageable page) {
		Page<Estudiante> estudiantes = service.obtenerEstudiantesPaginado(page);
		return new ResponseEntity<Page<Estudiante>>(estudiantes, HttpStatus.OK);
	}

	@ApiOperation(value = "API para eliminar un estudiante dado su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Eliminado correctamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping(value = "/eliminar/{i}")
	public ResponseEntity<?> eliminar(@ApiParam(value = "ID del estudiante a eliminar", example = "12", required = true) @PathVariable int i) throws ModelNotFoundException {
		service.eliminar(i);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	/*@DeleteMapping(value = "/eliminarHeader/{i}")
	public ResponseEntity<?> eliminarConHeader(@PathVariable int i) {
		HttpHeaders header = new HttpHeaders();
		header.add("info1", "valor 1");
		header.add("info2", "valor 2");
		return new ResponseEntity<Object>(header, HttpStatus.NO_CONTENT);
	}*/

}
