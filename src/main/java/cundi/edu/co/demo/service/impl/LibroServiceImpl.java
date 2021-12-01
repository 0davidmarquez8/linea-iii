package cundi.edu.co.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.Libro;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.ILibroRepository;
import cundi.edu.co.demo.service.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository repo;



	@Override
	public Page<Libro> obtenerPaginadol(Pageable pageable) {
		return this.repo.findAll(pageable);
	}

	@Override
	public Libro retornarPorId(Integer id) throws ModelNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));
	}

	@Override
	public Libro guardar(Libro entity) throws ConflictException, ModelNotFoundException {

		Libro libro = this.repo.save(entity);
		return libro;

	}

	@Override
	public Libro editar(Libro entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		if (entity.getId() != null) {
			if (validarExistenciaPorId(entity.getId())) {

				Libro libroAux = this.repo.findById(entity.getId()).get();

				this.repo.save(entity);

			} else {
				throw new ModelNotFoundException("El libro no existe");
			}
		} else {
			throw new ArgumentRequiredException("Debe agregar el id del libro");
		}

		return entity;
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		if (this.repo.existsById(id))
			this.repo.deleteById(id);
		else
			throw new ModelNotFoundException("Autor no encontrado");
	}


	@Override
	public Libro retornar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Libro obtenerPorIdJpql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro obtenerPorIdSql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	private Boolean validarExistenciaPorId(int idLibro) {
		return this.repo.existsById(idLibro);
	}

	@Override
	public Page<Object> obtenerPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Object> obtenerPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Object entity) throws ConflictException, ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Object entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		
	}

}
