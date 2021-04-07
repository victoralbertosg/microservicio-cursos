package com.titannet.microservivios.app.cursos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.titannet.microservivios.app.cursos.models.entity.Curso;
import com.titannet.microservivios.app.cursos.services.CursoService;
import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.examenes.entity.Examen;
import com.titannet.microservivios.commonscontrollers.CommonController;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping ("/balanceador-test")
	public ResponseEntity<?> balanceadorTest(){
		Map<String,Object> response= new HashMap<String,Object>();
		response.put("balanceador", balanceadorTest);
		response.put("cursos",service.findAll());
		return ResponseEntity.ok(response);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Curso curso,@PathVariable Long id){
		
		Optional<Curso> o=this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();			
		}
		
		Curso dbCurso=o.get();
		dbCurso.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos (@RequestBody List<Alumno> alumnos,@PathVariable Long id){
		
		Optional<Curso> o=this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();			
		}
		
		Curso dbCurso=o.get();
		
		alumnos.forEach(a->{
			dbCurso.addAlumno(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno (@RequestBody Alumno alumno,@PathVariable Long id){
		
		Optional<Curso> o=this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();			
		}
		
		Curso dbCurso=o.get();
		
		dbCurso.removeAlumno(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes,@PathVariable Long id){
		
		Optional<Curso> o=this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso=o.get();
		examenes.forEach(e->{
			dbCurso.addExamen(e);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?>eliminarExamen(@Valid @RequestBody Examen examen,BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curso> o=this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso=o.get();
		dbCurso.removeExamen(examen);;
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	

	
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id){
		Curso curso=service.findCursoByAlumno(id);
		if (curso!=null) {
			List<Long> examenesIds= (List<Long>) service.obtenerExamenesIdsConRespuestasAlumno(id);
			List<Examen> examenes=curso.getExamenes().stream().map(examen->{
				if (examenesIds.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;				
			}).collect(Collectors.toList());
			curso.setExamenes(examenes);			
		}		
		
		return ResponseEntity.ok(curso);
	}
}
