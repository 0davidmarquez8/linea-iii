package cundi.edu.co.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IUsuarioService;
import io.swagger.annotations.*;

@RestController
@Validated
@RequestMapping("/profesor")
@Api (tags = "Controlador (API's) de profesores",  description = "Se evidencian todas las API's correspondientes a los profesores.")
public class ProfesorController {

	@Autowired
	@Qualifier("profesor")
	private IUsuarioService service;

	@ApiOperation(value = "API para obtener un profesor por su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = UsuarioDto.class ),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping(value = "/obtener/{id}", produces = "application/json")
	public ResponseEntity<UsuarioDto> retonar(@ApiParam(value = "ID del profesor a buscar", example = "12", required = true) @PathVariable int id) throws ModelNotFoundException {
		UsuarioDto profesor = service.retornar(id);
		return new ResponseEntity<UsuarioDto>(profesor, HttpStatus.OK);

	}

	@ApiOperation(value = "API para crear un profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Agregado correctamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/insertar", consumes = "application/json")
	public ResponseEntity<?> guardar(@Validated @RequestBody UsuarioDto profesor) {
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "API para actualizar un profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizado correctamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping(value = "/editar", consumes = "application/json")
	public ResponseEntity<?> editar(@Validated @RequestBody UsuarioDto profesor) throws ModelNotFoundException {
		UsuarioDto est = service.editar(profesor);
		return new ResponseEntity<Object>(est, HttpStatus.OK);
	}

	// 204
	@ApiOperation(value = "API para eliminar un profesor dado su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Eliminado correctamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 403, message = "No tiene permisos para acceder al recurso"),
            @ApiResponse(code = 401, message = "No esta autenticado para acceder al recurso"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping(value = "/eliminar/{i}") 
	public ResponseEntity<?> eliminar(@ApiParam(value = "ID del profesor a eliminar", example = "12", required = true) @PathVariable int id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
