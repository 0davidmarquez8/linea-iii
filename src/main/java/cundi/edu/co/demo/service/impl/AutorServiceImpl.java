package cundi.edu.co.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IAutorRepository;
import cundi.edu.co.demo.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository repo;
	
	@Override
	public Page<Autor> obtenerPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Autor> obtenerPaginado(Pageable pageable) {
		return this.repo.findAll(pageable);
	}

	@Override
	public List<Autor> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor retornar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor retornarPorId(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor guardar(Autor entity) throws ConflictException, ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor editar(Autor entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	

}
