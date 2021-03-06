package cundi.edu.co.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cundi.edu.co.demo.entity.Usuario;

@Repository
public interface IUsuarioRepo  extends JpaRepository<Usuario, Integer> {

	Usuario findOneByNick(String nick);
   
	public Boolean existsByNick(String nick);
	
	public Boolean existsByDocumento(String documento);
}
