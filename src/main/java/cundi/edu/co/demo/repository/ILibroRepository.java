package cundi.edu.co.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cundi.edu.co.demo.entity.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {
	
}
