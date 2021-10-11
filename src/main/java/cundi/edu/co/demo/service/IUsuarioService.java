package cundi.edu.co.demo.service;

import cundi.edu.co.demo.dto.UsuarioDto;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface IUsuarioService {

	public UsuarioDto retornar(int i) throws ModelNotFoundException;
	
	public UsuarioDto guardar(UsuarioDto estudiante) throws ModelNotFoundException;
	
	public UsuarioDto editar(UsuarioDto estudiante) throws ModelNotFoundException;
	
	public UsuarioDto listarCodigo(String cod);
	
	public void eliminar(int i);
}
