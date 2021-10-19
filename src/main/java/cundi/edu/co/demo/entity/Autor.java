package cundi.edu.co.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
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

	@OneToMany(mappedBy = "autor", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Libro> libro;
	
	public Autor() {
		super();
	}
	
	public Autor(
			String nombre, String cedula, String apellido, String correo) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.apellido = apellido;
		this.correo = correo;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	//@JsonIgnore
	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}
	
	
}
