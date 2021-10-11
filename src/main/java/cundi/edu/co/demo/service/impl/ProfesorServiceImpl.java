package cundi.edu.co.demo.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.controller.EstudianteController;
import cundi.edu.co.demo.controller.ProfesorController;
import cundi.edu.co.demo.dto.UsuarioDto;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IUsuarioService;

@Service
@Qualifier("profesor")
public class ProfesorServiceImpl  implements IUsuarioService {

	@Override
	public UsuarioDto retornar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		UsuarioDto pro  = new UsuarioDto("Carlos", "Quintero","carlos@gmail.com","421217130","tercero","Carlos1223",2, 1);
		pro.add(linkTo(methodOn(ProfesorController.class).guardar(pro)).withRel("crear"));
		return pro;
	}

	@Override
	public UsuarioDto guardar(UsuarioDto estudiante) throws ModelNotFoundException {
		UsuarioDto est = new UsuarioDto("camilo", "vargas", "camilo@gmail.com", "421217180", "Primero",
				"camilo1222", 1, 1);
		addLinkDelete(est, estudiante.getId());
		//addLinkEdit(est);
		addLinkGetById(est, estudiante.getId());
		/*addLinkDelete(est, 1);
		addLinkGetById(est, 1);*/
		return est;
	}

	@Override
	public UsuarioDto editar(UsuarioDto estudiante) throws ModelNotFoundException {
		addLinkDelete(estudiante, estudiante.getId());
		addLinkGetById(estudiante, estudiante.getId());
		return estudiante;
		
	}

	@Override
	public UsuarioDto listarCodigo(String cod) {
		return null;
	}

	@Override
	public void eliminar(int i) {
		// TODO Auto-generated method stub
		
	}
	
	private void addLinkDelete(UsuarioDto estudiante, int id) {
		estudiante.add(linkTo(methodOn(EstudianteController.class).eliminar(id)).withRel("eliminar"));
	}
	
	/*private void addLinkCreate(UsuarioDto estudiante) throws ModelNotFoundException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).guardar(estudiante)).withRel("crear"));
	}*/
	
	/*private void addLinkEdit(UsuarioDto estudiante) throws ModelNotFoundException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).editar(estudiante)).withRel("editar"));
	}*/
	
	private void addLinkGetById(UsuarioDto estudiante, int id) throws ModelNotFoundException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).retonar(id)).withRel("obtenerById"));
	}

}
