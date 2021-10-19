package cundi.edu.co.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cundi.edu.co.demo.entity.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer> {
	//JPQL
	@Query(value = "Select autor FROM Autor autor WHERE autor.id = :id")
	Autor obtenerPorId(@Param("id") Integer id);
	
	// SQL
	@Query(value = "Select * FROM autor WHERE autor.id = :id", nativeQuery = true)
	Autor obtenerById(@Param("id") Integer id);
}
