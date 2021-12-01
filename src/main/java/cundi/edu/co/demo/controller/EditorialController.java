package cundi.edu.co.demo.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cundi.edu.co.demo.dto.AutorDto;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IAutorConsulta;
import cundi.edu.co.demo.service.IAutorEditorial;
import cundi.edu.co.demo.service.IEditorialService;

@RestController
@RequestMapping("/editoriales")
@PreAuthorize("hasAuthority('Vendedor')")
public class EditorialController {

	@Autowired
	private IEditorialService service;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Editorial editorial) throws ConflictException {
		service.guardar(editorial);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/retornaAutorPorEditorial/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable Long id,Pageable page)throws ModelNotFoundException {
		Page<IAutorConsulta> listaAutor = service.retornarAutoresEditorial(id,page);
		Page<AutorDto> pageAutorDto = service.mapEntityPageIntoDtoPage(listaAutor,AutorDto.class);
		return new ResponseEntity<Object>(pageAutorDto, HttpStatus.OK);
	}

	
	@GetMapping("/retornaAutorEditoriales")
	public ResponseEntity<?> retornarAutorConEditoriales(Pageable page)throws ModelNotFoundException {
		Page<IAutorEditorial> listaAutor = service.retornarPaginado2(page);
		Page<IAutorEditorial> pageAutorDto = service.mapEntityPageIntoDtoPage(listaAutor,IAutorEditorial.class);
		return new ResponseEntity<Object>(pageAutorDto, HttpStatus.OK);
	}


	
}
