package cundi.edu.co.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cundi.edu.co.demo.entity.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {
	
	public Estudiante findByCedula(String cedula);
	
	public Estudiante findByCorreo(String correo);
	
	public Boolean existsByCedula(String cedula);
	
	public Boolean existsByCorreo(String correo);
	
	// Consulta jpql; y metodo consulta nativa el de existsbycedula
	
	// FindBy dos variables
}
