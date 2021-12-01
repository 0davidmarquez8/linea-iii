package cundi.edu.co.demo.service.impl;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.dto.AutorDto;
import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.AutorEditorial;
import cundi.edu.co.demo.entity.AutorEditorialPK;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IEditorialRepo;
import cundi.edu.co.demo.service.IAutorConsulta;
import cundi.edu.co.demo.service.IAutorEditorial;
import cundi.edu.co.demo.service.IEditorialService;

@Service
public class EditorialServiceImpl implements IEditorialService {

	@Autowired
	private IEditorialRepo repo;
	
	Object autores= null;
	
	@Override
	public void guardar(Editorial editorial) throws ConflictException{
		repo.save(editorial);	
	}
	@Override
	public Page<IAutorConsulta> retornarAutoresEditorial(Long id,Pageable page) {
		return this.repo.findByQuery(id,page);
	}
	
	public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
		ModelMapper modelMapper = new ModelMapper();
		return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
	}
	

	@Override
	public Page<IAutorEditorial> retornarPaginado2(Pageable page) {
		int id;
        id =1;
		return this.repo.autoresEditoriales(id,page);
	}

	@Override
	public void editar(Editorial obj) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int obj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Autor>  retonarPorId(Integer obj, Pageable page) throws ModelNotFoundException {
		return null;
	}

	@Override
	public Page<Editorial> obtenerPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Editorial> obtenerPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Editorial> obtener() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Editorial retornar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Editorial retornarPorId(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Editorial obtenerPorIdJpql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Editorial obtenerPorIdSql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
