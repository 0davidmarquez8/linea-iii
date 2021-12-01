package cundi.edu.co.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.AutorEditorial;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface IAutorEditorialService  extends ICrud<AutorEditorial, Integer> {

	public void eliminarNativo(Integer idAutor, Integer idEditorial) throws ModelNotFoundException;

	void guardar(AutorEditorial obj) throws ConflictException;	
	
	public  Page<IEditorialConsulta>  retornarEditorialAutores(Long id,Pageable page);
}

