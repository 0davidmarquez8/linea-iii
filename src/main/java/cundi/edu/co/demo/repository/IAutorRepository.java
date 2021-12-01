package cundi.edu.co.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.service.IEditorialConsulta;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer> {
	//JPQL
	@Query(value = "Select autor FROM Autor autor WHERE autor.id = :id")
	Autor obtenerPorId(@Param("id") Integer id);
	
	// SQL
	@Query(value = "Select * FROM autor WHERE autor.id = :id", nativeQuery = true)
	Autor obtenerById(@Param("id") Integer id);
	
	//SQL 
		@Query(value = "  SELECT id as id , correo as correo, nit as nit , nombre as nombre FROM public.editorial ,public.autor_editorial Where public.autor_editorial.id_autor = :id and  public.autor_editorial.id_editorial = public.editorial.id", nativeQuery  = true)
		Page<IEditorialConsulta> findByQuery(@Param("id") Long id, Pageable pageable);
		
	public Boolean existsByCorreo(String correo);
	public Boolean existsByCedula(String cedula);
}
