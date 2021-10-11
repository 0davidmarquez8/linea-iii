package cundi.edu.co.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;
@Entity
@Table(name = "estudiante")
public class Estudiante extends RepresentationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Campo requerido.")
	@Size(min = 3, max = 20, message = "Maximo 20 caracteres")
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre; 

	@NotNull(message = "Campo requerido.")
	@Size(min = 7, max = 10, message = "Minimo 7, maximo 10 caracteres")
	@Column(name = "cedula", length = 12, nullable = false, unique = true)
	private String cedula;
	
	@NotNull(message = "Campo requerido.")
	@Size(min = 3, max = 20, message = "Maximo 20 caracteres")
	@Column(name = "apellido", length = 20, nullable = false)
	private String apellido;

	@NotNull(message = "Campo requerido.")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Debe ser un correo valido")
	@Size(min = 3, max = 20, message = "Maximo 60 caracteres")
	@Column(name = "correo", length = 60, nullable = false, unique = true)
	private String correo;

	public Estudiante() {
		super();
	}

	public Estudiante(Integer id, String nombre, String apellido, String correo, String cedula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cedula = cedula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
