package cundi.edu.co.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModelProperty;

@Validated
public class UsuarioDto extends RepresentationModel {
	
	@NotNull(message = "Es requerido")
	@ApiModelProperty(example = "1")
	private int id;
	@NotNull(message = "Es requerido")
	@ApiModelProperty(position = 0, example = "David")
	private String nombre;
	@NotNull(message = "Es requerido")
	@ApiModelProperty(position = 1, example = "Vargas")
	private String apellido;
	@NotNull(message = "Es requerido")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Debe ser un correo valido")
	@ApiModelProperty(position = 2, example = "david@gmail.com")
	private String correo;

	@NotNull(message = "Es requerido")
	@Pattern(regexp = "^[0-9]{9}$", message="El codigo debe contener 9 caracteres numericos")
	@ApiModelProperty(position = 3, example = "201124-2")
	private String codigo;

	@NotNull(message = "Es requerido")
	@ApiModelProperty(position = 4, example = "Primero", required = true)
	private String curso;
	
	@NotNull(message = "Es requerido")
	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+=?]{8,16}$", message="Debe contener minimo 8 y maximo 16 caracteres")
	@ApiModelProperty(position = 5, example = "asd123fgd")
	private String contrasena;
	
	@NotNull(message = "Es requerido")
	@ApiModelProperty(position = 6, example = "1")
	private int tipo;
	
	public int getId() {
		return tipo;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public UsuarioDto() {

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
	

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public UsuarioDto(String nombre, String apellido, String correo, String codigo, String curso, String contrasena, int tipo, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.codigo = codigo;
		this.curso = curso;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.id = id;
	}

	
	



}
