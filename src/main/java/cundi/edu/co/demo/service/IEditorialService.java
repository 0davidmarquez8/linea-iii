package cundi.edu.co.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface IEditorialService  extends ICrud<Editorial, Integer> {
	
	void guardar(Editorial editorial) throws ConflictException;

	public Object retonarPorId(Integer obj,Pageable page) throws ModelNotFoundException;
	
	public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass);

	public  Page<IAutorConsulta>  retornarAutoresEditorial(Long id,Pageable page);
	
	public Page<IAutorEditorial> retornarPaginado2(Pageable page);

}
