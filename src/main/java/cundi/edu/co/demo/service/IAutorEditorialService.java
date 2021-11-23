package cundi.edu.co.demo.service;

import cundi.edu.co.demo.entity.AutorEditorial;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface IAutorEditorialService extends ICrud<AutorEditorial, Integer> {

	public void eliminarNativo(Integer idAutor, Integer idEditorial) throws ModelNotFoundException;	
}