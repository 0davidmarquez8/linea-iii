package cundi.edu.co.demo.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.Libro;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface ILibroService extends ICrud<Object, Integer> {

	public Libro editar(Libro entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException;
	public Libro guardar(Libro entity) throws ConflictException, ModelNotFoundException;
	public Page<Libro> obtenerPaginadol(Pageable pageable);
}
