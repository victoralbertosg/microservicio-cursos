package com.titannet.microserviceUsuario.controllers;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.titannet.microserviceUsuario.services.AlumnoService;
import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commonscontrollers.CommonController;

@RestController
public class alumnoController extends CommonController<Alumno,AlumnoService> {
	
		
	@PutMapping ("{Id}")
	public ResponseEntity<?> editar (@RequestBody Alumno alumno, @PathVariable Long Id){
		Optional <Alumno> o= service.findById(Id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDb=o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));	
	}
	
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}

	
}
