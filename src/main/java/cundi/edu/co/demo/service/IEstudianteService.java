package cundi.edu.co.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.Estudiante;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface IEstudianteService {

	public Page<Estudiante> obtenerEstudiantesPaginado(int page, int size);
	public Page<Estudiante> obtenerEstudiantesPaginado(Pageable pageable);
	public List<Estudiante> obtenerEstudiantes();
	public Estudiante retornar(int i) throws ModelNotFoundException;
	
	public Estudiante retornarPorId(Integer idEstudiante) throws ModelNotFoundException;
	
	public Estudiante guardar(Estudiante estudiante) throws ConflictException, ModelNotFoundException;
	
	public Estudiante editar(Estudiante estudiante) throws ArgumentRequiredException, ModelNotFoundException, ConflictException;
	
	public Estudiante listarCodigo(String cod);
	
	public void eliminar(int idEstudiante) throws ModelNotFoundException;
}
