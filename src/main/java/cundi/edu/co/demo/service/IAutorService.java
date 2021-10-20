package cundi.edu.co.demo.service;

import org.springframework.data.domain.Page;

import cundi.edu.co.demo.entity.Autor;

public interface IAutorService extends ICrud<Autor, Integer> {
	public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass);
}
