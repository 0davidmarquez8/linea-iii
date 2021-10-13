package cundi.edu.co.demo.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.controller.EstudianteController;
import cundi.edu.co.demo.entity.Estudiante;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IEstudianteRepository;
import cundi.edu.co.demo.service.IEstudianteService;
@Service
@Qualifier("estudiante")
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository repo;
	
	@Override
	public Estudiante retornar(int i) throws ModelNotFoundException {
		if (i <= 10) {
			/*Estudiante est = new UsuarioDto("camilo", "vargas", "camilo@gmail.com", "421217180", "Primero",
					"camilo1222", 1, 1);
			addLinkDelete(est, i);
			addLinkEdit(est);*/
			return null;
		}else {
			throw new ModelNotFoundException("estudiante no encontrado");
			/*try {
				int x = 0;
				int a =5/x;
			} catch (ArithmeticException e) {
				throw new ArithmeticException("No se puede dividir por 0");
			} catch (NullPointerException e) {
				throw new ArithmeticException("Objeto no asignado");
			}catch (Exception e) {
				throw new ArithmeticException("Error");
			}*/
		}
	}

	@Override
	public Estudiante guardar(Estudiante estudiante) throws ConflictException, ModelNotFoundException {
		//Estudiante estudianteBusqueda = this.repo.findByCedula(estudiante.getCedula());
		/*if(estudianteBusqueda == null) {			
			Estudiante estu = this.repo.save(estudiante);
			addLinkDelete(estu, estudiante.getId());
			addLinkEdit(estu);
			addLinkGetById(estu, estudiante.getId());
			return estu;
		} else {
			throw new ConflictException("La cedula ya se encuentra registrada");
		}*/
		
		if(repo.existsByCedula(estudiante.getCedula()))
			throw new ConflictException("La cedula ya se encuentra registrada");
		
		if(repo.existsByCorreo(estudiante.getCorreo()))
			throw new ConflictException("El correo ya se encuentra registrado");
		
		try {			
			Estudiante estu = this.repo.save(estudiante);
			addLinkDelete(estu, estudiante.getId());
			addLinkEdit(estu);
			addLinkGetById(estu, estudiante.getId());
			return estu;
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<Estudiante> obtenerEstudiantes() {
		return this.repo.findAll();
		//return null;
	}
	
	@Override
	public Page<Estudiante> obtenerEstudiantesPaginado(int page, int size) {
		return this.repo.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public Page<Estudiante> obtenerEstudiantesPaginado(Pageable pageable) {
		return this.repo.findAll(pageable);
	}
	
	@Override
	public Estudiante editar(Estudiante estudiante) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		
		if(estudiante.getId() != null) {
			if(validarExistenciaPorId(estudiante.getId())) {
				
				Estudiante estudianteAux = this.repo.findById(estudiante.getId()).get();
				
				estudiante.setCedula(estudianteAux.getCedula());
				
				if(estudiante.getCorreo().equals(estudianteAux.getCorreo()))
					this.repo.save(estudiante);
				else {
					if(!repo.existsByCorreo(estudiante.getCorreo())) {
						this.repo.save(estudiante);
					}else {
						throw new ConflictException("El correo ya se encuentra registrado");
					}
				}
			}else {
				throw new ModelNotFoundException("El estudiante no existe");
			}
		}else {
			throw new ArgumentRequiredException("Debe agregar el id del usuario");
		}
		
		addLinkDelete(estudiante, estudiante.getId());
		addLinkGetById(estudiante, estudiante.getId());
		return estudiante;

	}
	
	@Override
	public Estudiante retornarPorId(Integer idEstudiante) throws ModelNotFoundException {
		return repo.findById(idEstudiante).orElseThrow(() -> new ModelNotFoundException("Estudiante no encontrado"));
	}

	@Override
	public void eliminar(int idEstudiante) throws ModelNotFoundException {
		if(this.repo.existsById(idEstudiante))
			this.repo.deleteById(idEstudiante);
		else
			throw new ModelNotFoundException("estudiante no encontrado");
	}

	@Override
	public Estudiante listarCodigo(String cod) {
		// TODO Auto-generated method stub
		/*Estudiante est = new UsuarioDto("camilo", "vargas", "camilo@gmail.com", "421217180", "Primero", "camilo1222", 1, 1);*/
		return null;
	}
	
	private Boolean validarExistenciaPorId(int idEstudiante) {
		return this.repo.existsById(idEstudiante);
	}
	
	private void addLinkDelete(Estudiante estudiante, int id) throws ModelNotFoundException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).eliminar(id)).withRel("eliminar"));
	}
	
	private void addLinkCreate(Estudiante estudiante) throws ModelNotFoundException, ConflictException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).guardar(estudiante)).withRel("crear"));
	}
	
	private void addLinkEdit(Estudiante estudiante) throws ModelNotFoundException, ArgumentRequiredException, ConflictException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).editar(estudiante)).withRel("editar"));
	}
	
	private void addLinkGetById(Estudiante estudiante, int id) throws ModelNotFoundException {
		estudiante.add(linkTo(methodOn(EstudianteController.class).retonar(id)).withRel("obtenerById"));
	}

	

	

	

	
}
