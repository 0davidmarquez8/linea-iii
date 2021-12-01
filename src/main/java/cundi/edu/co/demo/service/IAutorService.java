package cundi.edu.co.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface IAutorService extends ICrud<Object, Integer> {
	
	public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass);
	
	public Autor editar(Autor entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException;
	
	public Autor guardar(Autor entity) throws ConflictException, ModelNotFoundException;
	
	public Page<Autor> obtenerPaginadog(Pageable pageable);

	public Page<IEditorialConsulta> retornarEditorialAutores(Long id, Pageable page);

}
