package cundi.edu.co.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.service.IAutorConsulta;
import cundi.edu.co.demo.service.IAutorEditorial;


@Repository
public interface IEditorialRepo extends JpaRepository<Editorial, Integer> {

	//SQL 
		@Query(value = "  SELECT id as id, apellido as apellido, cedula as cedula, correo as correo, nombre as nombre FROM public.autor,public.autor_editorial Where public.autor_editorial.id_editorial = :id and public.autor_editorial.id_autor = public.autor.id ", nativeQuery  = true)
		Page<IAutorConsulta> findByQuery(@Param("id") Long id, Pageable pageable);

		@Query(value = "SELECT public.editorial.nombre as nombreEditorial,public.editorial.correo as correoEditorial,public.editorial.nit as nitEditorial,public.autor.nombre as nombreAutor ,public.autor.apellido as apellidoAutor,public.autor.correo as correoAutor,public.autor.cedula as cedulaAutor "
				+ "FROM public.autor,public.editorial,public.autor_editorial where public.autor_editorial.id_autor = public.autor.id and  public.autor_editorial.id_editorial =public.editorial.id",nativeQuery  = true)
		Page<IAutorEditorial> autoresEditoriales(@Param("id") int id,Pageable pageable);
		
}