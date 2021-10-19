package cundi.edu.co.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface ICrud<T, I> {

	public Page<T> obtenerPaginado(int page, int size);
	public Page<T> obtenerPaginado(Pageable pageable);
	public List<T> obtener();
	public T retornar(int i) throws ModelNotFoundException;
	
	public T retornarPorId(I id) throws ModelNotFoundException;
	
	public T guardar(T entity) throws ConflictException, ModelNotFoundException;
	
	public T editar(T entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException;
	
	public void eliminar(int id) throws ModelNotFoundException;
	
	T obtenerPorIdJpql(Integer id);
	
	T obtenerPorIdSql(Integer id);
	
}
