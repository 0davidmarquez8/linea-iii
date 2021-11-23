package cundi.edu.co.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.AutorEditorial;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IAutorEditorialRepo;
import cundi.edu.co.demo.service.IAutorEditorialService;

public class AutorEditorialServiceImpl implements IAutorEditorialService{

	@Autowired
	private IAutorEditorialRepo repo;

	@Override
	public Page<AutorEditorial> obtenerPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AutorEditorial> obtenerPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutorEditorial> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutorEditorial retornar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutorEditorial retornarPorId(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutorEditorial guardar(AutorEditorial entity) throws ConflictException, ModelNotFoundException {
		// TODO Auto-generated method stub
		this.repo.guardarNativo(entity.getAutor().getId(), entity.getEditorial().getId(), entity.getFecha());
		return entity;
	}

	@Override
	public AutorEditorial editar(AutorEditorial entity)
			throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AutorEditorial obtenerPorIdJpql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutorEditorial obtenerPorIdSql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNativo(Integer idAutor, Integer idEditorial) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		this.repo.eliminarNativa(idAutor, idEditorial);
	}
	
	

}