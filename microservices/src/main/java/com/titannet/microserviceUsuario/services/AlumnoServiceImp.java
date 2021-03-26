package com.titannet.microserviceUsuario.services;



import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.microserviceUsuario.models.repository.AlumnoRepository;
import com.titannet.microservivios.commons.alumnos.entity.Alumno;
import com.titannet.microservivios.commons.services.CommonServiceImp;

@Service
public class AlumnoServiceImp extends CommonServiceImp<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly=true)
	public List<Alumno> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}

}
