package cundi.edu.co.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.dto.AutorDto;
import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.Estudiante;
import cundi.edu.co.demo.entity.Libro;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IAutorRepository;
import cundi.edu.co.demo.service.IAutorService;
import cundi.edu.co.demo.service.IEditorialConsulta;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository repo;

	ModelMapper modelMapper = new ModelMapper();

	
	@Override
	public Autor retornarPorId(Integer id) throws ModelNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));
	}

	@Override
	public Autor guardar(Autor entity) throws ConflictException, ModelNotFoundException {

		if (entity.getLibro() != null) {
            for (Libro libro : entity.getLibro()) {
                libro.setAutor(entity);
            }
        }

		if (repo.existsByCedula(entity.getCedula()))
			throw new ConflictException("La cedula ya se encuentra registrada");

		if (repo.existsByCorreo(entity.getCorreo()))
			throw new ConflictException("El correo ya se encuentra registrado");

		try {
			Autor autor = this.repo.save(entity);

			return autor;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public Autor editar(Autor entity) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		if (entity.getId() != null) {
			if (validarExistenciaPorId(entity.getId())) {

				Autor autorAux = this.repo.findById(entity.getId()).get();
				entity.setLibro(autorAux.getLibro());

				if (entity.getCorreo().equals(autorAux.getCorreo()))
					this.repo.save(entity);
				else {
					if (!repo.existsByCorreo(entity.getCorreo())) {

						this.repo.save(entity);
					} else {
						throw new ConflictException("El correo ya se encuentra registrado");
					}
				}
			} else {
				throw new ModelNotFoundException("El estudiante no existe");
			}
		} else {
			throw new ArgumentRequiredException("Debe agregar el id del usuario");
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
	public Autor obtenerPorIdJpql(Integer id) {
		// TODO Auto-generated method stub
		return this.repo.obtenerPorId(id);
	}

	@Override
	public Autor obtenerPorIdSql(Integer id) {
		return this.repo.obtenerById(id);
	}

	private Boolean validarExistenciaPorId(int idAutor) {
		return this.repo.existsById(idAutor);
	}

	public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {

		return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
	}

	@Override
	public Autor retornar(int i) throws ModelNotFoundException {
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

	@Override
	public Page<Object> obtenerPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Autor> obtenerPaginadog(Pageable pageable) {
		return this.repo.findAll(pageable);
	}

	@Override
	public List<Object> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Object> obtenerPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<IEditorialConsulta> retornarEditorialAutores(Long id, Pageable page) {
		return this.repo.findByQuery(id,page);
	}

}
