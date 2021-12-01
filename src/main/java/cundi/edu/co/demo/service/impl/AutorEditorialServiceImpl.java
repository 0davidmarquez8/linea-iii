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
import cundi.edu.co.demo.service.IEditorialConsulta;

public class AutorEditorialServiceImpl implements IAutorEditorialService{

	@Autowired
	private IAutorEditorialRepo repo;
	

	@Override
	public void guardar(AutorEditorial obj) throws ConflictException {
		//Agregar validaciones respectivas
		this.repo.guardarNativo(obj.getAutor().getId(), obj.getEditorial().getId(), obj.getFecha());
	}

	@Override
	public void editar(AutorEditorial obj) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		//Generalmente no se utiliza el editar en una table intermedia 
	}

	@Override
	public void eliminar(int obj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminarNativo(Integer idAutor, Integer idEditorial) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		//Validaciones pertinentes
		this.repo.eliminarNativa(idAutor, idEditorial);
	}

	@Override
	public Page<IEditorialConsulta> retornarEditorialAutores(Long id, Pageable page) {
		return this.repo.findByQuery(id,page);
	}

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
	public AutorEditorial obtenerPorIdJpql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutorEditorial obtenerPorIdSql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}