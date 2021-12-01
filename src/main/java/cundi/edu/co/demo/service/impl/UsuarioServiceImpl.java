package cundi.edu.co.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.entity.Rol;
import cundi.edu.co.demo.entity.Usuario;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IUsuarioRepo;
import cundi.edu.co.demo.service.IUsuarioService;
import org.springframework.security.core.GrantedAuthority;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {
	
	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Usuario usuario = repo.findOneByNick(username);		
		if(usuario == null)
			new UsernameNotFoundException("----Usuario no encontrado");
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
		UserDetails ud = new User(usuario.getNick(), usuario.getClave(), roles);
		return ud;
	}

	@Override
	public void guardar(Usuario usuario) throws ConflictException {		
		String clave = usuario.getClave();
		usuario.setClave(bcrypt.encode(clave));
		if(repo.existsByNick(usuario.getNick())) {
			 throw new ConflictException("Nick ya existe");
		 }
		 if(repo.existsByDocumento(usuario.getDocumento())) {
			 throw new ConflictException("Documento ya existe");
		 }	 
		repo.save(usuario);
	}

	@Override
	public void editar(Usuario obj) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(int obj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Usuario> obtenerPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> obtenerPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario retornar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario retornarPorId(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerPorIdJpql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerPorIdSql(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}