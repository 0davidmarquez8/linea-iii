package cundi.edu.co.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "libro")
public class Libro {
	// REvisar temas de fechas que no es datetime, timestamp mirar la version de spring
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Campo requerido.")
	@Size(min = 3, max = 20, message = "Maximo 20 caracteres")
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre; 
	
	@NotNull(message = "Campo requerido.")
	@Size(min = 3, max = 200, message = "Maximo 20 caracteres")
	@Column(name = "descripcion", length = 200, nullable = false, columnDefinition = "TEXT")
	private String descripcion; 
	
	// Agregar campo de fecha de publicacion
	
	@NotNull(message = "Campo requerido.")
	@Column(name = "numero_paginas", nullable = false)
	private Integer numeroPaginas;
	
	@NotNull(message = "Campo requerido.")
	@Column(name = "fecha_publicacion", nullable = false)
	private LocalDate fechaPublicacion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false, foreignKey = @ForeignKey(name = "FK_Autor_Libro"))
	private Autor autor;

	public Libro() {
		super();
	}
	


	public Libro(Integer id,
			 String nombre,
			 String descripcion,
			 Integer numeroPaginas,
			 LocalDate fechaPublicacion, Autor autor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroPaginas = numeroPaginas;
		this.fechaPublicacion = fechaPublicacion;
		this.autor = autor;
	}



	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}



	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@JsonProperty(access = Access.WRITE_ONLY)
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
}
